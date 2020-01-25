package com.ccb.dianping.service;

import com.ccb.dianping.model.bean.User;

public interface UserService {

    User getUser(Long id);

    User register(User user);

    User login(String telephone, String password);
}
