package com.ccb.dianping.controller.admin;

import com.ccb.dianping.common.BizException;
import com.ccb.dianping.common.annotation.AdminPermission;
import com.ccb.dianping.common.bean.Result;
import com.ccb.dianping.common.util.CommonUtils;
import com.ccb.dianping.model.vo.admin.CategoryCreateReq;
import com.ccb.dianping.model.vo.admin.PageReq;
import com.ccb.dianping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/index")
    @ResponseBody
    @AdminPermission
    public ModelAndView index(PageReq pageReq) {
        ModelAndView modelAndView = new ModelAndView("/admin/category/index");
        modelAndView.addObject("data", categoryService.categoryPage(pageReq));
        modelAndView.addObject("CONTROLLER_NAME", "category");
        modelAndView.addObject("ACTION_NAME", "index");
        return modelAndView;
    }

    @RequestMapping("/create")
    @ResponseBody
    @AdminPermission
    public Result create(@Valid @RequestBody CategoryCreateReq categoryCreateReq
            , BindingResult bindingResult) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        if (bindingResult.hasErrors()) {
            throw new BizException(CommonUtils.mergeErrorString(bindingResult));
        }
        return Result.success(categoryService.create(categoryCreateReq));
    }

    @RequestMapping("/createPage")
    @AdminPermission
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView("/admin/category/create");
        modelAndView.addObject("CONTROLLER_NAME", "category");
        modelAndView.addObject("ACTION_NAME", "create");
        return modelAndView;
    }

}
