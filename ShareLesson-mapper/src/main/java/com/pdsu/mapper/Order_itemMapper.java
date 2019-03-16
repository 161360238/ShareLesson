package com.pdsu.mapper;

import com.pdsu.pojo.Order_item;
import com.pdsu.pojo.Order_itemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Order_itemMapper {
    int countByExample(Order_itemExample example);

    int deleteByExample(Order_itemExample example);

    int deleteByPrimaryKey(String rId);

    int insert(Order_item record);

    int insertSelective(Order_item record);

    List<Order_item> selectByExample(Order_itemExample example);

    Order_item selectByPrimaryKey(String rId);

    int updateByExampleSelective(@Param("record") Order_item record, @Param("example") Order_itemExample example);

    int updateByExample(@Param("record") Order_item record, @Param("example") Order_itemExample example);

    int updateByPrimaryKeySelective(Order_item record);

    int updateByPrimaryKey(Order_item record);
}