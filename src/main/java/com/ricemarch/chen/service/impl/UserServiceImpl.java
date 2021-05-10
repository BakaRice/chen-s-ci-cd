package com.ricemarch.chen.service.impl;

import com.ricemarch.chen.entity.User;
import com.ricemarch.chen.mapper.UserMapper;
import com.ricemarch.chen.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ricemarch
 * @since 2021-05-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
