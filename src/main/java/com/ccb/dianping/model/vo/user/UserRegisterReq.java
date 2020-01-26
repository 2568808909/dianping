package com.ccb.dianping.model.vo.user;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class UserRegisterReq {

    @NotBlank(message = "手机号不能为空")
    private String telephone;

    @NotBlank(message = "昵称不能为空")
    private String nickName;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotNull(message = "请选择性别")
    @Max(value = 1,message = "性别参数最大为1")
    @Min(value = 0,message = "性别参数最小为0")
    private Integer gender;
}
