package com.ccb.dianping.controller.admin;

import com.ccb.dianping.common.BizException;
import com.ccb.dianping.common.annotation.AdminPermission;
import com.ccb.dianping.common.util.CommonUtils;
import com.ccb.dianping.model.vo.admin.AdminLoginReq;
import com.ccb.dianping.service.CategoryService;
import com.ccb.dianping.service.SellerService;
import com.ccb.dianping.service.ShopService;
import com.ccb.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/admin/admin")
public class AdminController {

    public static final String CURRENT_ADMIN_SESSION = "currentAdminSession";

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private SellerService sellerService;

    @Value("${admin.email}")
    private String email;

    @Value("${admin.encryptPassword}")
    private String password;

    /**
     * 访问运营后台首页
     *
     * @return
     */
    @RequestMapping("/index")
    @ResponseBody
    @AdminPermission
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/admin/admin/index");
        modelAndView.addObject("userCount",userService.userCount());
        modelAndView.addObject("shopCount",shopService.shopCount());
        modelAndView.addObject("categoryCount",categoryService.categoryCount());
        modelAndView.addObject("sellerCount",sellerService.sellerCount());
        modelAndView.addObject("CONTROLLER_NAME", "admin");
        modelAndView.addObject("ACTION_NAME", "index");
        return modelAndView;
    }

    /**
     * 访问登录页
     *
     * @return
     */
    @GetMapping("/loginPage")
    @ResponseBody
    public ModelAndView loginPage() {
        return new ModelAndView("/admin/admin/login");
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request,
                        @Valid AdminLoginReq adminLoginReq,
                        BindingResult bindingResult) throws NoSuchAlgorithmException {
        if (bindingResult.hasErrors()) {
            throw new BizException(CommonUtils.mergeErrorString(bindingResult));
        }
        HttpSession session = request.getSession();
        if (this.email.equals(adminLoginReq.getEmail()) && this.password.equals(CommonUtils.MD5(adminLoginReq.getPassword()))) {
            session.setAttribute(CURRENT_ADMIN_SESSION, email + "&" + password);
            return "redirect:/admin/admin/index";
        } else {
            throw new BizException("邮箱或密码不正确");
        }
    }
}
