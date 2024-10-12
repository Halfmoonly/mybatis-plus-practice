package org.lyflexi.optimisticlockplugin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: lyflexi
 * @project: mybatis-plus-practice
 * @Date: 2024/10/12 10:10
 */
@Mapper
@Repository
public interface PostgreSqlPartitionMapper {
    /**
     * 创建当前和下一个的分区表，若已存在则无操作
     * @param tableName 主表名称
     * @param periodUnit 分区时间单位，支持day、month、year3个类型
     * @param period 分区时间跨度，仅支持正数
     */
    @Select("call proc_create_partition(#{tableName}, #{periodUnit}, #{period})")
    void createCurrentAndNextPeriodPartition(@Param("tableName") String tableName,
                                             @Param("periodUnit") String periodUnit, @Param("period") int period);
}
