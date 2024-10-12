package org.lyflexi.basicdebug.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.lyflexi.basicdebug.entity.po.base.UserPo;

/**
 * @Author: ly
 * @Date: 2024/6/18 21:52
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPo> {
}
