package com.example.demo.controller;
import com.example.demo.mapper.CartMapper;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.item;
import com.example.demo.service.CartService;
import com.example.demo.dto.RequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@ResponseBody
@RestController
public class CartController {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartService cartService;
    //获得用户的购物车列表
    @PostMapping("/itemsShow")
    public Result itemsShow(int userId){
        List<item>temp=cartService.itemsShow(userId);
        return Result.success(temp);
    }
    @PostMapping("/deleteItem")
    public Result itemDelete(int userId,int itemId){
        int result= cartService.itemsDelete(userId,itemId);
        return Result.success(result);
    }
    @PostMapping("/updateNumber")
    public Result updateNumber(int userId,int itemId,int number){
        int result= cartService.updateNumber(userId,itemId,number);
        return Result.success(result);
    }
    @PostMapping("/deleteItems")
    public Result deleteItems(@RequestBody RequestDto requestDto) {
        Integer result = cartService.deleteItems(requestDto.getUserId(), requestDto.getItemIds());
        return Result.success(result);
    }
    @PostMapping("/setNumber")
    public Result setNumber(int userId,int itemId,int number){
        int result= cartService.setNumber(userId,itemId,number);
        return Result.success(result);
    }


}
