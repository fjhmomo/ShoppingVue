package com.example.demo.controller;

import com.example.demo.pojo.Result;
import com.example.demo.pojo.item;
import com.example.demo.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@ResponseBody
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping("/getItem")
    public Result getItemInformation(int itemId){
        item temp = itemService.getItem(itemId);
        return Result.success(temp);
    }
}
