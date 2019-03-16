package com.pdsu.mapper;

import com.pdsu.pojo.message;
import com.pdsu.pojo.messageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface messageMapper {
    int countByExample(messageExample example);

    int deleteByExample(messageExample example);

    int deleteByPrimaryKey(String mId);

    int insert(message record);

    int insertSelective(message record);

    List<message> selectByExample(messageExample example);

    message selectByPrimaryKey(String mId);

    int updateByExampleSelective(@Param("record") message record, @Param("example") messageExample example);

    int updateByExample(@Param("record") message record, @Param("example") messageExample example);

    int updateByPrimaryKeySelective(message record);

    int updateByPrimaryKey(message record);
}