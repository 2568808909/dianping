package com.ccb.dianping.service;

import com.ccb.dianping.common.bean.PageResult;
import com.ccb.dianping.model.bean.Category;
import com.ccb.dianping.model.vo.admin.CategoryCreateReq;
import com.ccb.dianping.model.vo.admin.PageReq;

public interface CategoryService {

    Category create(CategoryCreateReq categoryCreateReq) throws IllegalAccessException, NoSuchFieldException, InstantiationException;

    Long categoryCount();

    PageResult categoryPage(PageReq pageReq);
}
