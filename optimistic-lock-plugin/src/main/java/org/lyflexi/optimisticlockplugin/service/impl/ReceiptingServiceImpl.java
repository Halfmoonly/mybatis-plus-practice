package org.lyflexi.optimisticlockplugin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lyflexi.optimisticlockplugin.dao.ReceiptingMapper;
import org.lyflexi.optimisticlockplugin.entity.po.base2.LesReceiptingPo;
import org.lyflexi.optimisticlockplugin.service.IReceiptingService;
import org.springframework.stereotype.Service;

/**
 * @Author: ly
 * @Date: 2024/6/18 21:55
 */
@Service
public class ReceiptingServiceImpl extends ServiceImpl<ReceiptingMapper, LesReceiptingPo> implements IReceiptingService {

}
