package com.ccb.dianping.service.impl;

import com.ccb.dianping.common.bean.PageInfo;
import com.ccb.dianping.common.bean.PageResult;
import com.ccb.dianping.common.util.ReflectUtils;
import com.ccb.dianping.dal.CategoryMapper;
import com.ccb.dianping.model.bean.Category;
import com.ccb.dianping.model.vo.admin.CategoryCreateReq;
import com.ccb.dianping.model.vo.admin.PageReq;
import com.ccb.dianping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@EnableCaching
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @CacheEvict(cacheNames = "category_count")
    @Transactional
    public Category create(CategoryCreateReq categoryCreateReq) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        Category category = ReflectUtils.convertTo(categoryCreateReq, Category.class);
        Date now = new Date();
        category.setCreatedTime(now);
        category.setUpdatedTime(now);
        categoryMapper.insert(category);
        return category;
    }

    @Override
    @Cacheable(cacheNames = "category_count")
    public Long categoryCount() {
        return categoryMapper.categoryCount();
    }

    @Override
    public PageResult categoryPage(PageReq pageReq) {
        PageInfo pageInfo = new PageInfo();
        Long totalCount = categoryCount();
        Integer page = pageReq.getPage();
        Integer size = pageReq.getSize();
        Integer pageStart = (page - 1) * size;
        pageInfo.setCurrentPage(page);
        pageInfo.setPageSize(size);
        pageInfo.setTotalCount(totalCount);
        long i = pageStart + size;
        pageInfo.setIsLastPage(i >= totalCount);
        List<Category> list = categoryMapper.selectPage(pageStart, size);
        return PageResult.success(list, pageInfo);
    }
}
