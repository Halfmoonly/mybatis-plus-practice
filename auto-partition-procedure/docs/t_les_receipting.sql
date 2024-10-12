-- 创建表t_les_receipting，并且指定PARTITION BY RANGE (add_time);


-- public.t_les_receipting definition

-- Drop table

-- DROP TABLE public.t_les_receipting;

CREATE TABLE public.t_les_receipting (
                                         id int8 NOT NULL, -- 数据ID
                                         receipting_code varchar(64) NOT NULL, -- 签收单号
                                         receipting_time timestamp NULL, -- 签收时间
                                         receipting_user_code varchar(64) NULL, -- 签收人工号
                                         receipting_user_name varchar(64) NULL, -- 签收人名称
                                         receipting_quantity numeric(18, 4) NULL, -- 签收数量
                                         receipting_piece numeric(18, 4) NULL, -- 签收件数
                                         receipting_status varchar(64) DEFAULT 'UNRECEIPT'::character varying NOT NULL, -- 签收状态：UNRECEIPT-未签收 RECEIPTED-已签收 WAREHOUSED-已入库
                                         receipting_warehouse varchar(64) NULL, -- 签收仓库代码
                                         receipting_zone varchar(64) NULL, -- 签收区域代码
                                         receipting_bin varchar(64) NULL, -- 签收储位
                                         receipting_source varchar(64) NOT NULL, -- 签收来源：LES WMS
                                         material_code varchar(128) NOT NULL, -- 物料编码
                                         material_name varchar(128) NOT NULL, -- 物料名称
                                         material_version varchar(128) NOT NULL, -- 物料版本
                                         material_unit varchar(32) NOT NULL, -- 物料单位
                                         material_piece numeric(18, 4) NOT NULL, -- 物料件数
                                         material_quantity numeric(18, 4) NOT NULL, -- 物料数量（配送数量/拣配数量）
                                         material_supplier varchar(64) NULL, -- 指定物料供应商
                                         material_batch_no varchar(64) NULL, -- 指定物料批次号
                                         demand_code varchar(32) NOT NULL, -- 需求单号
                                         demand_no int4 NOT NULL, -- 需求单行号
                                         demand_quantity numeric(18, 4) NOT NULL, -- 需求数量
                                         demand_time timestamp NULL, -- 需求时间
                                         demand_factory varchar(32) NULL, -- 需求工厂代码
                                         demand_warehouse varchar(128) NULL, -- 需求仓库代码
                                         demand_zone varchar(128) NULL, -- 需求区域代码
                                         demand_station varchar(128) NULL, -- 需求工位代码
                                         demand_bin varchar(128) NULL, -- 需求储位代码
                                         demand_sap varchar(128) NULL, -- 需求SAP库位代码
                                         demand_rcs_station varchar(128) NULL, -- 需求AGV站点
                                         supply_factory varchar(32) NULL, -- 供应工厂代码
                                         supply_warehouse varchar(128) NULL, -- 供应仓库代码
                                         supply_zone varchar(128) NULL, -- 供应区域代码
                                         supply_area varchar(128) NULL, -- 供应区号代码
                                         supply_bin varchar(128) NULL, -- 供应储位代码
                                         supply_sap varchar(128) NULL, -- 供应SAP库位代码
                                         picking_code varchar(32) NULL, -- 拣配单号
                                         picking_line_no int4 NULL, -- 拣配单行号
                                         transport_code varchar(64) NULL, -- 配送单号
                                         transport_line_code int4 NULL, -- 配送单行号
                                         box_inv varchar(128) NULL, -- 箱INV信息
                                         box_code varchar(128) NULL, -- 箱条码信息
                                         box_batch_no varchar(128) NULL, -- 箱批次信息
                                         container_code varchar(64) NULL, -- 容器编码
                                         packing_serial_no varchar(64) NULL, -- 组箱流水号
                                         factory_code varchar(32) NULL, -- 工厂编码
                                         add_user_name varchar(128) NOT NULL, -- 创建人
                                         add_user_code varchar(128) NOT NULL, -- 创建人工号
                                         add_time timestamp NOT NULL, -- 创建时间
                                         edit_time timestamp NOT NULL, -- 更新时间
                                         edit_user_name varchar(128) NOT NULL, -- 更新人
                                         edit_user_code varchar(128) NOT NULL, -- 更新人工号
                                         data_status int2 NULL, -- 数据状态：0-正常 1-删除
                                         receipting_type varchar(64) DEFAULT 'AUTO'::character varying NULL, -- 签收类型：AUTO-自动 MANUAL-手动
                                         CONSTRAINT t_les_receipting_pkey PRIMARY KEY (id, add_time)
)
    PARTITION BY RANGE (add_time);
CREATE UNIQUE INDEX t_les_receipting_unique ON ONLY public.t_les_receipting USING btree (add_time, receipting_code);
COMMENT ON TABLE public.t_les_receipting IS '入库签收单表';

-- Column comments

COMMENT ON COLUMN public.t_les_receipting.id IS '数据ID';
COMMENT ON COLUMN public.t_les_receipting.receipting_code IS '签收单号';
COMMENT ON COLUMN public.t_les_receipting.receipting_time IS '签收时间';
COMMENT ON COLUMN public.t_les_receipting.receipting_user_code IS '签收人工号';
COMMENT ON COLUMN public.t_les_receipting.receipting_user_name IS '签收人名称';
COMMENT ON COLUMN public.t_les_receipting.receipting_quantity IS '签收数量';
COMMENT ON COLUMN public.t_les_receipting.receipting_piece IS '签收件数';
COMMENT ON COLUMN public.t_les_receipting.receipting_status IS '签收状态：UNRECEIPT-未签收 RECEIPTED-已签收 WAREHOUSED-已入库';
COMMENT ON COLUMN public.t_les_receipting.receipting_warehouse IS '签收仓库代码';
COMMENT ON COLUMN public.t_les_receipting.receipting_zone IS '签收区域代码';
COMMENT ON COLUMN public.t_les_receipting.receipting_bin IS '签收储位';
COMMENT ON COLUMN public.t_les_receipting.receipting_source IS '签收来源：LES WMS';
COMMENT ON COLUMN public.t_les_receipting.material_code IS '物料编码';
COMMENT ON COLUMN public.t_les_receipting.material_name IS '物料名称';
COMMENT ON COLUMN public.t_les_receipting.material_version IS '物料版本';
COMMENT ON COLUMN public.t_les_receipting.material_unit IS '物料单位';
COMMENT ON COLUMN public.t_les_receipting.material_piece IS '物料件数';
COMMENT ON COLUMN public.t_les_receipting.material_quantity IS '物料数量（配送数量/拣配数量）';
COMMENT ON COLUMN public.t_les_receipting.material_supplier IS '指定物料供应商';
COMMENT ON COLUMN public.t_les_receipting.material_batch_no IS '指定物料批次号';
COMMENT ON COLUMN public.t_les_receipting.demand_code IS '需求单号';
COMMENT ON COLUMN public.t_les_receipting.demand_no IS '需求单行号';
COMMENT ON COLUMN public.t_les_receipting.demand_quantity IS '需求数量';
COMMENT ON COLUMN public.t_les_receipting.demand_time IS '需求时间';
COMMENT ON COLUMN public.t_les_receipting.demand_factory IS '需求工厂代码';
COMMENT ON COLUMN public.t_les_receipting.demand_warehouse IS '需求仓库代码';
COMMENT ON COLUMN public.t_les_receipting.demand_zone IS '需求区域代码';
COMMENT ON COLUMN public.t_les_receipting.demand_station IS '需求工位代码';
COMMENT ON COLUMN public.t_les_receipting.demand_bin IS '需求储位代码';
COMMENT ON COLUMN public.t_les_receipting.demand_sap IS '需求SAP库位代码';
COMMENT ON COLUMN public.t_les_receipting.demand_rcs_station IS '需求AGV站点';
COMMENT ON COLUMN public.t_les_receipting.supply_factory IS '供应工厂代码';
COMMENT ON COLUMN public.t_les_receipting.supply_warehouse IS '供应仓库代码';
COMMENT ON COLUMN public.t_les_receipting.supply_zone IS '供应区域代码';
COMMENT ON COLUMN public.t_les_receipting.supply_area IS '供应区号代码';
COMMENT ON COLUMN public.t_les_receipting.supply_bin IS '供应储位代码';
COMMENT ON COLUMN public.t_les_receipting.supply_sap IS '供应SAP库位代码';
COMMENT ON COLUMN public.t_les_receipting.picking_code IS '拣配单号';
COMMENT ON COLUMN public.t_les_receipting.picking_line_no IS '拣配单行号';
COMMENT ON COLUMN public.t_les_receipting.transport_code IS '配送单号';
COMMENT ON COLUMN public.t_les_receipting.transport_line_code IS '配送单行号';
COMMENT ON COLUMN public.t_les_receipting.box_inv IS '箱INV信息';
COMMENT ON COLUMN public.t_les_receipting.box_code IS '箱条码信息';
COMMENT ON COLUMN public.t_les_receipting.box_batch_no IS '箱批次信息';
COMMENT ON COLUMN public.t_les_receipting.container_code IS '容器编码';
COMMENT ON COLUMN public.t_les_receipting.packing_serial_no IS '组箱流水号';
COMMENT ON COLUMN public.t_les_receipting.factory_code IS '工厂编码';
COMMENT ON COLUMN public.t_les_receipting.add_user_name IS '创建人';
COMMENT ON COLUMN public.t_les_receipting.add_user_code IS '创建人工号';
COMMENT ON COLUMN public.t_les_receipting.add_time IS '创建时间';
COMMENT ON COLUMN public.t_les_receipting.edit_time IS '更新时间';
COMMENT ON COLUMN public.t_les_receipting.edit_user_name IS '更新人';
COMMENT ON COLUMN public.t_les_receipting.edit_user_code IS '更新人工号';
COMMENT ON COLUMN public.t_les_receipting.data_status IS '数据状态：0-正常 1-删除';
COMMENT ON COLUMN public.t_les_receipting.receipting_type IS '签收类型：AUTO-自动 MANUAL-手动';
