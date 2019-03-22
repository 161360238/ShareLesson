package com.pdsu.web.controller;

import com.pdsu.mypojo.MyOrderParam;
import com.pdsu.mypojo.Result;
import com.pdsu.pojo.User;
import com.pdsu.service.OrderService;
import com.pdsu.web.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderServiceImpl;

    @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "query", value = "用户的token")
    @ApiOperation(value = "创建订单接口")
    @ResponseBody
    @RequestMapping(value = "/createOrder",method = RequestMethod.POST)
    public Result createOrder(@RequestBody MyOrderParam param, String token) {
        User user = getUser(token);
        int num = orderServiceImpl.createOrder(param, user);
        Result result = new Result();
        if (num > 0) {
            result.setCode("200");
            result.setMessage("创建订单成功！");
        } else {
            result.setCode("201");
            result.setMessage("创建订单失败！");
        }
        return result;
    }

}
