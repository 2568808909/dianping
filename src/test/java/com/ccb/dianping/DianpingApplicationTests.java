package com.ccb.dianping;

import com.ccb.dianping.common.util.ReflectUtils;
import com.ccb.dianping.model.bean.User;
import com.ccb.dianping.model.vo.user.UserRegisterReq;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DianpingApplicationTests {

    @Test
    void contextLoads() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        UserRegisterReq req = new UserRegisterReq();
        req.setGender(1);
        req.setNickName("Tom");
        req.setPassword("123456");
        req.setTelephone("13172393671");
        System.out.println(ReflectUtils.convertTo(req, User.class));
    }

}
