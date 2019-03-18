package com.pdsu.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pdsu.mypojo.Result;
import com.pdsu.pojo.Lesson;
import com.pdsu.service.CenterService;
import com.pdsu.service.ImageService;
import com.pdsu.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/17
 * @Description: com.pdsu.web.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("/lesson")
public class LessonController {

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
    @RequestMapping("/picUpload.do")
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
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectLessonByClassify.do")
    public Result selectLessonByClassify(String id
            , @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //在查询之前需要调用，传入页码，以及每页大小
        PageHelper.startPage(pn, 5);
        //后面紧跟的这个查询就是分页查询
        List<Lesson> lessonList = centerServiceImpl.selectLessonByClassifyId(id);
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(lessonList, 5);
        Result result = new Result();
        result.setData(page);
        return result;
    }

    /**
     * 根据父id查询课程信息
     *
     * @param pid
     * @return
     */
    @ResponseBody
    @RequestMapping("selectLessonByParentClassify.do")
    public Result selectLessonByParentClassify(String pid
            , @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 5); //每页显示5条数据
        List<Lesson> lessonList = centerServiceImpl.selectLessonByParentClassifyId(pid);
        return null;
    }
}
