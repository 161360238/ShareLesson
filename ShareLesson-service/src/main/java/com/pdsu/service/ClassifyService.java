package com.pdsu.service;

import com.pdsu.mypojo.Result;
import com.pdsu.mypojo.ThreeResult;
import com.pdsu.pojo.Classify;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/18
 * @Description: com.pdsu.service
 * @version: 1.0
 */
public interface ClassifyService {

    /**
     * 根据父分类id，查询分类
     * @param pid
     * @return
     */
    List<Classify> selectClassifyByPid(String pid);

    /**
     * 查询所有课程分类
     * @return
     */
    List<ThreeResult>  loadData();

    void update(Classify classify);

    void add(Classify classify);

    Result delete(String id);
}
