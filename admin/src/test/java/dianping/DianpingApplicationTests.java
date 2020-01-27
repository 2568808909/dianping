package dianping;

import com.ccb.dianping.common.bean.PageResult;
import com.ccb.dianping.common.bean.Result;
import com.ccb.dianping.model.bean.Seller;
import com.ccb.dianping.model.vo.user.SellerPageReq;
import com.ccb.dianping.service.SellerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = com.ccb.dianping.DianpingApplication.class)
class DianpingApplicationTests {

    @Autowired
    private SellerService sellerService;

    @Test
    public void test(){
        SellerPageReq sellerPageReq = new SellerPageReq();
        sellerPageReq.setPage(3);
        sellerPageReq.setSize(10);
        PageResult pageResult = sellerService.querySellerPage(sellerPageReq);
        System.out.println(pageResult);
        System.out.println();
        System.out.println(sellerService.sellerCount());
        System.out.println(sellerService.sellerCount());
    }
}
