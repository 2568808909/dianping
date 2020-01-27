package com.ccb.dianping.model.vo.admin;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class CategoryCreateReq {

    @NotBlank(message = "name不能为空")
    private String name;

    @NotBlank(message = "iconUrl不能为空")
    private String iconUrl;

    @NotNull(message = "sort不能为空")
    private Integer sort;
}
