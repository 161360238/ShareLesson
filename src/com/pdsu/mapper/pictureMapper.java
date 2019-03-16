package com.pdsu.mapper;

import com.pdsu.pojo.picture;
import com.pdsu.pojo.pictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface pictureMapper {
    int countByExample(pictureExample example);

    int deleteByExample(pictureExample example);

    int deleteByPrimaryKey(String picId);

    int insert(picture record);

    int insertSelective(picture record);

    List<picture> selectByExample(pictureExample example);

    picture selectByPrimaryKey(String picId);

    int updateByExampleSelective(@Param("record") picture record, @Param("example") pictureExample example);

    int updateByExample(@Param("record") picture record, @Param("example") pictureExample example);

    int updateByPrimaryKeySelective(picture record);

    int updateByPrimaryKey(picture record);
}