package com.pdsu.web.controller;

import com.pdsu.mypojo.Result;
import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.User;
import com.pdsu.service.CartService;
import com.pdsu.web.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/21
 * @Description: com.pdsu.web.controller
 * 处理购物车相关业务
 * @version: 1.0
 */
@Controller
@RequestMapping("/cart")
@Api(tags = "7,购物车 相关接口")
public class CartController extends BaseController {

    @Autowired
    private CartService cartServiceImpl;

    //@Value("${cart.key}")
    private String cartKey = "cart:";

    /**
     * 加入购物车接口
     *
     * @param lid
     * @param token
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lid", required = true, dataType = "String", paramType = "query", value = "要加入购物车的课程id"),
            @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "query", value = "用户的token信息")
    })
    @ApiOperation(value = "商品加入购物车接口")
    @ResponseBody
    @RequestMapping(value = "/addCart.do", method = RequestMethod.POST)
    public Result addCart(String lid, String token) {
        Result result = new Result();
        User user = getUser(token);  //从redis获取用户信息

        String uid = user.getuId();
        int num = cartServiceImpl.addCart(lid, uid, cartKey);
        if (num == 1) {
            result.setCode("200");
            result.setMessage("加入成功！");
        } else {
            result.setCode("201");
            result.setMessage("该课程已经在购物车了！");
        }
        return result;
    }


    /**
     * 用户查看购物车
     *
     * @param token
     * @return
     */
    @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "query", value = "用户的token信息")
    @ApiOperation(value = "用户查看购物车")
    @ResponseBody
    @RequestMapping(value = "/showCart.do", method = RequestMethod.GET)
    public Result showCart(String token) {
        Result result = new Result();
        User user = getUser(token);  //从redis获取用户信息

        String uid = user.getuId();
        List<Lesson> lessons = cartServiceImpl.showCart(uid, cartKey);
        if (lessons != null && lessons.size() > 0) {
            result.setCode("200");
            result.setData(lessons);
            result.setMessage("获取成功！");
        } else {
            result.setCode("201");
            result.setMessage("购物车内还没有课程！");
        }
        return result;
    }


    /**
     * 删除课程接口
     *
     * @param token
     * @param lid
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lid", required = true, dataType = "String", paramType = "query", value = "要删除的课程id"),
            @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "query", value = "用户的token信息")
    })
    @ApiOperation(value = "移除除购物车中的商品（已付款/删除购物车商品）")
    @ResponseBody
    @RequestMapping(value = "delectCart.do", method = RequestMethod.POST)
    public Result delectCart(String token, String lid) {
        Result result = new Result();
        User user = getUser(token);  //从redis获取用户信息
        String uid = user.getuId();
        int num = cartServiceImpl.delectCart(uid, cartKey, lid);
        if (num == 1) {
            result.setCode("200");
            result.setMessage("删除成功");
        } else {
            result.setCode("201");
            result.setMessage("删除失败");
        }
        return result;
    }
}
