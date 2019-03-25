package com.pdsu.web.controller;

import com.pdsu.mypojo.Result;
import com.pdsu.pojo.User;
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

import java.io.UnsupportedEncodingException;
import java.util.List;

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
            result.setCode("202");
            result.setMessage("已经关注，不要重复关注！");
        } else {
            result.setCode("201");
            result.setMessage("关注失败，请重试！");
        }
        return result;
    }

    /**
     * 统计学生关注的老师有多少个
     *
     * @param sid
     * @return
     */
    @ApiImplicitParam(name = "sid", required = true, dataType = "String", paramType = "query", value = "学生的id")
    @ApiOperation(value = "统计学生关注的老师有多少个")
    @ResponseBody
    @RequestMapping(value = "countWatchTeacher", method = RequestMethod.GET)
    public Result countWatchTeacher(String sid) {
        int count = studentServiceImpl.countWatchTeacher(sid);
        Result result = new Result();
        result.setCode("200");
        result.setMessage("查询成功");
        result.setData(count);
        return result;
    }

    /**
     * 查询关注的老师信息
     *
     * @param sid
     * @return
     */
    @ApiImplicitParam(name = "sid", required = true, dataType = "String", paramType = "query", value = "学生的id")
    @ApiOperation(value = "查询关注的老师信息")
    @ResponseBody
    @RequestMapping(value = "/selectWatchTeacher", method = RequestMethod.GET)
    public Result selectWatchTeacher(String sid) {

        Result result = new Result();
        List<User> userList = studentServiceImpl.selectWatchTeacher(sid);
        if (userList != null && userList.size() > 0) {
            result.setCode("200");
            result.setMessage("查询成功");
            result.setData(userList);
        } else {
            result.setCode("201");
            result.setMessage("没有查询到相关记录");
        }
        return result;
    }


    /**
     * 取消关注
     *
     * @param sid
     * @param tid
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", required = true, dataType = "String", paramType = "query", value = "学生的id"),
            @ApiImplicitParam(name = "tid", required = true, dataType = "String", paramType = "query", value = "老师的id")
    })
    @ApiOperation(value = "取消关注")
    @ResponseBody
    @RequestMapping(value = "/cancelWatch", method = RequestMethod.POST)
    public Result cancelWatch(String sid, String tid) {

        Result result = new Result();
        int index = studentServiceImpl.cancelWatch(sid, tid);
        if (index > 0) {
            result.setCode("200");
            result.setMessage("取消关注成功");
        } else {
            result.setCode("201");
            result.setMessage("取消关注失败");
        }
        return result;
    }

    /**
     * 学生提交成为老师申请
     * @param sid
     * @param text
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", required = true, dataType = "String", paramType = "query", value = "学生id"),
            @ApiImplicitParam(name = "text", required = true, dataType = "int", paramType = "query", value = "申请内容")
    })
    @ApiOperation(value = "学生提交成为老师申请")
    @ResponseBody
    @RequestMapping(value = "/submitExam", method = RequestMethod.POST)
    public Result submitExam(String sid, String text) throws UnsupportedEncodingException {
        Result result = new Result();
        text = new String(text.getBytes("ISO-8859-1"), "utf-8");  //防止中文乱码
        int index = studentServiceImpl.submitExam(sid, text);
        if (index > 0) {
            result.setCode("200");
            result.setMessage("申请已经提交，请等待审核");
        } else {
            result.setCode("201");
            result.setMessage("申请提交失败");
        }
        return result;
    }
}
