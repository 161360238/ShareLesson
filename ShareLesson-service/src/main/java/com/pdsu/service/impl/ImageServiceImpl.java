package com.pdsu.service.impl;

import com.pdsu.mapper.LessonMapper;
import com.pdsu.mapper.PictureMapper;
import com.pdsu.service.ImageService;
import com.pdsu.utils.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/17
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Value("${ftpclient.host}")
    private String host;
    @Value("${ftpclient.port}")
    private int port;
    @Value("${ftpclient.username}")
    private String username;
    @Value("${ftpclient.password}")
    private String password;
    @Value("${ftpclient.basePath}")
    private String basePath;
    @Value("${ftpclient.filepath}")
    private String filePath;
    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private LessonMapper lessonMapper;

    @Override
    public Map<String, Object> upload(MultipartFile imgFile) throws IOException {
        String fileName = UUID.randomUUID() + imgFile.getOriginalFilename().substring(
                imgFile.getOriginalFilename().lastIndexOf("."));
        boolean result = FtpUtil.uploadFile(host, port, username, password, basePath, filePath,
                fileName, imgFile.getInputStream());
        Map<String, Object> map = new HashMap<>();
        if (result) {
            map.put("error", 0);
            map.put("url", "http://39.96.207.238/" + fileName);
        } else {
            map.put("error", 1);
            map.put("url", "图片上传失败");
        }
        return map;
    }
}
