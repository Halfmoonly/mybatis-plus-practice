package org.lyflexi.autopartitionprocedure.entity.po.base2;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: lyflexi
 * @project: mybatis-plus-practice
 * @Date: 2024/10/12 9:58
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("public.t_les_receipting")
@NoArgsConstructor
@AllArgsConstructor
public class LesReceiptingPo extends BasePo2 implements Serializable {
    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = "签收单号")
    private String receiptingCode;

//    @ApiModelProperty(value = "签收时间")
    private LocalDateTime receiptingTime;

//    @ApiModelProperty(value = "签收人工号")
    private String receiptingUserCode;

//    @ApiModelProperty(value = "签收人名称")
    private String receiptingUserName;

//    @ApiModelProperty(value = "签收数量")
    private BigDecimal receiptingQuantity;

//    @ApiModelProperty(value = "签收件数")
    private BigDecimal receiptingPiece;

//    @ApiModelProperty(value = "签收状态：UNRECEIPT-未签收 RECEIPTED-已签收 WAREHOUSED-已入库")
    private String receiptingStatus;

//    @ApiModelProperty(value = "签收仓库代码")
    private String receiptingWarehouse;

//    @ApiModelProperty(value = "签收区域代码")
    private String receiptingZone;

//    @ApiModelProperty(value = "签收储位")
    private String receiptingBin;

//    @ApiModelProperty(value = "签收来源：LES WMS")
    private String receiptingSource;

//    @ApiModelProperty(value = "签收类型：AUTO-自动 MANUAL-手动")
    private String receiptingType;

//    @ApiModelProperty(value = "物料编码")
    private String materialCode;

//    @ApiModelProperty(value = "物料名称")
    private String materialName;

//    @ApiModelProperty(value = "物料版本")
    private String materialVersion;

//    @ApiModelProperty(value = "物料单位")
    private String materialUnit;

//    @ApiModelProperty(value = "物料件数")
    private BigDecimal materialPiece;

//    @ApiModelProperty(value = "物料数量（配送数量/捡配数量")
    private BigDecimal materialQuantity;

//    @ApiModelProperty(value = "指定物料批供应商")
    private String materialSupplier;

//    @ApiModelProperty(value = "指定物料批次号")
    private String materialBatchNo;

//    @ApiModelProperty(value = "需求单号")
    private String demandCode;

//    @ApiModelProperty(value = "需求单行号")
    private Integer demandNo;

//    @ApiModelProperty(value = "需求数量")
    private BigDecimal demandQuantity;

//    @ApiModelProperty(value = "需求时间")
    private LocalDateTime demandTime;

//    @ApiModelProperty(value = "需求工厂代码")
    private String demandFactory;

//    @ApiModelProperty(value = "需求仓库代码")
    private String demandWarehouse;

//    @ApiModelProperty(value = "需求区域代码")
    private String demandZone;

//    @ApiModelProperty(value = "需求工位代码")
    private String demandStation;

//    @ApiModelProperty(value = "需求储位代码")
    private String demandBin;

//    @ApiModelProperty(value = "需求SAP库位代码")
    private String demandSap;

//    @ApiModelProperty(value = "需求AGV站点")
    private String demandRcsStation;

//    @ApiModelProperty(value = "供应工厂代码")
    private String supplyFactory;

//    @ApiModelProperty(value = "供应仓库代码")
    private String supplyWarehouse;

//    @ApiModelProperty(value = "供应区域代码")
    private String supplyZone;

//    @ApiModelProperty(value = "供应区号代码")
    private String supplyArea;

//    @ApiModelProperty(value = "供应储位代码")
    private String supplyBin;

//    @ApiModelProperty(value = "供应SAP库位代码")
    private String supplySap;

//    @ApiModelProperty(value = "捡配单号")
    private String pickingCode;

//    @ApiModelProperty(value = "捡配单号行号")
    private Integer pickingLineNo;

//    @ApiModelProperty(value = "配送单号")
    private String transportCode;

//    @ApiModelProperty(value = "配送单行号")
    private Integer transportLineCode;

//    @ApiModelProperty(value = "箱INV信息")
    private String boxInv;

//    @ApiModelProperty(value = "箱条码信息")
    private String boxCode;

//    @ApiModelProperty(value = "箱批次信息")
    private String boxBatchNo;

//    @ApiModelProperty(value = "容器编码")
    private String containerCode;

//    @ApiModelProperty(value = "组箱流水号")
    private String packingSerialNo;
}



