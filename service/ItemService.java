package com.example.demo.service;

import com.example.demo.mapper.ItemMapper;
import com.example.demo.pojo.item;
import com.example.demo.service.Imply.ItemServiceply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService implements ItemServiceply {
    @Autowired
    private ItemMapper itemMapper;
//    @Autowired
//    private UtilMapper utilMapper;
    @Override
    public item getItem(int itemId) {
        return itemMapper.getItem(itemId);
    }
}
