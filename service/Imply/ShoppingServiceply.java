package com.example.demo.service.Imply;

import com.example.demo.pojo.item;

import java.util.ArrayList;

public interface ShoppingServiceply {
    ArrayList<item> init(int category);

    ArrayList<item> search(String name);

    boolean buyItem(int userID,int itemId,int number,String address,int service);
}
