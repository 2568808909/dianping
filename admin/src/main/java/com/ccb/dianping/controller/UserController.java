package com.ccb.dianping.controller;

import com.ccb.dianping.common.BizException;
import com.ccb.dianping.common.bean.Result;
import com.ccb.dianping.common.util.CommonUtils;
import com.ccb.dianping.common.util.ReflectUtils;
import com.ccb.dianping.model.bean.User;
import com.ccb.dianping.model.vo.user.UserLoginReq;
import com.ccb.dianping.model.vo.user.UserRegisterReq;
import com.ccb.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    private final static String USER_ATTRIBUTE = "userInSession";

    @RequestMapping("/index")
    public ModelAndView index(){
        String userName = "imooc";
        ModelAndView modelAndView = new ModelAndView("/index.html");
        modelAndView.addObject("name",userName);
        return modelAndView;
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Result getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new BizException("用户不存在");
        }
        return Result.success(user);
    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(@Valid @RequestBody UserRegisterReq userRegisterReq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BizException(CommonUtils.mergeErrorString(bindingResult));
        }
        try {
            User user = ReflectUtils.convertTo(userRegisterReq, User.class);
            Date now = new Date();
            user.setCreatedTime(now);
            user.setUpdatedTime(now);
            userService.register(user);
            return Result.success(null);
        } catch (DuplicateKeyException ex) {
            throw new BizException("用户已存在");
        } catch (Exception e) {
            throw new BizException(e.getMessage());
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public Result login(HttpServletRequest request,
                        @Valid @RequestBody UserLoginReq userLoginReq,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BizException(CommonUtils.mergeErrorString(bindingResult));
        }
        HttpSession session = request.getSession();
        try {
            User login = userService.login(userLoginReq.getTelephone(), userLoginReq.getPassword());
            if (login == null) {
                throw new BizException("密码或手机号不正确");
            }
            session.setAttribute(USER_ATTRIBUTE, login);
            return Result.success(login);
        } catch (Exception e) {
            throw new BizException(e.getMessage());
        }
    }

    @GetMapping("/logout")
    @ResponseBody
    public Result logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return Result.success();
    }

    @GetMapping("/getCurrentUser")
    @ResponseBody
    public Result getCurrentUser(HttpServletRequest request) {
        return Result.success(request.getSession().getAttribute(USER_ATTRIBUTE));
    }

}
