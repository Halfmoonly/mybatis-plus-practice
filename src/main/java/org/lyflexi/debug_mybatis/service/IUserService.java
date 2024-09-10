package org.lyflexi.debug_mybatis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.lyflexi.debug_mybatis.entity.po.UserPo;
import org.lyflexi.debug_mybatis.entity.param.UserParam;

/**
 * @Author: ly
 * @Date: 2024/6/18 21:55
 */
public interface IUserService extends IService<UserPo> {
    IPage<UserPo> pageSearch(IPage<UserPo> page, UserParam param);

    Boolean delete(Long id);
}
