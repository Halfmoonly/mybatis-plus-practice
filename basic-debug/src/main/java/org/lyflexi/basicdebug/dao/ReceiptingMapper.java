package org.lyflexi.basicdebug.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.lyflexi.basicdebug.entity.po.base2.LesReceiptingPo;

/**
 * @Author: ly
 * @Date: 2024/6/18 21:52
 */
@Mapper
public interface ReceiptingMapper extends BaseMapper<LesReceiptingPo> {
}
