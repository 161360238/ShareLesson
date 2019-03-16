package com.pdsu.mapper;

import com.pdsu.pojo.comment;
import com.pdsu.pojo.commentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface commentMapper {
    int countByExample(commentExample example);

    int deleteByExample(commentExample example);

    int deleteByPrimaryKey(String commentId);

    int insert(comment record);

    int insertSelective(comment record);

    List<comment> selectByExample(commentExample example);

    comment selectByPrimaryKey(String commentId);

    int updateByExampleSelective(@Param("record") comment record, @Param("example") commentExample example);

    int updateByExample(@Param("record") comment record, @Param("example") commentExample example);

    int updateByPrimaryKeySelective(comment record);

    int updateByPrimaryKey(comment record);
}