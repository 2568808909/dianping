package com.ccb.dianping.common.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageInfo {

    private Integer currentPage;

    private Integer pageSize;

    private Long totalCount;

    private Boolean isLastPage;

}
