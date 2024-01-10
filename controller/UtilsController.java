package com.example.demo.controller;

import com.example.demo.mapper.UserCountMapper;
import com.example.demo.mapper.UtilMapper;
import com.example.demo.service.UserCountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@ResponseBody
@RestController
public class UtilsController {
    @Autowired
    private UserCountMapper userCountMapper;
    @Autowired
    private UtilMapper utilMapper;
    @Autowired
    private UserCountService userCountService;
}
