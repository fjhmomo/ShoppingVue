package com.example.demo.controller;


import com.example.demo.mapper.CartMapper;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.item;
import com.example.demo.service.ShoppingService;
import com.example.demo.service.UserCountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@Controller
@ResponseBody
@RestController
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private UserCountService userCountService;
    @PostMapping ("/init")
    public Result init(int category){
        ArrayList<item>items=shoppingService.init(category);
        return Result.success(items);
    }

    @PostMapping("/search")
    public Result search(String searchName){
        ArrayList<item>items=shoppingService.search(searchName);
        return Result.success(items);
    }

    @PostMapping("/buyitem")
    public Result buyItem(int userId, int itemId,int number,String address,int service){
        boolean flag=shoppingService.buyItem(userId, itemId,number,address,service);
        if (flag) {
            return Result.success(flag);
        } else {
            return Result.error("exist");
        }
    }
}
