package com.pdsu.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pdsu.mypojo.Result;
import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.User;
import com.pdsu.service.CenterService;
import com.pdsu.service.ImageService;
import com.pdsu.service.LessonService;
import com.pdsu.utils.Constant;
import com.pdsu.web.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/17
 * @Description: com.pdsu.web.controller
 * @version: 1.0
 */
@Controller
@Api(tags = {"3,课程信息 相关接口"})
@RequestMapping("/lesson")
public class LessonController extends BaseController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private LessonService lessonServiceImpl;

    @Autowired
    private CenterService centerServiceImpl;

    /**
     * 添加课程时上传图片
     *
     * @param imgFile
     * @return
     */
    @ApiOperation(value = "上传图片接口")
    @RequestMapping(value = "/picUpload.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> picUpload(MultipartFile imgFile) {
        Result result = new Result();
        try {
            return imageService.upload(imgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据分类id查询课程
     * 分页查询
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, dataType = "String", paramType = "query", value = "分类id"),
            @ApiImplicitParam(name = "pn", required = true, dataType = "int", paramType = "query", value = "页码"),
            @ApiImplicitParam(name = "isCharge", required = true, dataType = "int", paramType = "query", value = "是否收费(1:收费 0:免费 2:全部)")
    })
    @ApiOperation(value = "根据分类id查询课程")
    @ResponseBody
    @RequestMapping(value = "/selectLessonByClassify.do", method = RequestMethod.GET)
    public Result selectLessonByClassify(String id, int isCharge
            , @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        Result result = new Result();
        try {
            //在查询之前需要调用，传入页码，以及每页大小
            PageHelper.startPage(pn, 6);
            //后面紧跟的这个查询就是分页查询
            List<Lesson> lessonList = centerServiceImpl.selectLessonByClassifyIdPage(id, isCharge);
            // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
            PageInfo page = new PageInfo(lessonList, 5);
            if (lessonList != null && lessonList.size() > 0) {
                result.setData(page);
                result.setCode("200");
                result.setMessage("查询成功");
            } else {
                result.setCode("201");
                result.setMessage("没要查询到课程");
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
     * 根据父id查询课程信息
     * 分页
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", required = true, dataType = "String", paramType = "query", value = "父id"),
            @ApiImplicitParam(name = "pn", required = true, dataType = "int", paramType = "query", value = "页码"),
            @ApiImplicitParam(name = "isCharge", required = true, dataType = "int", paramType = "query", value = "是否收费(1:收费 0:免费 2:全部)")
    })
    @ApiOperation(value = "根据父id查询课程信息")
    @ResponseBody
    @RequestMapping(value = "selectLessonByParentClassify.do", method = RequestMethod.GET)
    public Result selectLessonByParentClassify(String pid, int isCharge
            , @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        Result result = new Result();
        try {
            PageInfo page= centerServiceImpl.selectLessonByParentClassifyId(pid, isCharge,pn);

            //if (lessonList != null && lessonList.size() > 0) {
            if (page != null ) {
                result.setData(page);
                result.setCode("200");
                result.setMessage("查询成功");
            } else {
                result.setCode("201");
                result.setMessage("没要查询到课程");
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
     * 根据老师id获取老师已经发布的课程（分页）
     * 条件：0：未审核，1：未通过，2：未开始，3：正在进行，4：已经结束，5：未发布成功
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tid", required = true, dataType = "String", paramType = "query", value = "老师的id"),
            @ApiImplicitParam(name = "pn", required = true, dataType = "int", paramType = "query", value = "页码"),
            @ApiImplicitParam(name = "condition", required = true, dataType = "int", paramType = "query", value = "条件：0：正在审核，1：（通过，成功开课）未开始，2：未审核通过，3：正在进行，4：已经结束，5：未开课成功,6:查询全部")
    })
    @ApiOperation(value = "根据老师id获取老师已经发布的课程")
    @ResponseBody
    @RequestMapping(value = "/getLessonByTeacherId.do", method = RequestMethod.GET)
    public Result getLessonByTeacherId(String tid
            , @RequestParam(value = "pn", defaultValue = "1") Integer pn, int condition) {
        Result result = new Result();
        try {
            PageHelper.startPage(pn, 6); //每页显示5条数据
            List<Lesson> lessons = lessonServiceImpl.getLessonByTeacherId(tid, condition);
            PageInfo page = new PageInfo(lessons, 5);

            if (lessons != null) {
                result.setCode("200");
                result.setMessage("查询成功");
                result.setData(page);
            } else {
                result.setCode("201");
                result.setMessage("该老师还没有发布课程");
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
     * 发布的课程
     */
    @ApiOperation(value = "用户发布的课程")
    @ResponseBody
    @RequestMapping(value = "/publishLesson/{token}", method = RequestMethod.POST)
    public Result publishLesson(@RequestBody Lesson lesson, @PathVariable("token") String token) {
        Result result = new Result();

        User user = getUser(token); //判断用户是否登录
        if (user == null) {
            result.setCode("201");
            result.setMessage("token已过期");
            return result;
        }
        try {
            lessonServiceImpl.publishLesson(lesson, user);
            result.setCode("200");
            result.setMessage("发布成功，请等待后台审核！");
        } catch (Exception ex) {
            ex.printStackTrace();
            result.setCode("201");
            result.setMessage("发布失败！");
        }
        return result;
    }


    /**
     * 根据课程id，查询课程详细信息
     *
     * @param lid
     * @return
     */
    @ApiImplicitParam(name = "lid", required = true, dataType = "String", paramType = "query", value = "课程的id")
    @ApiOperation(value = "根据课程id，查询课程详细信息")
    @ResponseBody
    @RequestMapping(value = "/selectLessonByLid", method = RequestMethod.GET)
    public Result selectLessonByLid(String lid) {
        Result result = new Result();
        try {
            Lesson lesson = lessonServiceImpl.selectByLid(lid);
            if (lesson != null) {
                result.setCode("200");
                result.setMessage("查询成功");
                result.setData(lesson);
            } else {
                result.setCode("201");
                result.setMessage("查询失败");
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
     * 学生为课程/老师点赞
     *
     * @param lId
     * @param token
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lId", required = true, dataType = "String", paramType = "query", value = "课程的id"),
            @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "query", value = "用户token")
    })
    @ApiOperation(value = "点赞接口")
    @RequestMapping(value = "/addPraise", method = RequestMethod.POST)
    @ResponseBody
    public Result addPraise(String lId, String token) {
        Result result = new Result();
        User user = getUser(token);
        if (user == null) {
            result.setMessage(Constant.BAD_TOKEN_MSG);
            result.setCode(Constant.BAD_TOKEN_CODE);
            return result;
        }
        try {
            int num = lessonServiceImpl.addPraise(lId, user.getuId());
            if (num == 2) {
                result.setMessage("点赞成功");
                result.setCode("200");
                return result;
            } else if (num == 1) {
                result.setMessage("不能重复点赞");
                result.setCode("201");
                return result;
            } else {
                result.setMessage("服务器错误");
                result.setCode("202");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            return result;
        }
    }

    /**
     * 判断用户是否已经点赞
     *
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lid", required = true, dataType = "String", paramType = "query", value = "课程的id"),
            @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "query", value = "用户token")
    })
    @ApiOperation(value = "查询用户是否已经点赞")
    @RequestMapping(value = "/isPrasie", method = RequestMethod.GET)
    @ResponseBody
    public Result isPrasie(String token, String lid) {
        Result result = new Result();
        User user = getUser(token);
        if (user == null) {
            result.setMessage(Constant.BAD_TOKEN_MSG);
            result.setCode(Constant.BAD_TOKEN_CODE);
            return result;
        }
        try {
            int num = lessonServiceImpl.isPrasie(user.getuId(), lid);
            if (num > 0) {
                result.setCode("200");
                result.setMessage("已经点赞");
                return result;
            } else {
                result.setCode("201");
                result.setMessage("未点赞");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            return result;
        }
    }

    /**
     * 学生取消为课程/老师点赞
     *
     * @param lId
     * @param token
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lId", required = true, dataType = "String", paramType = "query", value = "课程的id"),
            @ApiImplicitParam(name = "token", required = true, dataType = "String", paramType = "query", value = "用户token")
    })
    @ApiOperation(value = "取消点赞接口")
    @RequestMapping(value = "/deletePraise", method = RequestMethod.POST)
    @ResponseBody
    public Result deletePraise(String lId, String token) {
        Result result = new Result();
        User user = getUser(token);
        if (user == null) {
            result.setMessage(Constant.BAD_TOKEN_MSG);
            result.setCode(Constant.BAD_TOKEN_CODE);
            return result;
        }
        try {
            int num = lessonServiceImpl.deletePraise(lId, user.getuId());
            if (num == 1) {
                result.setMessage("取消点赞成功");
                result.setCode("200");
                return result;
            } else {
                result.setMessage("点过赞才能取消");
                result.setCode("201");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage(Constant.INTERNAL_ERROR_MSG);
            result.setCode(Constant.INTERNAL_ERROR_CODE);
            return result;
        }
    }

}
