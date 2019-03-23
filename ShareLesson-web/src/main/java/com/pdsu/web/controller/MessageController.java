package com.pdsu.web.controller;

import com.pdsu.mypojo.Result;
import com.pdsu.service.MessageService;
import com.pdsu.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/22
 * @Description: com.pdsu.web.controller
 * 处理短信验证，个人消息业务
 * @version: 1.0
 */

@Controller
@Api(tags = "8,短信验证码、个人消息 相关接口")
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private RedisService redisServiceImpl;

    @Autowired
    private MessageService messageServiceImpl;

    /**
     * @Description:发送验证码接口
     */
    @ApiImplicitParam(name = "phone", required = true, dataType = "String", paramType = "query", value = "需要发送短信的手机号")
    @ApiOperation(value = "发送短息验证码接口")
    @ResponseBody
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public Result messge(String phone) {
        Map<String, Object> messge = messageServiceImpl.messge(phone);
        Result result = new Result();
        if (messge != null) {
            result.setCode("200");
            result.setMessage("短信发送成功！");
            result.setData(messge);
        } else {
            result.setCode("201");
            result.setMessage("短信发送失败！");
        }
        return result;
    }

    /**
     * @Description:验证验证码
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", required = true, dataType = "String", paramType = "query", value = "需要验证的手机号"),
            @ApiImplicitParam(name = "code", required = true, dataType = "String", paramType = "query", value = "短息验证码")
    })
    @ApiOperation(value = "验证 短息验证码")
    @ResponseBody
    @RequestMapping(value = "/verification", method = RequestMethod.GET)
    public Result verification(String phone, String code) {
        boolean pass = messageServiceImpl.verification(phone, code);
        Result result = new Result();
        if (pass == true) {
            result.setCode("200");
            result.setMessage("验证通过");
        } else {
            result.setCode("201");
            result.setMessage("短信验证码错误");
        }
        return result;
    }


}
