package com.ccb.dianping.model.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRegisterReq {

    private String telephone;

    private String nickName;

    private String password;

    private Integer gender;
}
