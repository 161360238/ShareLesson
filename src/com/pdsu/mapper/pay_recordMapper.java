package com.pdsu.mapper;

import com.pdsu.pojo.Pay_record;
import com.pdsu.pojo.Pay_recordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Pay_recordMapper {
    int countByExample(Pay_recordExample example);

    int deleteByExample(Pay_recordExample example);

    int deleteByPrimaryKey(String outTradeNo);

    int insert(Pay_record record);

    int insertSelective(Pay_record record);

    List<Pay_record> selectByExample(Pay_recordExample example);

    Pay_record selectByPrimaryKey(String outTradeNo);

    int updateByExampleSelective(@Param("record") Pay_record record, @Param("example") Pay_recordExample example);

    int updateByExample(@Param("record") Pay_record record, @Param("example") Pay_recordExample example);

    int updateByPrimaryKeySelective(Pay_record record);

    int updateByPrimaryKey(Pay_record record);
}