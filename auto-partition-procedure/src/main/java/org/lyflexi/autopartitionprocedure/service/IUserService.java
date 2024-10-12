package org.lyflexi.autopartitionprocedure.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.lyflexi.autopartitionprocedure.entity.param.UserParam;
import org.lyflexi.autopartitionprocedure.entity.po.base.UserPo;


/**
 * @Author: ly
 * @Date: 2024/6/18 21:55
 */
public interface IUserService extends IService<UserPo> {
    IPage<UserPo> pageSearch(IPage<UserPo> page, UserParam param);

    Boolean delete(Long id);
}
