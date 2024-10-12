package org.lyflexi.autopartitionprocedure.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lyflexi.autopartitionprocedure.dao.UserMapper;
import org.lyflexi.autopartitionprocedure.entity.param.UserParam;
import org.lyflexi.autopartitionprocedure.entity.po.base.UserPo;
import org.lyflexi.autopartitionprocedure.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author: ly
 * @Date: 2024/6/18 21:55
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements IUserService {

    @Override
    public IPage<UserPo> pageSearch(IPage<UserPo> page, UserParam param) {
        return this.page(page,Wrappers.<UserPo>lambdaQuery().orderByDesc(UserPo::getId));
    }

    @Override
    public Boolean delete(Long id) {
        return this.removeById(id);
    }
}
