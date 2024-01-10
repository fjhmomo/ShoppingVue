package com.example.demo.mapper;

import com.example.demo.pojo.item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UtilMapper {
    //根据用户名查询id
    @Select("select id from shopping.login where username=#{username}")
    public Integer selectUserId(String username);
    //根据商品id查找对应商品
    public List<item> selectItem(List<Integer> ids);
    //查询用户ID是否存在
    @Select("select id from shopping.login where id=#{userId}")
    Integer userIdExist(int userId);
    //商品ID是否存在
    @Select("select id from shopping.shopping where id=#{itemId}")
    Integer itemIdExist(int itemId);
    //购物车是否已经存在某商品
    @Select("select user from shopping.shoppingcart where user=#{userId} and item=#{itemId}")
    Integer itemExistInCart(int userId ,int itemId );
    @Select("select password from shopping.login where password=#{oldPassword} and id=#{userId}")
    Integer PasswordExist(String oldPassword,int userId);
    //获取购物车商品数量
    @Select("select number from shopping.shoppingcart where user=#{userId} and item=#{itemId}")
    Integer getItemNumber(int userId,int itemId);
    //更改购物车商品数量
    @Update("update shopping.shoppingcart set number=#{number} where user=#{userId} and item=#{itemId}")
    Integer setItemNumber(int userId,int itemId,int number);
}
