package com.ccb.dianping.common.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class PageResult extends Result {

    private PageInfo pageInfo;

    public PageResult(Object data, PageInfo pageInfo) {
        super(SUCCESS_CODE, data, SUCCESS_MSG);
        this.pageInfo = pageInfo;
    }

    public static PageResult success(Object data, PageInfo pageInfo) {
        return new PageResult(data, pageInfo);
    }
}
