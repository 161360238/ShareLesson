package com.pdsu.web.controller;

import com.pdsu.pojo.Result;
import com.pdsu.pojo.User;
import com.pdsu.service.RedisService;
import com.pdsu.service.UserService;
import com.pdsu.utils.CookieUtils;
import com.pdsu.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private RedisService redisServiceImpl;

    /**
     * 用户登录
     * @param user
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("login.do")
    public Result login(User user, HttpServletRequest request,
                        HttpServletResponse response) {

        Result result = new Result();
        User user1 = userServiceImpl.login(user);
        if (user1 != null) {
            result.setCode("200");
            String key = UUID.randomUUID().toString();
            redisServiceImpl.set(key, JsonUtils.objectToJson(user));
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
}
