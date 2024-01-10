package com.example.demo.mapper;

import com.example.demo.pojo.item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ItemMapper {
    @Select("select * from shopping.shopping where id=#{itemId} ")
    item getItem(int itemId);
}
