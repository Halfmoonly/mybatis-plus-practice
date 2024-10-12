package org.lyflexi.autopartitionprocedure.entity.po.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @Author: ly
 * @Date: 2024/6/18 21:52
 */
@Data
//application.yml中的currentSchema=lyschema没有生效，原因未知
@TableName("public.user")
public class UserPo extends BasePo {
    Long id;
    String name;
    String code;
    Integer age;
    @TableLogic
    Integer dataStatus;

    @TableField(value = "password")
    private String password;
    @Version
    @TableField(value = "version")
    private Integer version;
}
