package com.pdsu.service.impl;

import com.pdsu.mapper.ClassifyMapper;
import com.pdsu.pojo.Classify;
import com.pdsu.pojo.ClassifyExample;
import com.pdsu.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/18
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private ClassifyMapper classifyMapper;

    /**
     * 根据父id，查询子分类
     *
     * @param pid
     * @return
     */
    @Override
    public List<Classify> selectClassifyByPid(String pid) {
        List<Classify> classifies = new ArrayList<>();
        ClassifyExample classifyExample = new ClassifyExample();
        classifyExample.createCriteria().andPidEqualTo(pid);
        classifies = classifyMapper.selectByExample(classifyExample);
        if (classifies.size() > 0) {
            return classifies;
        }
        return null;
    }
}
