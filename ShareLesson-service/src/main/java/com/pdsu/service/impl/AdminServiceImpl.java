package com.pdsu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pdsu.mapper.AdminMapper;
import com.pdsu.mypojo.PageResult;
import com.pdsu.pojo.Admin;
import com.pdsu.pojo.AdminExample;
import com.pdsu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员
 * @author zhangchi
 * @create 2019-04-13
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public PageResult findPage(Admin admin, int page, int rows) {
        PageHelper.startPage(page,rows);
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        if(admin !=null){
            if(admin.getaName() !=null && admin.getaName().length()>0){
                criteria.andANameLike(admin.getaName());
            }
        }
        Page<Admin> mypage = (Page<Admin>) adminMapper.selectByExample(example);
        return new PageResult(mypage.getTotal(),mypage.getResult());
    }



}
