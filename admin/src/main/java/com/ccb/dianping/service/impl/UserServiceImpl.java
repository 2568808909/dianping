package com.ccb.dianping.service.impl;

import com.ccb.dianping.common.util.CommonUtils;
import com.ccb.dianping.dal.UserMapper;
import com.ccb.dianping.model.bean.User;
import com.ccb.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void register(User user) throws NoSuchAlgorithmException {
        user.setPassword(CommonUtils.MD5(user.getPassword()));
        userMapper.insert(user);
    }

    @Override
    public User login(String telephone, String password) throws NoSuchAlgorithmException {
        password = CommonUtils.MD5(password);
        return userMapper.selectUserByPhoneAndPsw(telephone,password);
    }
}
