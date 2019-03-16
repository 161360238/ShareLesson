package com.pdsu.mapper;

import com.pdsu.pojo.classify;
import com.pdsu.pojo.classifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface classifyMapper {
    int countByExample(classifyExample example);

    int deleteByExample(classifyExample example);

    int deleteByPrimaryKey(String classifyId);

    int insert(classify record);

    int insertSelective(classify record);

    List<classify> selectByExample(classifyExample example);

    classify selectByPrimaryKey(String classifyId);

    int updateByExampleSelective(@Param("record") classify record, @Param("example") classifyExample example);

    int updateByExample(@Param("record") classify record, @Param("example") classifyExample example);

    int updateByPrimaryKeySelective(classify record);

    int updateByPrimaryKey(classify record);
}