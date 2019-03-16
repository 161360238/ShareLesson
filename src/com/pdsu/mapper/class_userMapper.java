package com.pdsu.mapper;

import com.pdsu.pojo.class_user;
import com.pdsu.pojo.class_userExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface class_userMapper {
    int countByExample(class_userExample example);

    int deleteByExample(class_userExample example);

    int deleteByPrimaryKey(String rId);

    int insert(class_user record);

    int insertSelective(class_user record);

    List<class_user> selectByExample(class_userExample example);

    class_user selectByPrimaryKey(String rId);

    int updateByExampleSelective(@Param("record") class_user record, @Param("example") class_userExample example);

    int updateByExample(@Param("record") class_user record, @Param("example") class_userExample example);

    int updateByPrimaryKeySelective(class_user record);

    int updateByPrimaryKey(class_user record);
}