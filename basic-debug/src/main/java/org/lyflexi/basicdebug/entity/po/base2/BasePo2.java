package org.lyflexi.basicdebug.entity.po.base2;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: lyflexi
 * @project: mybatis-plus-practice
 * @Date: 2024/9/10 21:34
 */
@Data
@Accessors(chain = true)
public class BasePo2 {
    public final static String DEFAULT_USERNAME = "system";

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime addTime;

    @TableField(fill = FieldFill.INSERT)
    private String addUserName;

    @TableField(fill = FieldFill.INSERT)
    private String addUserCode;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUserName;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUserCode;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime editTime;

    @TableField(fill = FieldFill.INSERT)
    private Integer dataStatus;

    @TableField(fill = FieldFill.INSERT)
    private String factoryCode;
}
