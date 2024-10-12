package org.lyflexi.optimisticlockplugin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.lyflexi.optimisticlockplugin.entity.param.UserParam;
import org.lyflexi.optimisticlockplugin.entity.po.base.UserPo;


/**
 * @Author: ly
 * @Date: 2024/6/18 21:55
 */
public interface IUserService extends IService<UserPo> {
    IPage<UserPo> pageSearch(IPage<UserPo> page, UserParam param);

    Boolean delete(Long id);
}
