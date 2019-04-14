package com.pdsu.web.controller;

import com.pdsu.mypojo.PageResult;
import com.pdsu.pojo.Admin;
import com.pdsu.service.AdminService;
import com.pdsu.service.RedisService;
import com.pdsu.web.base.BaseController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangchi
 * @create 2019-04-13
 */
@Controller
@Api(tags = {"10,管理员信息 相关接口"})
@RequestMapping("/admin")
public class adminController extends BaseController {

    @Autowired
    private RedisService redisServiceImpl;

    @Autowired
    private AdminService adminService;


    /**
     * 查询+分页
     * @param admin
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("/search")
    public PageResult search(@RequestBody Admin admin, int page, int rows){
        return adminService.findPage(admin, page, rows);
    }

}
