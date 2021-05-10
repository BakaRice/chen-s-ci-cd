package com.ricemarch.chen.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ricemarch.chen.entity.User;
import com.ricemarch.chen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ricemarch
 * @since 2021-05-10
 */
@RestController
@RequestMapping("/chen/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", user.getId());
        queryWrapper.eq("password", user.getPassword());
        User one = userService.getOne(queryWrapper);
        if (null == one) {
            return false;
        } else {
            return true;
        }
    }

    @PostMapping("/register")
    public boolean register(@RequestBody User user) {
        return userService.save(user);
    }
}

