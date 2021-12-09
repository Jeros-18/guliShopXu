package com.atjh.cmsservice.controller;


import com.atjh.cmsservice.entity.CrmBanner;
import com.atjh.cmsservice.service.CrmBannerService;
import com.atjh.commonUtils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author jahui
 * @since 2021-12-06
 */
@RestController
@RequestMapping("/eduservice/banner")
@CrossOrigin
public class CrmBannerController {

    @Autowired
    private CrmBannerService bannerService;


}


