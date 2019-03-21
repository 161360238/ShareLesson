package com.pdsu.web.controller;

import com.pdsu.mypojo.Result;
import com.pdsu.pojo.Center;
import com.pdsu.pojo.Classify;
import com.pdsu.pojo.Lesson;
import com.pdsu.service.CenterService;
import com.pdsu.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/16
 * @Description: com.pdsu.web.controller
 * 返回
 * @version: 1.0
 */

@Controller
@Api(tags = { "1,主页信息 相关接口" })
@RequestMapping("/center")
public class CenterController {

    @Autowired
    private CenterService centerServiceImpl;

    /**
     * 获取首页导航栏信息
     *
     * @return
     */
    @ApiOperation(value = "hello", notes = "获取首页导航栏信息")
    @ResponseBody
    @RequestMapping(value = "/selectCenter.do",method = RequestMethod.GET)
    public Result selectCebter() {
        Result result = new Result();
        List<Center> list = centerServiceImpl.selectCtener();
        if (list.size() > 0) {
            result.setCode("200");
            result.setData(list);
            result.setMessage("获取成功");
        } else {
            result.setCode("201");
            result.setMessage("获取首页信息失败");
        }
        return result;
    }

    /**
     * 首页获取推送课程信息
     *
     * @return
     */
    @RequestMapping(value = "/getLesson.do",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "首页获取推送课程信息")
    public Result getLesson() {
        Result result = new Result();
        Map<Classify, List<Lesson>> message = new HashMap<>();
        Map<String, List<Lesson>> message2 = new HashMap<>();
        //查询所有子分类
        List<Classify> classifies = centerServiceImpl.selectClassify();
        //根据子分类查询每个分类下的最新课程信息
        message = centerServiceImpl.selectLessonByClassifys(classifies);
        for (Classify key:message.keySet()) {
            System.out.println(JsonUtils.objectToJson(key));
            message2.put(JsonUtils.objectToJson(key),message.get(key));
        }
        if (message2.size() > 0) {
            result.setCode("200");
            result.setMessage("查询成功");
            result.setData(message2);
        } else {
            result.setCode("201");
            result.setMessage("没有查询考课程信息");
        }
        return result;
    }
}
