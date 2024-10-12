package org.lyflexi.optimisticlockplugin.controller;


import org.lyflexi.optimisticlockplugin.entity.form.ReceiptingForm;
import org.lyflexi.optimisticlockplugin.entity.po.base2.LesReceiptingPo;
import org.lyflexi.optimisticlockplugin.service.IReceiptingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ly
 * @Date: 2024/6/18 21:56
 */
@RestController
@RequestMapping("/receipting")
public class ReceiptingController {
    @Autowired
    private IReceiptingService iReceiptingService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Boolean addUser(@RequestBody ReceiptingForm param) {
        LesReceiptingPo po = new LesReceiptingPo();
        BeanUtils.copyProperties(param, po);
        return iReceiptingService.save(po);
    }


}
