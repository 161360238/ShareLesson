package com.pdsu.mapper;

import com.pdsu.pojo.Lesson;
import com.pdsu.pojo.LessonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LessonMapper {
    int countByExample(LessonExample example);

    int deleteByExample(LessonExample example);

    int deleteByPrimaryKey(String lId);

    int insert(Lesson record);

    int insertSelective(Lesson record);

    List<Lesson> selectByExample(LessonExample example);

    Lesson selectByPrimaryKey(String lId);

    int updateByExampleSelective(@Param("record") Lesson record, @Param("example") LessonExample example);

    int updateByExample(@Param("record") Lesson record, @Param("example") LessonExample example);

    int updateByPrimaryKeySelective(Lesson record);

    int updateByPrimaryKey(Lesson record);
}