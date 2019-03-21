package com.pdsu.web.controller;

import com.pdsu.mypojo.Result;
import com.pdsu.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.image.RescaleOp;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/19
 * @Description: com.pdsu.web.controller
 * @version: 1.0
 */
@Controller
@Api(tags = "4,学生业务 相关接口")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentServiceImpl;

    /**
     * 学生关注老师
     *
     * @param sid
     * @param tid
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", required = true, dataType = "String", paramType = "query", value = "学生的id"),
            @ApiImplicitParam(name = "tid", required = true, dataType = "String", paramType = "query", value = "老师的id")
    })
    @ApiOperation(value = "学生关注老师的业务接口")
    @ResponseBody
    @RequestMapping(value = "/watchTeacher.do", method = RequestMethod.POST)
    public Result watchTeacher(String sid, String tid) {
        Result result = new Result();
        int ans = studentServiceImpl.watchTeacher(sid, tid);
        if (ans == 1) {
            result.setCode("200");
            result.setMessage("关注成功！");
        } else if (ans == 2) {
            result.setCode("200");
            result.setMessage("已经关注，不要重复关注！");
        } else {
            result.setCode("201");
            result.setMessage("关注失败，请重试！");
        }
        return result;
    }

}
