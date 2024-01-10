package com.example.demo.mapper;
import com.example.demo.pojo.item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ShoppingMapper {
    //从不同类别的数据表中查找
    ArrayList<item> initRandom(List<Integer> ids);
    ArrayList<item> initAppliances(List<Integer> ids);
    ArrayList<item> initClothing(List<Integer> ids);
    ArrayList<item> initComputer(List<Integer> ids);
    ArrayList<item> initFoods(List<Integer> ids);
    ArrayList<item> initPhone(List<Integer> ids);
    //查找
    @Select("SELECT * FROM shopping.shopping WHERE name LIKE CONCAT('%', #{name}, '%')")
    ArrayList<item> search(String name);
    @Select("SELECT * FROM shopping.categories WHERE name LIKE CONCAT('%', #{name}, '%')")
    Integer searchCategories(String name);
    @Select("SELECT * FROM shopping.shopping WHERE category =#{category}")
    ArrayList<item> categoriesSearch(int category);
}
