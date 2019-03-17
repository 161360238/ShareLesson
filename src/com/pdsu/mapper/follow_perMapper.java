package com.pdsu.mapper;

import com.pdsu.pojo.Follow_per;
import com.pdsu.pojo.Follow_perExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Follow_perMapper {
    int countByExample(Follow_perExample example);

    int deleteByExample(Follow_perExample example);

    int deleteByPrimaryKey(String followId);

    int insert(Follow_per record);

    int insertSelective(Follow_per record);

    List<Follow_per> selectByExample(Follow_perExample example);

    Follow_per selectByPrimaryKey(String followId);

    int updateByExampleSelective(@Param("record") Follow_per record, @Param("example") Follow_perExample example);

    int updateByExample(@Param("record") Follow_per record, @Param("example") Follow_perExample example);

    int updateByPrimaryKeySelective(Follow_per record);

    int updateByPrimaryKey(Follow_per record);
}