package com.ccb.dianping.common;

import lombok.Data;

@Data
public class Result {

    private static int SUCCESS_CODE = 0;
    private static String SUCCESS_MSG = "success";
    private static int BIZ_FAIL_CODE = 1;

    private int code;

    private Object data;

    private String msg;

    public Result(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static Result success(Object data) {
        return new Result(SUCCESS_CODE, data, SUCCESS_MSG);
    }

    public static Result success() {
        return new Result(SUCCESS_CODE, null, SUCCESS_MSG);
    }

    public static Result success(Object data, String msg) {
        return new Result(SUCCESS_CODE, data, msg);
    }

    public static Result fail(CommonError error) {
        return new Result(error.getCode(), null, error.getMsg());
    }

    public static Result fail(Exception ex) {
        return new Result(BIZ_FAIL_CODE, null, ex.getMessage());
    }

}
