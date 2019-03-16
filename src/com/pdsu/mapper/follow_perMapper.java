package com.pdsu.mapper;

import com.pdsu.pojo.follow_per;
import com.pdsu.pojo.follow_perExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface follow_perMapper {
    int countByExample(follow_perExample example);

    int deleteByExample(follow_perExample example);

    int deleteByPrimaryKey(String followId);

    int insert(follow_per record);

    int insertSelective(follow_per record);

    List<follow_per> selectByExample(follow_perExample example);

    follow_per selectByPrimaryKey(String followId);

    int updateByExampleSelective(@Param("record") follow_per record, @Param("example") follow_perExample example);

    int updateByExample(@Param("record") follow_per record, @Param("example") follow_perExample example);

    int updateByPrimaryKeySelective(follow_per record);

    int updateByPrimaryKey(follow_per record);
}