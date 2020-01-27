package com.ccb.dianping.model.vo.admin;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SellerCreateReq {
    @NotBlank(message = "商户名不能为空")
    private String name;
}

