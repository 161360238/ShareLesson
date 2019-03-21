package com.pdsu.web.controller;

import com.pdsu.mypojo.Result;
import com.pdsu.pojo.Classify;
import com.pdsu.service.ClassifyService;
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
 * @Date: 2019/3/18
 * @Description: com.pdsu.web.controller
 * 处理分类相关的业务
 * @version: 1.0
 */
@Controller
@Api(tags = { "2,分类信息 相关接口" })
@RequestMapping("/classify")
public class ClassifyController {

    @Autowired
    private ClassifyService classifyServiceImpl;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid",required = true,paramType = "query",value = "父id")
    })
    @ApiOperation(value  = "根据父分类查询该分类下的课程信息")
    @ResponseBody
    @RequestMapping(value = "/selectClassifyByPid.do",method = RequestMethod.GET)
    public Result selectClassifyByPid(String pid) {

        Result result = new Result();
        List<Classify> classifies = classifyServiceImpl.selectClassifyByPid(pid);
        if (classifies != null && classifies.size() > 0) {
            result.setCode("200");
            result.setData(classifies);
            result.setMessage("获取成功");
        } else {
            result.setCode("201");
            result.setMessage("没有查询到相关分类");
        }
        return result;
    }

}
