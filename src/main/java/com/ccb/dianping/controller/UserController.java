package com.ccb.dianping.controller;

import com.ccb.dianping.common.BizException;
import com.ccb.dianping.common.Result;
import com.ccb.dianping.common.aspect.CommonExceptionHandler;
import com.ccb.dianping.common.util.ReflectUtils;
import com.ccb.dianping.model.bean.User;
import com.ccb.dianping.model.vo.UserRegisterReq;
import com.ccb.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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

    @RequestMapping("/register")
    @ResponseBody
    public Result register(UserRegisterReq userRegisterReq) {
        try {
            User user = ReflectUtils.convertTo(userRegisterReq, User.class);
            Date now = new Date();
            user.setCreatedTime(now);
            user.setUpdatedTime(now);
            userService.register(user);
            return Result.success(null);
        } catch (DuplicateKeyException ex) {
            throw ex;
        } catch (Exception e) {
            throw new BizException(e.getMessage());
        }
    }

}
