package com.ccb.dianping.service;

import com.ccb.dianping.model.bean.User;

import java.security.NoSuchAlgorithmException;

public interface UserService {

    User getUser(Long id);

    void register(User user) throws NoSuchAlgorithmException;

    User login(String telephone, String password) throws NoSuchAlgorithmException;
}
