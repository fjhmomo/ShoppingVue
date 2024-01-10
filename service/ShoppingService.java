package com.example.demo.service;

import com.example.demo.mapper.CartMapper;
import com.example.demo.mapper.ShoppingMapper;
import com.example.demo.mapper.UtilMapper;
import com.example.demo.pojo.item;
import com.example.demo.service.Imply.ShoppingServiceply;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Slf4j
@Service
public class ShoppingService implements ShoppingServiceply {

    @Autowired
    private ShoppingMapper shoppingMapper;
    @Autowired
    private UtilMapper utilmapper;
    @Autowired
    private CartMapper cartMapper;
    public ArrayList<item>init(int category) {
        int n=25;
        if(category==0){
            n=150;
        }
        else if(category==4||category==5){
            n=40;
        }
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }
        for (int i = 0; i < array.length; i++) {
            int j = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        List<Integer> ids =new ArrayList<>();
        for (int id : array) {
            ids.add(id);
        }
        ArrayList<item>items=new ArrayList<>();
        if(category==0){
            items=shoppingMapper.initRandom(ids);
        }
        else if(category==1){
            items=shoppingMapper.initPhone(ids);
        }
        else if(category==2){
            items=shoppingMapper.initFoods(ids);
        }
        else if(category==3){
            items=shoppingMapper.initAppliances(ids);
        }
        else if(category==4){
            items=shoppingMapper.initComputer(ids);
        }
        else if(category==5){
            items=shoppingMapper.initClothing(ids);
        }
        if(category!=0){
//            for(int i=0;i<items.size();i++) {
//                items.get(i).setCategory(category);
//            }
            for (com.example.demo.pojo.item item : items) {
                item.setCategory(category);
            }
        }

        return items;
    }

    @Override
    public ArrayList<item> search(String name) {
        ArrayList<item>items_first;
        Integer temp_result;
        boolean flag=false;
        int final_result=0;
        ArrayList<item> items_total;
        items_total=shoppingMapper.search(name);
        for (int i = 0; i < name.length()-1; i++) {
            String substring = name.substring(i, i + 2);
            temp_result=shoppingMapper.searchCategories(name);
            if(temp_result!=null&&!flag){
                flag=true;
                final_result=temp_result;
            }
            ArrayList<item>tempResult=shoppingMapper.search(substring);
            items_total.addAll(tempResult);
        }
        items_first=shoppingMapper.categoriesSearch(final_result);
        for(int i=0;i<10;i++){
            if(i<items_first.size()) {
                items_total.add(items_first.get(i));
            }
        }
        HashSet<item> set = new HashSet<>(items_total);
        items_total = new ArrayList<>(set);
        return items_total;
    }

    @Override
    public boolean buyItem(int userID,int itemId,int number,String address,int service ) {
        Integer userIdExist=utilmapper.userIdExist(userID);
        Integer itemIdExist=utilmapper.itemIdExist(itemId);
        Integer itemExistInCart=utilmapper.itemExistInCart(userID,itemId);
        if(userIdExist!=null && itemIdExist!=null&&itemExistInCart==null) {
            cartMapper.addCart(userID,itemId,number,address,service);
            return true;
        }
        return false;
    }

}
