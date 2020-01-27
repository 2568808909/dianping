package com.ccb.dianping.model.vo.admin;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class AdminLoginReq {

    @NotBlank(message = "邮箱号不能为空")
    private String email;

    @NotBlank(message = "密码不能为空")
    private String password;
}
