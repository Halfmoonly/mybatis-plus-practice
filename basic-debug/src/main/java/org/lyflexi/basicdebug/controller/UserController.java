package org.lyflexi.basicdebug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.lyflexi.basicdebug.entity.form.UserForm;
import org.lyflexi.basicdebug.entity.param.UserParam;
import org.lyflexi.basicdebug.entity.po.base.UserPo;
import org.lyflexi.basicdebug.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ly
 * @Date: 2024/6/18 21:56
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(path = "/get/{userId}", method = RequestMethod.GET)
    public UserPo getUser(@PathVariable Long userId) {
        return userService.getById(userId);
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public Boolean updateUser(@RequestBody UserForm param) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(param, userPo);
        return userService.updateById(userPo);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Boolean addUser(@RequestBody UserForm param) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(param, userPo);
        return userService.save(userPo);
    }

    @RequestMapping(path = "/page", method = RequestMethod.POST)
    public IPage<UserPo> page(@RequestBody UserParam param) {
        return userService.pageSearch(param.getPage(), param);
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @RequestMapping(path = "/optimistic/{id}", method = RequestMethod.GET)
    public Boolean optimistic(@PathVariable Long id)
    {
        UserPo user = userService.getById(id);
        int version = user.getVersion();
        user.setPassword("new password");
        user.setVersion(version);
        boolean b = userService.updateById(user);
        System.out.println("成功与否： "+b);

        user = userService.getById(id);
        version = user.getVersion();
        user.setPassword("new password");
        user.setVersion(version);
        b = userService.updateById(user);
        System.out.println("成功与否： "+b);

        return true;
    }

}
