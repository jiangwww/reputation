package com.cdxyj.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiangwei
 * @Description
 * @Date 2019/9/18
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {
/*    @RequestMapping("/frame")
    public String frame(){
        return "/admin/frame";
    }*/
    @RequestMapping("")
    public String login1(){
        return "/admin/login1";
    }
    @RequestMapping("/login")
    public String login(String name,String password){
        try {
            if(name.equals("admin")&&password.equals("123456")){
                return "/admin/frame";
            }else {
                return "/admin/login1";
            }
        }catch (Exception e){
            return "/admin/login1";
        }


    }
}
