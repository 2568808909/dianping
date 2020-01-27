package com.ccb.dianping.service;

import com.ccb.dianping.common.bean.PageInfo;
import com.ccb.dianping.common.bean.PageResult;
import com.ccb.dianping.model.bean.Seller;
import com.ccb.dianping.model.vo.user.SellerPageReq;

import java.util.List;

public interface SellerService {

    PageResult querySellerPage(SellerPageReq sellerPageReq);

    Long sellerCount();

    Seller changeStatus(Integer id, int i);

    Seller create(Seller seller);

    Seller get(Integer id);
}
