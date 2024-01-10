package com.example.demo.mapper;


import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {

    //向购物车添加商品
    @Insert("insert into shopping.shoppingcart(user, item,number,address,service) " +
            "VALUE (#{userId}, #{itemId},#{number}, #{address},#{service})" )
    int addCart(int userId,int itemId,int number,String address,int service);
    //获得用户id所对应的所有商品id
    @Select("select item from shopping.shoppingcart where user=#{userId}")
    List<Integer>selectItemsId(int userId);
    @Delete("delete from shopping.shoppingcart where user=#{userId} and item=#{itemId}")
    int itemDelete(int userId, int itemId);
    @Update("update  shopping.shoppingcart set number=#{number} where user=#{userId} and item=#{itemId}")
    int updateNumber(int userId, int itemId,int number);
    //从购物车中删除商品

    Integer deleteItems(int userId,List<Integer>itemIds);
}
