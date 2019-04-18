package com.pdsu.mapper;

import com.pdsu.pojo.Praise_user;
import com.pdsu.pojo.Praise_userExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Praise_userMapper {
    int countByExample(Praise_userExample example);

    int deleteByExample(Praise_userExample example);

    int deleteByPrimaryKey(String rid);

    int insert(Praise_user record);

    int insertSelective(Praise_user record);

    List<Praise_user> selectByExample(Praise_userExample example);

    Praise_user selectByPrimaryKey(String rid);

    int updateByExampleSelective(@Param("record") Praise_user record, @Param("example") Praise_userExample example);

    int updateByExample(@Param("record") Praise_user record, @Param("example") Praise_userExample example);

    int updateByPrimaryKeySelective(Praise_user record);

    int updateByPrimaryKey(Praise_user record);
}