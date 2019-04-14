package com.pdsu.service;

import com.pdsu.mypojo.PageResult;
import com.pdsu.pojo.Admin;

/**
 * @author zhangchi
 * @create 2019-04-13
 */
public interface AdminService {


    PageResult findPage(Admin admin, int page, int rows);


}
