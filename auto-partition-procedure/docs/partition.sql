


-- 创建存储过程：


-- DROP PROCEDURE public.proc_create_partition(text, text, int4);

CREATE OR REPLACE PROCEDURE public.proc_create_partition(table_name text, period_unit text, _period integer)
 LANGUAGE plpgsql
AS $procedure$
DECLARE
    -- 当前周期的分区表名称、时间下界、时间上界
table1_name text;
    table1_floor text;
    table1_ceil text;
    -- 下一周期的分区表名称、时间下界、时间上界
    table2_name text;
    table2_floor text;
    table2_ceil text;
    -- 分区间隔
    PERIOD_INTERVAL text;
BEGIN
    if _period <= 0 then
        raise exception 'Invalid _period param: %, input positive number instead.', _period;
end if;
    PERIOD_INTERVAL = _period || ' ' || period_unit;

    if lower(period_unit) = 'year' then
        table1_name := table_name || '_y' || to_char(NOW(), 'YYYY') || 'm01d01';
        table2_name := table_name || '_y' || to_char(NOW() + PERIOD_INTERVAL::INTERVAL, 'YYYY') || 'm01d01';
    elsif lower(period_unit) = 'month' then
        table1_name := table_name || '_y' || to_char(NOW(), 'YYYYmMM') || 'd01';
        table2_name := table_name || '_y' || to_char(NOW() + PERIOD_INTERVAL::INTERVAL, 'YYYYmMM') || 'd01';
    elsif lower(period_unit) = 'day' then
        table1_name := table_name || '_y' || to_char(NOW(), 'YYYYmMM') || 'd' || to_char(NOW(), 'DD');
        table2_name := table_name || '_y' || to_char(NOW() + PERIOD_INTERVAL::INTERVAL, 'YYYYmMM') || 'd' || to_char(NOW() + PERIOD_INTERVAL::INTERVAL, 'DD');
ELSE
        raise exception 'Unrecognized period_unit param: %, input day/month/year instead.', period_unit;
end if;

    table1_floor := DATE_TRUNC(period_unit, CURRENT_DATE);
    table1_ceil := DATE_TRUNC(period_unit, CURRENT_DATE) + PERIOD_INTERVAL::INTERVAL;

    table2_floor := DATE_TRUNC(period_unit, CURRENT_DATE) + PERIOD_INTERVAL::INTERVAL;
    table2_ceil := DATE_TRUNC(period_unit, CURRENT_DATE) + PERIOD_INTERVAL::INTERVAL + PERIOD_INTERVAL::INTERVAL;

    -- 创建当前周期分区表
    if not exists (
        select 1 from information_schema.tables
            where tables.table_name = table1_name
    ) then
        execute format('CREATE TABLE %I PARTITION OF ' || table_name || ' FOR VALUES FROM (%L) TO (%L)',
            table1_name, table1_floor, table1_ceil);
        raise notice 'Partition % added', table1_name;
end if;
    -- 创建下个周期分区表
    if not exists (
        select 1 from information_schema.tables
            where tables.table_name = table2_name
    ) then
        execute format('CREATE TABLE %I PARTITION OF ' || table_name || ' FOR VALUES FROM (%L) TO (%L)',
            table2_name, table2_floor, table2_ceil);
        raise notice 'Partition % added', table2_name;
end if;
END;
$procedure$
;