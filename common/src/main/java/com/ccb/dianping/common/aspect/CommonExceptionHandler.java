package com.ccb.dianping.common.aspect;

import com.ccb.dianping.common.CommonError;
import com.ccb.dianping.common.Result;
import com.ccb.dianping.common.EnumCommonError;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class CommonExceptionHandler {
    //在启动类要加上@EnableAspectJAutoProxy(proxyTargetClass = true)才能生效
    //使用前要整合aop的包

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        if (ex instanceof MethodArgumentTypeMismatchException) {
            return Result.fail(new CommonError(EnumCommonError.PARAM_NOT_MATCH));
        } else if (ex instanceof NoHandlerFoundException) {
            return Result.fail(new CommonError(EnumCommonError.PATH_NOT_FOUND));
        }else if(ex instanceof DuplicateKeyException){
            return Result.fail(new CommonError(EnumCommonError.USER_ALREAD_EXIST));
        } else {
            return Result.fail(ex);
        }
    }
}

