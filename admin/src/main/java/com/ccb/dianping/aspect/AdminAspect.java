package com.ccb.dianping.aspect;

import com.ccb.dianping.common.BizException;
import com.ccb.dianping.common.CommonError;
import com.ccb.dianping.common.EnumCommonError;
import com.ccb.dianping.common.annotation.AdminPermission;
import com.ccb.dianping.controller.admin.AdminController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Aspect
@Configuration
public class AdminAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Around("execution(* com.ccb.dianping.controller.admin.*.*(..)) " +
            "&& (@annotation(org.springframework.web.bind.annotation.RequestMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.GetMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.PostMapping)))")
    public Object adminControllerBeforeValidation(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        AdminPermission adminPermission = method.getAnnotation(AdminPermission.class);
        if (adminPermission == null) {
            //公共方法
            return joinPoint.proceed();
        }
        //判断当前管理员是否登录
        String email = (String) request.getSession().getAttribute(AdminController.CURRENT_ADMIN_SESSION);
        if (email == null) {
            if (adminPermission.produceType().equals("text/html")) {
                response.sendRedirect("/admin/admin/loginPage"); //重定向
                return null;
                //return new ModelAndView("/admin/admin/login"); //转发
            } else {
                throw new BizException("需要管理员登陆才可访问此页面");
            }

        } else {
            return joinPoint.proceed();
        }
    }
}
