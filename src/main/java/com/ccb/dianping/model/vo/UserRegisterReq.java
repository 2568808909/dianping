package com.ccb.dianping.model.vo;

import com.ccb.dianping.common.annotation.FieldMapping;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UserRegisterReq {

    private String telephone;

    private String nickName;

    private String password;

    private Integer gender;
}
