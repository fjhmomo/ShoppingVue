package com.example.demo.service.Imply;

import com.example.demo.pojo.item;

import java.util.List;

public interface CartServiceply {

    List<item> itemsShow(int userId);

    int itemsDelete(int userId, int itemIds);

    int updateNumber(int userId, int itemId, int number);

    Integer deleteItems(int userId, List<Integer> itemIds);

    int setNumber(int userId, int itemId, int number);
}
