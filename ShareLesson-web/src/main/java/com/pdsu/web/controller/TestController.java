package com.pdsu.web.controller;

import com.pdsu.pojo.Result;
import com.pdsu.pojo.User;
import com.pdsu.service.RedisService;
import com.pdsu.service.TestService;
import com.pdsu.utils.CookieUtils;
import com.pdsu.utils.JsonUtils;
import com.pdsu.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 * @Auther: http://wangjie
 * @Date: 2019/3/15
 * @Description: com.pdsu.web.controller
 * @version: 1.0
 */
@Controller
public class TestController extends BaseController {

    @Autowired
    private TestService testService;

    @Autowired
    private RedisService redisServiceImpl;


    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/addUser.do")
    public Result addUser(User user) {
        testService.addUser(user);
        Result result = new Result();
        result.setCode("200");
        return result;
    }

    /**
     * 测试用户登录，测试只校验用户名
     *
     * @param username
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/login.do")
    public Result login(String username, HttpServletRequest request,
                        HttpServletResponse response) {
        Result result = new Result();
        User user = testService.login(username);
        if (user != null) {
            result.setCode("200");
            String key = UUID.randomUUID().toString();
            redisServiceImpl.set(key, JsonUtils.objectToJson(user));
            redisServiceImpl.expire(key, 60 * 60 * 24 * 7);
            //产生 Cookie
            CookieUtils.setCookie(request, response, "TT_TOKEN", key, 60 * 60 * 24 * 7);
            //把token返回
            result.setToken(key);
            result.setMessage("登录成功");
        } else {
            result.setCode("201");
            result.setMessage("登录失败");
        }
        return result;
    }

    /**
     * 利用token从redis中获取用户数据，检查是否已经登录
     *
     * @param token
     * @return
     */
    @RequestMapping("/getUser.do")
    @ResponseBody
    public Result getUserInfo(String token) {
        Result result = new Result();
        String json = redisServiceImpl.get(token);

        if (json != null && !json.equals("")) {
            User user = JsonUtils.jsonToPojo(json, User.class);
            //可以把密码清空
            user.setPassword(null);
            result.setData(user);
        } else {
            result.setMessage("获取失败");
        }
        return result;
    }

    /**
     * 测试退出登录功能，把用户信息从redis中删除
     *
     * @param token
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/logout.do")
    public Result logout(String token, HttpServletRequest request,
                         HttpServletResponse response) {
        Result result = new Result();
        Long index = redisServiceImpl.del(token);
        CookieUtils.deleteCookie(request, response, "TT_TOKEN");
        result.setCode("200");
        result.setMessage("退出成功");
        return result;
    }
}
