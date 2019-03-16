package com.pdsu.mapper;

import com.pdsu.pojo.pay_record;
import com.pdsu.pojo.pay_recordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface pay_recordMapper {
    int countByExample(pay_recordExample example);

    int deleteByExample(pay_recordExample example);

    int deleteByPrimaryKey(String outTradeNo);

    int insert(pay_record record);

    int insertSelective(pay_record record);

    List<pay_record> selectByExample(pay_recordExample example);

    pay_record selectByPrimaryKey(String outTradeNo);

    int updateByExampleSelective(@Param("record") pay_record record, @Param("example") pay_recordExample example);

    int updateByExample(@Param("record") pay_record record, @Param("example") pay_recordExample example);

    int updateByPrimaryKeySelective(pay_record record);

    int updateByPrimaryKey(pay_record record);
}