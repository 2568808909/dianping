package com.ccb.dianping.service.impl;

import com.ccb.dianping.common.bean.PageInfo;
import com.ccb.dianping.common.bean.PageResult;
import com.ccb.dianping.common.util.ReflectUtils;
import com.ccb.dianping.dal.ShopMapper;
import com.ccb.dianping.model.bean.Shop;
import com.ccb.dianping.model.vo.admin.PageReq;
import com.ccb.dianping.model.vo.admin.ShopCreateReq;
import com.ccb.dianping.service.ShopService;
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
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    @Cacheable(cacheNames = "shop_count")
    public Long shopCount() {
        return shopMapper.shopCount();
    }

    @Override
    public PageResult shopPage(PageReq pageReq) {
        PageInfo pageInfo = new PageInfo();
        Long totalCount = shopCount();
        Integer page = pageReq.getPage();
        Integer size = pageReq.getSize();
        Integer pageStart = (page - 1) * size;
        pageInfo.setCurrentPage(page);
        pageInfo.setPageSize(size);
        pageInfo.setTotalCount(totalCount);
        long i = pageStart + size;
        pageInfo.setIsLastPage(i >= totalCount);
        List<Shop> list = shopMapper.selectPage(pageStart, size);
        return PageResult.success(list, pageInfo);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "shop_count")
    public Shop create(ShopCreateReq shopCreateReq) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        Shop result = ReflectUtils.convertTo(shopCreateReq, Shop.class);
        Date now = new Date();
        result.setCreatedTime(now);
        result.setUpdatedTime(now);
        shopMapper.insert(result);
        return result;
    }
}
