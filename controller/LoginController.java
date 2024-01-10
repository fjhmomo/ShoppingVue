package com.example.demo.controller;

import com.example.demo.pojo.Result;
import com.example.demo.pojo.User;
import com.example.demo.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import com.example.demo.utils.JwtUtils;
//
//import java.util.HashMap;
//import java.util.Map;

@Slf4j
@Controller
@ResponseBody
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

//    @Controller
//    public class HomeController {
//        @GetMapping("/")
//        public String home() {
//            return "login"; // 返回视图名称，如index.html
//        }
//    }

    @PostMapping("/register")
    public Result register(@RequestParam String username, @RequestParam String password){
        boolean flag=loginService.registerUser(username,password);
        if(flag) {
            return Result.success();
        }
        else {
            return Result.error("已经存在");
        }
    }

    @PostMapping("/login")
    public Result loginUser(@RequestParam String username, @RequestParam String password){
        User user=loginService.loginUser(username,password);
        if(user!=null){
//            Map<String, Object> claims=new HashMap<>();
//            claims.put("id",user.getId());
//            claims.put("name",user.getUsername());
//            String jwt= JwtUtils.generateJwt(claims);
            return Result.success(user);
        }
        else {
            return Result.error("不存在账号");
        }
    }
}
