package com.pdsu.web.controller;

import com.pdsu.mypojo.Result;
import com.pdsu.pojo.User;
import com.pdsu.service.RedisService;
import com.pdsu.service.UserService;
import com.pdsu.utils.CodecUtil;
import com.pdsu.utils.CookieUtils;
import com.pdsu.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/16
 * @Description: 处理用户相关的业务
 * @version: 1.0
 */
@Controller
@Api(tags = { "5,用户信息 相关接口" })
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private RedisService redisServiceImpl;

    /**
     * 用户登录
     *
     * @param user
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value ="用户登录接口")
    @ResponseBody
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public Result login(@RequestBody User user, HttpServletRequest request,
                        HttpServletResponse response) {
        Result result = new Result();
        User user1 = userServiceImpl.login(user);
        if (user1 != null) {
            result.setCode("200");
            String key = UUID.randomUUID().toString();
            key="token:"+key;
            redisServiceImpl.set(key, JsonUtils.objectToJson(user1));
            redisServiceImpl.expire(key, 60 * 60 * 24 * 7);
            //产生 Cookie
            CookieUtils.setCookie(request, response, "TT_TOKEN", key, 60 * 60 * 24 * 7);
            //把token返回
            result.setToken(key);
            result.setMessage("登录成功");
            result.setData(user1);
        } else {
            result.setCode("201");
            result.setMessage("登录失败");
        }
        return result;
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "用户注册接口")
    @ResponseBody
    @RequestMapping(value = "/regist.do",method =RequestMethod.POST )
    public Result register(User user) {
        Result result = new Result();
        String uid = CodecUtil.createUUID();
        user.setuId(uid);
        int status = userServiceImpl.regist(user);
        if (status == 1) {
            result.setCode("200");
            result.setMessage("注册成功");
        } else if (status == 2) {
            result.setCode("202");
            result.setMessage("用户名已经存在");
        } else {
            result.setCode("201");
            result.setMessage("用户注册失败");
        }
        return result;
    }

    /**
     * 利用token从redis中获取用户数据，检查是否已经登录
     *
     * @param token
     * @return
     */
    @ApiOperation(value = "利用token从redis中获取用户数据")
    @RequestMapping(value = "/getUser.do",method = RequestMethod.POST)
    @ResponseBody
    public Result getUserInfo(String token) {
        return userServiceImpl.getUserByToken(token);
    }



    //根据用户，查询用户已经购买的课程，查询条件:已经开始、未开始

    public Result selectBoughtLesson(String token,int isBegin
            , @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
            User user=getUser(token);
            PageHelper.startPage(pn, 5); //每页显示5条数据
            //执行查询
          //  PageInfo page = new PageInfo( 5);
           // Result result = new Result();
            //result.setData(page);
        return null;
    }



}
