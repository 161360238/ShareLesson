package com.pdsu.mapper;

import com.pdsu.pojo.Center;
import com.pdsu.pojo.CenterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CenterMapper {
    int countByExample(CenterExample example);

    int deleteByExample(CenterExample example);

    int deleteByPrimaryKey(String centerId);

    int insert(Center record);

    int insertSelective(Center record);

    List<Center> selectByExample(CenterExample example);

    Center selectByPrimaryKey(String centerId);

    int updateByExampleSelective(@Param("record") Center record, @Param("example") CenterExample example);

    int updateByExample(@Param("record") Center record, @Param("example") CenterExample example);

    int updateByPrimaryKeySelective(Center record);

    int updateByPrimaryKey(Center record);
}