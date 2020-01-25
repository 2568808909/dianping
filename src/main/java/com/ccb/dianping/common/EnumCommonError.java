package com.ccb.dianping.common;

import lombok.Data;

public enum EnumCommonError {

    PARAM_NOT_MATCH(10001, "参数不正确"),
    PATH_NOT_FOUND(10002, "找不到路径");

    private int code;

    private String msg;

    EnumCommonError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
