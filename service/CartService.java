package com.example.demo.service;

import com.example.demo.mapper.CartMapper;
import com.example.demo.mapper.UtilMapper;
import com.example.demo.pojo.item;
import com.example.demo.service.Imply.CartServiceply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService implements CartServiceply {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private UtilMapper utilMapper;
    @Override
    public List<item> itemsShow(int userId) {
        List<Integer>itemIds=cartMapper.selectItemsId(userId);
        if(!itemIds.isEmpty()){
            List<item>items=utilMapper.selectItem(itemIds);
            //向购物车获取商品数量
            for (com.example.demo.pojo.item item : items) {
                int number = utilMapper.getItemNumber(userId, item.getId());
                item.setNumber(number);
            }
            return items;
        }
        return null;
    }

    @Override
    public int itemsDelete(int userId, int itemId) {
        return  cartMapper.itemDelete(userId,itemId);
    }

    @Override
    public int updateNumber(int userId, int itemId, int number) {
        return cartMapper.updateNumber(userId,itemId,number);
    }

    @Override
    public Integer deleteItems(int userId, List<Integer> itemIds) {
        return cartMapper.deleteItems(userId,itemIds);
    }

    @Override
    public int setNumber(int userId, int itemId, int number) {
        return utilMapper.setItemNumber(userId,itemId,number);
    }
}
