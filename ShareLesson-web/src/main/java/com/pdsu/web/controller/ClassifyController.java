package com.pdsu.web.controller;

import com.pdsu.mypojo.Result;
import com.pdsu.pojo.Classify;
import com.pdsu.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/classify")
public class ClassifyController {

    @Autowired
    private ClassifyService classifyServiceImpl;

    @ResponseBody
    @RequestMapping("/selectClassifyByPid.do")
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
