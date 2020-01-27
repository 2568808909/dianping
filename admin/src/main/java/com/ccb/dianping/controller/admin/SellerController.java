package com.ccb.dianping.controller.admin;

import com.ccb.dianping.common.BizException;
import com.ccb.dianping.common.annotation.AdminPermission;
import com.ccb.dianping.common.bean.PageResult;
import com.ccb.dianping.common.bean.Result;
import com.ccb.dianping.common.util.CommonUtils;
import com.ccb.dianping.model.bean.Seller;
import com.ccb.dianping.model.vo.admin.SellerCreateReq;
import com.ccb.dianping.model.vo.admin.SellerPageReq;
import com.ccb.dianping.service.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/seller")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(@Valid SellerPageReq sellerPageReq, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BizException(CommonUtils.mergeErrorString(bindingResult));
        }
        PageResult sellerPage = sellerService.querySellerPage(sellerPageReq);
        ModelAndView modelAndView = new ModelAndView("/admin/seller/index");
        modelAndView.addObject("data", sellerPage);
        modelAndView.addObject("CONTROLLER_NAME","seller");
        modelAndView.addObject("ACTION_NAME","index");
        return modelAndView;
    }

    @RequestMapping("/createPage")
    @AdminPermission
    public ModelAndView createPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/seller/create");
        modelAndView.addObject("CONTROLLER_NAME","seller");
        modelAndView.addObject("ACTION_NAME","create");
        return modelAndView;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @AdminPermission
    public String create(@Valid SellerCreateReq sellerCreateReq,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BizException(CommonUtils.mergeErrorString(bindingResult));
        }
        Seller seller = new Seller();
        seller.setName(sellerCreateReq.getName());
        sellerService.create(seller);

        return "redirect:/admin/seller/index";
    }

    @PostMapping("/down")
    @AdminPermission
    @ResponseBody
    public Result down(@RequestParam(value="id")Integer id) {
        Seller seller = sellerService.changeStatus(id,1);
        return Result.success(seller);
    }

    @RequestMapping(value="up",method = RequestMethod.POST)
    @AdminPermission
    @ResponseBody
    public Result up(@RequestParam(value="id")Integer id) {
        Seller seller = sellerService.changeStatus(id,0);
        return Result.success(seller);
    }
}
