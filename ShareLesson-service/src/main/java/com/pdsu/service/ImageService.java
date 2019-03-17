package com.pdsu.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/17
 * @Description: com.pdsu.service
 * 图片上传相关
 * @version: 1.0
 */
public interface ImageService {
    public Map<String, Object> upload(MultipartFile imgFile) throws IOException;
}
