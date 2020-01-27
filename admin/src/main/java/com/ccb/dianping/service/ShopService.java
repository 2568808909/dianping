package com.ccb.dianping.service;

import com.ccb.dianping.common.bean.PageResult;
import com.ccb.dianping.model.bean.Shop;
import com.ccb.dianping.model.vo.admin.PageReq;
import com.ccb.dianping.model.vo.admin.ShopCreateReq;

public interface ShopService {
    Long shopCount();

    PageResult shopPage(PageReq pageReq);

    Shop create(ShopCreateReq shopCreateReq) throws IllegalAccessException, NoSuchFieldException, InstantiationException;
}
