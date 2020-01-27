package com.ccb.dianping.controller.admin;

import com.ccb.dianping.common.BizException;
import com.ccb.dianping.common.annotation.AdminPermission;
import com.ccb.dianping.common.bean.Result;
import com.ccb.dianping.common.util.CommonUtils;
import com.ccb.dianping.model.vo.admin.PageReq;
import com.ccb.dianping.model.vo.admin.ShopCreateReq;
import com.ccb.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(PageReq pageReq) {
        ModelAndView modelAndView = new ModelAndView("/admin/shop/index");
        modelAndView.addObject("data", shopService.shopPage(pageReq));
        modelAndView.addObject("CONTROLLER_NAME","shop");
        modelAndView.addObject("ACTION_NAME","index");
        return modelAndView;
    }

    @RequestMapping("/create")
    @AdminPermission
    @ResponseBody
    public Result create(@Valid @RequestBody ShopCreateReq shopCreateReq,
                         BindingResult bindingResult) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        if (bindingResult.hasErrors()) {
            throw new BizException(CommonUtils.mergeErrorString(bindingResult));
        }
        return Result.success(shopService.create(shopCreateReq));
    }

    @RequestMapping("/createPage")
    @AdminPermission
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView("/admin/shop/create");
        modelAndView.addObject("CONTROLLER_NAME", "shop");
        modelAndView.addObject("ACTION_NAME", "create");
        return modelAndView;
    }
}
