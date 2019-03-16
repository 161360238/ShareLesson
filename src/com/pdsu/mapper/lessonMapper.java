package com.pdsu.mapper;

import com.pdsu.pojo.lesson;
import com.pdsu.pojo.lessonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface lessonMapper {
    int countByExample(lessonExample example);

    int deleteByExample(lessonExample example);

    int deleteByPrimaryKey(String lId);

    int insert(lesson record);

    int insertSelective(lesson record);

    List<lesson> selectByExample(lessonExample example);

    lesson selectByPrimaryKey(String lId);

    int updateByExampleSelective(@Param("record") lesson record, @Param("example") lessonExample example);

    int updateByExample(@Param("record") lesson record, @Param("example") lessonExample example);

    int updateByPrimaryKeySelective(lesson record);

    int updateByPrimaryKey(lesson record);
}