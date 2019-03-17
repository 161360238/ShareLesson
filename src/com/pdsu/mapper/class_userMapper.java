package com.pdsu.mapper;

import com.pdsu.pojo.Class_User;
import com.pdsu.pojo.Class_UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Class_UserMapper {
    int countByExample(Class_UserExample example);

    int deleteByExample(Class_UserExample example);

    int deleteByPrimaryKey(String rId);

    int insert(Class_User record);

    int insertSelective(Class_User record);

    List<Class_User> selectByExample(Class_UserExample example);

    Class_User selectByPrimaryKey(String rId);

    int updateByExampleSelective(@Param("record") Class_User record, @Param("example") Class_UserExample example);

    int updateByExample(@Param("record") Class_User record, @Param("example") Class_UserExample example);

    int updateByPrimaryKeySelective(Class_User record);

    int updateByPrimaryKey(Class_User record);
}