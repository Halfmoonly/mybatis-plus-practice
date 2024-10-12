package org.lyflexi.autopartitionprocedure.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: lyflexi
 * @project: mybatis-plus-practice
 * @Date: 2024/10/12 10:08
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PartitionConfigBo {
//    @ApiModelProperty(value = "开启分区的主表名称")
    private String tableName;
//    @ApiModelProperty(value = "时间单位，支持year年、month月、day日）")
    private String periodUnit;
//    @ApiModelProperty(value = "分区周期")
    private Integer period;
}


