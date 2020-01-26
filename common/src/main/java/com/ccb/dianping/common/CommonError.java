package com.ccb.dianping.common;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CommonError {

    private int code;
    private String msg;

    public CommonError(EnumCommonError enumCommonError) {
        this(enumCommonError.getCode(), enumCommonError.getMsg());
    }

    public CommonError(EnumCommonError enumCommonError, String msg) {
        this(enumCommonError.getCode(), msg);
    }

    public CommonError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
