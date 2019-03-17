package com.pdsu.service.impl;

import com.pdsu.mapper.CenterMapper;
import com.pdsu.pojo.Center;
import com.pdsu.pojo.CenterExample;
import com.pdsu.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/17
 * @Description: com.pdsu.service.impl
 * @version: 1.0
 */
@Service
public class CenterServiceImpl implements CenterService {

    @Autowired
    private CenterMapper centerMapper;

    /**
     * 查询首页信息
     * @return
     */
    @Override
    public List<Center> selectCtener() {
        CenterExample centerExample = new CenterExample();
        return centerMapper.selectByExample(centerExample);
    }
}
