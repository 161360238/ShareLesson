package com.pdsu.mapper;

import com.pdsu.pojo.User_lesson;
import com.pdsu.pojo.User_lessonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface User_lessonMapper {
    int countByExample(User_lessonExample example);

    int deleteByExample(User_lessonExample example);

    int deleteByPrimaryKey(String rId);

    int insert(User_lesson record);

    int insertSelective(User_lesson record);

    List<User_lesson> selectByExample(User_lessonExample example);

    User_lesson selectByPrimaryKey(String rId);

    int updateByExampleSelective(@Param("record") User_lesson record, @Param("example") User_lessonExample example);

    int updateByExample(@Param("record") User_lesson record, @Param("example") User_lessonExample example);

    int updateByPrimaryKeySelective(User_lesson record);

    int updateByPrimaryKey(User_lesson record);
}