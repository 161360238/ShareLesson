package com.pdsu.web.controller;

import com.pdsu.mypojo.Result;
import com.pdsu.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @RequestMapping("/picUpload.do")
    @ResponseBody
    public Map<String,Object> picUpload(MultipartFile imgFile){
        Result result=new Result();
        try {
            return imageService.upload(imgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
