package com.ccb.dianping.model.vo.admin;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@ToString
public class ShopCreateReq {

    @NotBlank(message = "name不能为空")
    private String name;

    @NotNull(message = "remarkScore不能为空")
    private BigDecimal remarkScore;

    @NotNull(message = "pricePerMan不能为空")
    private Integer pricePerMan;

    @NotNull(message = "latitude不能为空")
    private BigDecimal latitude;

    @NotNull(message = "longitude不能为空")
    private BigDecimal longitude;

    @NotNull(message = "categoryId不能为空")
    private Integer categoryId;

    private String tags;

    @NotNull(message = "startTime不能为空")
    private String startTime;

    @NotNull(message = "endTime不能为空")
    private String endTime;

    @NotNull(message = "address不能为空")
    private String address;

    @NotNull(message = "sellerId不能为空")
    private Integer sellerId;

    @NotNull(message = "iconUrl不能为空")
    private String iconUrl;
}
