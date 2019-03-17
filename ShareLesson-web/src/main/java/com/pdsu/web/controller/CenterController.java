package com.pdsu.web.controller;

import com.pdsu.pojo.Center;
import com.pdsu.pojo.Result;
import com.pdsu.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/16
 * @Description: com.pdsu.web.controller
 *  返回
 * @version: 1.0
 */

@Controller
@RequestMapping("/center")
public class CenterController {

    @Autowired
    private CenterService centerServiceImpl;

    @ResponseBody
    @RequestMapping("/selectCenter.do")
    public Result selectCebter(){
        Result result=new Result();
        List<Center> list=centerServiceImpl.selectCtener();
        if (list.size()>0){
            result.setCode("200");
            result.setData(list);
            result.setMessage("获取成功");
        }else{
            result.setCode("201");
            result.setMessage("获取首页信息失败");
        }
        return result;
    }
}
