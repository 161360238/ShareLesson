package com.pdsu.web.controller;

import com.pdsu.mypojo.Result;
import com.pdsu.pojo.User;
import com.pdsu.service.TeacherService;
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
@Api(tags = "老师业务相关接口")
public class TeacherController {

    @Autowired
    private TeacherService teacherServiceImpl;

    /**
     * 老师根据自己id，查询自己的粉丝
     *
     * @param tid
     * @return
     */
    @ApiImplicitParam(name = "tid", required = true, dataType = "String", paramType = "query", value = "老师的id")
    @ApiOperation(value = "老师根据自己id，查询自己的粉丝")
    @ResponseBody
    @RequestMapping(value = "/selectFansByTid.do", method = RequestMethod.GET)
    public Result selectFansByTid(String tid) {
        Result result = new Result();
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
    }
}
