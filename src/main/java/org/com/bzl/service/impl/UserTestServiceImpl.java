package org.com.bzl.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import org.com.bzl.mapper.UserTestMapper;
import org.com.bzl.entity.User;
import org.com.bzl.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 * <pre>
 *     用户业务逻辑实现类
 * </pre>
 *
 */
@Service
public class UserTestServiceImpl implements UserService {

    @Autowired(required = false)
    private UserTestMapper userMapper;

    @Override
    public void saveByUser(User user) {
        if (user != null && user.getUserId() != null) {
            userMapper.updateById(user);
        } else {
            userMapper.insert(user);
        }
    }

    @Override
    public User findByUserName(String userName) {
        User param = new User();
        param.setUserName(userName);
        return userMapper.selectOne(param);
    }

    @Override
    public User findByUserId(Long userId) {
        return userMapper.selectById(userId);
    }


    @Override
    public void removeUser(Long userId) {
        userMapper.deleteById(userId);
    }

    @Override
    public Page<User> findAll(Page<User> page) {
        return page.setRecords(userMapper.findAll(page));
    }

}
