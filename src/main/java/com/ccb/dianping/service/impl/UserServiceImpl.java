package com.ccb.dianping.service.impl;

import com.ccb.dianping.dal.UserMapper;
import com.ccb.dianping.model.bean.User;
import com.ccb.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User register(User user) {
        return null;
    }

    @Override
    public User login(String telephone, String password) {
        return null;
    }
}
