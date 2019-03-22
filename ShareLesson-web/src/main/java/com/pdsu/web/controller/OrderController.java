package com.pdsu.web.controller;

import com.pdsu.mypojo.Result;
import com.pdsu.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/22
 * @Description: com.pdsu.web.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("/order")
@Api(tags = "9,订单支付 相关接口")
public class OrderController {

    @Autowired
    private OrderService orderServiceImpl;

    @ApiOperation(value = "创建订单接口")
    @ResponseBody
    @RequestMapping("/createOrder")
    public Result createOrder(){

        return null;
    }

}
