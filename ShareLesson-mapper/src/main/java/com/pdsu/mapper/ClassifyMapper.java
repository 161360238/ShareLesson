package com.pdsu.mapper;

import com.pdsu.pojo.Classify;
import com.pdsu.pojo.ClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassifyMapper {
    int countByExample(ClassifyExample example);

    int deleteByExample(ClassifyExample example);

    int deleteByPrimaryKey(String classifyId);

    int insert(Classify record);

    int insertSelective(Classify record);

    List<Classify> selectByExample(ClassifyExample example);

    Classify selectByPrimaryKey(String classifyId);

    int updateByExampleSelective(@Param("record") Classify record, @Param("example") ClassifyExample example);

    int updateByExample(@Param("record") Classify record, @Param("example") ClassifyExample example);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);
}