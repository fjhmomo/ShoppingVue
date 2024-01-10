//package com.example.demo.Controller;
//
//
//import com.example.demo.Mapper.UserCountMapper;
//import com.example.demo.Mapper.UtilMapper;
//import com.example.demo.Pojo.Result;
//import com.example.demo.Service.UserCountService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.annotations.Update;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Date;
//import java.util.UUID;
//
//@Slf4j
//@Controller
//@ResponseBody
//@RestController
//public class UserCountController {
//    @Autowired
//    private UserCountMapper userCountMapper;
//    @Autowired
//    private UtilMapper utilMapper;
//    @Autowired
//    private UserCountService userCountService;
//    //更新用户名
//    @PostMapping("/changeName")
//    public Result changeName(int userId, String newName){
//        Integer result=userCountService.changeName(userId,newName);
//        if(result!=null){
//            return Result.success(result);
//        }
//        else{
//            return Result.error("用户名存在");
//        }
//    }
//    //更新密码
//    @PostMapping("/changePassword")
//    public Result changePassword(int userId,String newPassword,String oldPassword){
//        Integer result = userCountService.changePassword(userId,newPassword,oldPassword);
//        if(result != null){
//            return Result.success(result);
//        }
//        else{return Result.error("error"); }
//    }
//    //更新头像
//    @PostMapping("/changePicture")
//    public Result changePic(int userId, String userName, MultipartFile image) throws IOException {
//        String originalFilename = image.getOriginalFilename();
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        Date now = new Date();
//        String newFileName = userName+""+userId+""+extname;
//        image.transferTo(new File("C:\\Users\\LEGION\\Desktop\\javaweb\\Springboot\\demo\\src\\main\\resources\\static\\userPic\\"+newFileName));
//        return Result.success(newFileName);
//    }
//}
