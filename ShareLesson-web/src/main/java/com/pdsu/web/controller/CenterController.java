package com.pdsu.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pdsu.mypojo.ExtendCenter;
import com.pdsu.mypojo.PageResult;
import com.pdsu.mypojo.Result;
import com.pdsu.pojo.Center;
import com.pdsu.pojo.Classify;
import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.User;
import com.pdsu.service.CenterService;
import com.pdsu.utils.Constant;
import com.pdsu.utils.JsonUtils;
import com.pdsu.web.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@Api(tags = {"1,主页信息 相关接口"})
@RequestMapping("/center")
public class CenterController extends BaseController {

    @Autowired
    private CenterService centerServiceImpl;

    /**
     * 获取首页导航栏信息
     *
     * @return
     */
    @ApiOperation(value = "hello", notes = "获取首页导航栏信息")
    @ResponseBody
    @RequestMapping(value = "/selectCenter.do", method = RequestMethod.GET)
    public Result selectCebter() {
        Result result = new Result();
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            return result;
        }
    }

    /**
     * 首页获取推送课程信息
     *
     * @return
     */
    @RequestMapping(value = "/getLesson.do", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "首页获取推送课程信息")
    public Result getLesson() {
        Result result = new Result();
        try {
            Map<Classify, List<Lesson>> message = new HashMap<>();
            Map<String, List<Lesson>> message2 = new HashMap<>();
            //查询所有子分类
            List<Classify> classifies = centerServiceImpl.selectClassify();

            //根据子分类查询每个分类下的最新课程信息
            message = centerServiceImpl.selectLessonByClassifys(classifies);

            for (Classify key : message.keySet()) {
                //  System.out.println(JsonUtils.objectToJson(key));
                message2.put(JsonUtils.objectToJson(key), message.get(key));
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
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            return result;
        }
    }


    /**
     * 设置首页推送课程的分类(后台设置)
     *
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id1", required = true, dataType = "String", paramType = "query", value = "推送课程分类id1"),
            @ApiImplicitParam(name = "id2", required = true, dataType = "String", paramType = "query", value = "推送课程分类id2")
    })
    @ApiOperation(value = "设置首页推送的课程分类（后台用）")
    @ResponseBody
    @RequestMapping(value = "/setPushLesson.do", method = RequestMethod.POST)
    public Result setPushLesson(String id1, String id2) {
        Result result = new Result();
        try {
            int num = centerServiceImpl.setPushLesson(id1, id2);
            if (num == 1) {
                result.setCode("200");
                result.setMessage("设置成功！");
            } else {
                result.setCode("201");
                result.setMessage("操作失败！");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            return result;
        }
    }


    @ApiOperation(value = "获取首页推送的老师信息")
    @ResponseBody
    @RequestMapping(value = "/pushTeacher", method = RequestMethod.GET)
    public Result pushTeacher(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        Result result = new Result();
        try {
            PageHelper.startPage(pn, 4); //每页显示4条数据
            List<User> teachers = centerServiceImpl.pushTeacher();
            PageInfo page = new PageInfo(teachers, 3);

            if (teachers != null && teachers.size() > 0) {
                result.setCode("200");
                result.setMessage("查询成功");
                result.setData(page);
            } else {
                result.setCode("201");
                result.setMessage("没有查询到相关信息");
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
     * 获取用户列表
     *
     * @param center
     * @param page
     * @return
     */
    @ApiImplicitParam(name = "page", required = true, dataType = "Integer", paramType = "query", value = "当前页")
    @ApiOperation(value = "首页导航栏信息维护")
    @ResponseBody
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public PageResult search(@RequestBody Center center, int page, int rows) {
        return centerServiceImpl.findPage(center, page, rows);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Result delete(Integer[] ids) {
        try {
            centerServiceImpl.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 添加
     *
     * @param center
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Result add(@RequestBody Center center) {
        try {
            centerServiceImpl.add(center);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     *
     * @param center
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Result update(@RequestBody Center center) {
        try {
            centerServiceImpl.update(center);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/findOne")
    public Center findOne(String id) {
        return centerServiceImpl.findOne(id);
    }

    @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "query", value = "用户的token")
    @ApiOperation(value = "根据身份不同返回不同的个人中心菜单")
    @RequestMapping(value = "/selectMenu", method = RequestMethod.GET)
    @ResponseBody
    public Result selectMenu(String token) {
        Result result = new Result();
        User user = getUser(token); //判断用户是否登录
        if (user == null) {
            result.setCode("201");
            result.setMessage("token已过期");
            return result;
        }
        try {
            List<ExtendCenter> excenters =new ArrayList<>();
            List<Center> centers = centerServiceImpl.selectMenu(user);
            for (Center center: centers) {
                ExtendCenter extendCenter=new ExtendCenter();
                extendCenter.setImg(center.getModelName().split(",")[1]);
                extendCenter.setModelName(center.getModelName().split(",")[0]);
                extendCenter.setCenterId(center.getCenterId());
                extendCenter.setModelSort(center.getModelSort());
                extendCenter.setModelType(center.getModelType());
                extendCenter.setModelUrl(center.getModelUrl());
                excenters.add(extendCenter);
            }

            if (excenters != null && excenters.size() > 0) {
                result.setCode("200");
                result.setMessage("获取成功");
                result.setData(excenters);
                return result;
            } else {
                result.setCode("201");
                result.setMessage("获取失败");
                return result;
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            return result;
        }
    }


}
