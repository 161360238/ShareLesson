package com.pdsu.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pdsu.mypojo.Result;
import com.pdsu.pojo.Message;
import com.pdsu.service.MessageService;
import com.pdsu.service.RedisService;
import com.pdsu.utils.Constant;
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

import java.util.List;
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
        Result result = new Result();
        try {
            Map<String, Object> messge = messageServiceImpl.messge(phone);
            if (messge != null) {
                result.setCode("200");
                result.setMessage("短信发送成功！");
                result.setData(messge);
            } else {
                result.setCode("201");
                result.setMessage("短信发送失败！");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            return result;
        }
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
        Result result = new Result();
        try {
            boolean pass = messageServiceImpl.verification(phone, code);
            if (pass == true) {
                result.setCode("200");
                result.setMessage("验证通过");
            } else {
                result.setCode("201");
                result.setMessage("短信验证码错误");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            return result;
        }
    }


    /**
     * 学生或老师查看消息接口（分页查询）
     *
     * @param uid
     * @param condition
     * @param pn
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", required = true, dataType = "String", paramType = "query", value = "用户id"),
            @ApiImplicitParam(name = "pn", required = true, dataType = "String", paramType = "query", value = "页码"),
            @ApiImplicitParam(name = "condition", required = true, dataType = "int", paramType = "query", value = "查询条件（1：已读 0：未读 2：全部查询）")
    })
    @ApiOperation(value = "学生或老师查看消息接口（分页查询）")
    @ResponseBody
    @RequestMapping(value = "/selectMessage", method = RequestMethod.GET)
    public Result selectMessage(String uid, int condition
            , @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        Result result = new Result();

        try {
            PageHelper.startPage(pn, 10); //每页显示5条数据
            List<Message> messageList = messageServiceImpl.selectMessage(uid, condition);
            PageInfo page = new PageInfo(messageList, 5);

            if (messageList != null && messageList.size() > 0) {
                result.setCode("200");
                result.setMessage("查询成功");
                result.setData(page);
            } else {
                result.setCode("201");
                result.setMessage("暂时没有消息");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            return result;
        }
    }

    /**
     * 标记消息为已读
     *
     * @param mid
     * @return
     */
    @ApiImplicitParam(name = "mid", required = true, dataType = "String", paramType = "query", value = "消息id")
    @ApiOperation(value = "标记消息为已读")
    @ResponseBody
    @RequestMapping(value = "/setMessageRead", method = RequestMethod.POST)
    public Result setMessageRead(String mid) {
        Result result = new Result();
        try {
            int index = messageServiceImpl.setMessageRead(mid);
            if (index > 0) {
                result.setCode("200");
                result.setMessage("标记成功");
            } else {
                result.setCode("201");
                result.setMessage("标记失败");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            return result;
        }
    }
}
