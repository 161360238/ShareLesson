package com.pdsu.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pdsu.mypojo.MyOrderParam;
import com.pdsu.mypojo.Result;
import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.Orders;
import com.pdsu.pojo.User;
import com.pdsu.service.OrderService;
import com.pdsu.web.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public Result createOrder(@RequestBody MyOrderParam param, String token) {
        User user = getUser(token);
        int num = orderServiceImpl.createOrder(param, user);
        Result result = new Result();
        if (num == 1) {
            result.setCode("200");
            result.setMessage("创建订单成功！");
        } else if (num == 2) {
            result.setCode("201");
            result.setMessage("订单商品已经付过款，请去历史订单中查看！");
        } else {
            result.setCode("201");
            result.setMessage("创建订单失败！");
        }
        return result;
    }


    /**
     * 删除订单接口
     *
     * @param token
     * @param oid
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "query", value = "用户的token"),
            @ApiImplicitParam(name = "oid", required = true, dataType = "String", paramType = "query", value = "订单id")
    })
    @ApiOperation(value = "删除订单接口")
    @ResponseBody
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    public Result deleteOrder(String token, String oid) {
        Result result = new Result();
        User user = getUser(token);
        try {
            int num = orderServiceImpl.deleteOrder(user.getuId(), oid);
            if (num > 0) {
                result.setCode("200");
                result.setMessage("删除订单成功");
            }
        } catch (Exception e) {
            result.setCode("201");
            result.setMessage("删除订单失败");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 查询订单接口
     *
     * @param token
     * @param condition
     * @param pn
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "query", value = "用户token"),
            @ApiImplicitParam(name = "pn", required = true, dataType = "int", paramType = "query", value = "页码"),
            @ApiImplicitParam(name = "condition", required = true, dataType = "int", paramType = "query", value = "查询条件(1:已付款 0:未付款 2:未评价，3：已经评价)")
    })
    @ApiOperation(value = "查看订单接口(带分页)")
    @ResponseBody
    @RequestMapping(value = "/selectOrder", method = RequestMethod.GET)
    public Result selectOrder(String token, int condition
            , @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        Result result = new Result();
        User user = getUser(token);
        PageHelper.startPage(pn, 5); //每页显示5条数据
        List<Orders> orders = orderServiceImpl.selectOrder(user.getuId(), condition);
        if (orders != null && orders.size() > 0) {
            PageInfo page = new PageInfo(orders, 5);
            result.setData(page);
            result.setCode("200");
            result.setMessage("查询成功");
        } else {
            result.setCode("201");
            result.setMessage("没有查询到相关记录");
        }
        return result;
    }

    /**
     * 查看已经购买过的课程（分页）
     *
     * @param token
     * @param condition
     * @param pn
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "query", value = "用户token"),
            @ApiImplicitParam(name = "pn", required = true, dataType = "int", paramType = "query", value = "页码"),
            @ApiImplicitParam(name = "condition", required = true, dataType = "int", paramType = "query", value = "查询条件：1表示未开始上课，0表示已经结束")
    })
    @ApiOperation(value = "查看已经购买过的课程（分页）,condition：1表示未开始上课，0表示已经结束")
    @ResponseBody
    @RequestMapping(value = "selectBoughtLesson", method = RequestMethod.GET)
    public Result selectBoughtLesson(String token, int condition
            , @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        User user = getUser(token);
        Result result = new Result();
        PageHelper.startPage(pn, 5); //每页显示5条数据
        List<Lesson> lessons = orderServiceImpl.selectBoughtLesson(user.getuId(), condition);
        if (lessons != null && lessons.size() > 0) {
            PageInfo page = new PageInfo(lessons, 5);
            result.setData(page);
            result.setCode("200");
            result.setMessage("查询成功");
        } else {
            result.setCode("201");
            result.setMessage("没有查询到相关记录");
        }
        return result;
    }
}

