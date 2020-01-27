package com.ccb.dianping.service.impl;

import com.ccb.dianping.common.BizException;
import com.ccb.dianping.common.bean.PageInfo;
import com.ccb.dianping.common.bean.PageResult;
import com.ccb.dianping.dal.SellerMapper;
import com.ccb.dianping.model.bean.Seller;
import com.ccb.dianping.model.vo.admin.SellerPageReq;
import com.ccb.dianping.service.SellerService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@EnableCaching
public class SellerServiceImpl implements SellerService {

    private final SellerMapper sellerMapper;

    public SellerServiceImpl(SellerMapper sellerMapper) {
        this.sellerMapper = sellerMapper;
    }

    @Override
    public PageResult querySellerPage(SellerPageReq sellerPageReq) {
        PageInfo pageInfo = new PageInfo();
        Long totalCount = sellerCount();
        Integer page = sellerPageReq.getPage();
        Integer size = sellerPageReq.getSize();
        Integer pageStart = (page - 1) * size;
        pageInfo.setCurrentPage(page);
        pageInfo.setPageSize(size);
        pageInfo.setTotalCount(totalCount);
        long i = pageStart + size;
        pageInfo.setIsLastPage(i >= totalCount);
        List<Seller> sellers = sellerMapper.selectPage(pageStart, size);
        return PageResult.success(sellers, pageInfo);
    }

    @Override
    @Cacheable(cacheNames = "seller_count", unless = "#result==0")
    public Long sellerCount() {
        return sellerMapper.sellerCount();
    }

    @Override
    public Seller changeStatus(Integer id, int i) {
        Seller seller = new Seller();
        seller.setId(id);
        seller.setDisabledFlag(i);
        int result = sellerMapper.updateByPrimaryKeySelective(seller);
        if (result == 0) {
            throw new BizException("商家信息不存在或已删除");
        }
        return sellerMapper.selectByPrimaryKey(id);
    }

    public Seller get(Integer id){
        return sellerMapper.selectByPrimaryKey(id);
    }

    @Override
    @CacheEvict(cacheNames = "seller_count")
    @Transactional
    public Seller create(Seller seller) {
        Date now = new Date();
        seller.setCreatedTime(now);
        seller.setUpdatedTime(now);
        seller.setRemarkScore(new BigDecimal(0));
        seller.setDisabledFlag(0);
        sellerMapper.insert(seller);
        return seller;
    }
}
