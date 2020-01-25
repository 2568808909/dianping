package com.ccb.dianping.controller;

import com.ccb.dianping.common.BizException;
import com.ccb.dianping.common.Result;
import com.ccb.dianping.common.aspect.CommonExceptionHandler;
import com.ccb.dianping.model.bean.User;
import com.ccb.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommonExceptionHandler handler;

    @RequestMapping("/get/{id}")
    @ResponseBody
    public Result getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new BizException("用户不存在");
        }
        return Result.success(user);
    }

}
