package com.ccb.dianping.model.vo.admin;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class PageReq {

    @NotNull(message = "page不能为空")
    @Min(message = "页码最小为1", value = 1)
    private Integer page;

    @NotNull(message = "size不能为空")
    @Min(message = "一页至少显示5条记录", value = 5)
    @Max(message = "一页最多显示100条记录", value = 100)
    private Integer size;
}
