package com.pdsu.web.controller;

import com.pdsu.mypojo.Result;
import com.pdsu.mypojo.ThreeResult;
import com.pdsu.pojo.Classify;
import com.pdsu.service.ClassifyService;
import com.pdsu.utils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
        try {
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
        }catch (Exception e){
            e.printStackTrace();
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            return result;
        }
    }

    /**
     * 查询所有课程分类
     * @return
     */
    @ResponseBody
    @RequestMapping("/loadData")
    public Result loadData(){
        Result result = new Result();
        try {
            List<ThreeResult> list = classifyServiceImpl.loadData();
            result.setSuccess(true);
            result.setData(list);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage("加载数据失败！");
          e.printStackTrace();
        }
        return result;
    }



    /**
     * 增加
     * @param classify
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Result add(@RequestBody Classify classify){
        try {
            classifyServiceImpl.add(classify);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param classify
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Result update(@RequestBody Classify classify){
        try {
            classifyServiceImpl.update(classify);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Result delete(String id){
        Result result = new Result();
        try {
            result = classifyServiceImpl.delete(id);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }


}
