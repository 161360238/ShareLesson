package com.pdsu.web.controller;

import com.pdsu.mypojo.Result;
import com.pdsu.pojo.User;
import com.pdsu.service.TeacherService;
import com.pdsu.utils.Constant;
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
 * @Date: 2019/3/19
 * @Description: com.pdsu.web.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("/teacher")
@Api(tags = "6,老师业务相关接口")
public class TeacherController extends BaseController {

    @Autowired
    private TeacherService teacherServiceImpl;

    /**
     * 老师根据自己id，查询自己的粉丝
     *
     * @param tid
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tid", required = true, dataType = "String", paramType = "query", value = "老师的id"),
            @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "query", value = "老师token")})
    @ApiOperation(value = "老师根据自己id，查询自己的粉丝")
    @ResponseBody
    @RequestMapping(value = "/selectFansByTid.do", method = RequestMethod.GET)
    public Result selectFansByTid(String tid, String token) {
        Result result = new Result();
        User user = getUser(token);
        if (user == null) {
            result.setCode(Constant.BAD_TOKEN_MSG);
            result.setCode(Constant.BAD_TOKEN_CODE);
            return result;
        }
        try {
            List<User> fans = teacherServiceImpl.selectFansByTid(tid);
            if (fans != null && fans.size() > 0) {
                result.setCode("200");
                result.setMessage("查询成功");
                result.setData(fans);
            } else {
                result.setCode("201");
                result.setMessage("没有查询到粉丝");
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
     * 根据老师ID，查询老师个人信息
     * @param tid
     * @param token
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tid", required = true, dataType = "String", paramType = "query", value = "老师的id"),
            @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "query", value = "token")
    })
    @ApiOperation(value = "根据老师ID，查询老师个人信息")
    @ResponseBody
    @RequestMapping(value = "/selectTeacherByTid", method = RequestMethod.GET)
    public Result selectTeacherByTid(String tid, String token) {
        Result result = new Result();
        User user1 = getUser(token);
        if (user1 == null) {
            result.setMessage(Constant.BAD_TOKEN_MSG);
            result.setCode(Constant.BAD_TOKEN_CODE);
            return result;
        }
        try {
            User user = teacherServiceImpl.selectTeacherByTid(tid);
            if (user != null) {
                result.setCode("200");
                result.setMessage("查询成功");
                result.setData(user);
            } else {
                result.setCode("201");
                result.setMessage("没要查询到相关信息");
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
