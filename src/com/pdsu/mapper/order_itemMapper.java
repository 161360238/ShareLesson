package com.pdsu.mapper;

import com.pdsu.pojo.order_item;
import com.pdsu.pojo.order_itemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface order_itemMapper {
    int countByExample(order_itemExample example);

    int deleteByExample(order_itemExample example);

    int deleteByPrimaryKey(String rId);

    int insert(order_item record);

    int insertSelective(order_item record);

    List<order_item> selectByExample(order_itemExample example);

    order_item selectByPrimaryKey(String rId);

    int updateByExampleSelective(@Param("record") order_item record, @Param("example") order_itemExample example);

    int updateByExample(@Param("record") order_item record, @Param("example") order_itemExample example);

    int updateByPrimaryKeySelective(order_item record);

    int updateByPrimaryKey(order_item record);
}