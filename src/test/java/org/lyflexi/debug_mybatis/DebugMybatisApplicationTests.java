package org.lyflexi.debug_mybatis;

import org.junit.jupiter.api.Test;
import org.lyflexi.debug_mybatis.entity.po.UserPo;
import org.lyflexi.debug_mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DebugMybatisApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private IUserService iUserService;

    @Test
    public void updateById(){
        UserPo user = iUserService.getById(1L);
        int version = user.getVersion();
        user.setPassword("new password");
        user.setVersion(version);
        boolean b = iUserService.updateById(user);
        System.out.println("成功与否： "+b);

        user = iUserService.getById(1L);
        version = user.getVersion();
        user.setPassword("new password");
        user.setVersion(version);
        b = iUserService.updateById(user);
        System.out.println("成功与否： "+b);
    }
}
