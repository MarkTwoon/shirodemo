package com.chinasoft.controller;

import com.chinasoft.exception.MyException;
import com.chinasoft.exception.StatusCode;
import com.chinasoft.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("test")
  public Object test(@RequestParam Map<String,Object> map){
      //  int ab=10/0;
       // throw new MyException(StatusCode.DATA_NULL,"查询数据为空空？？");
        return adminService.selectUserById(map);
    }

    /*@RequestMapping("login")
    public Object login(@RequestBody Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
        *//*当前登录控制器 分2步进行
         * 第一步  和工具类中  验证码判断状态 功能一致*//*

        *//*第二步 继续判断账户与密码 在数据库中是否已存在，是否为已注册账户  select * where usename and password *//*

        return adminService.selectUserByNameAndPassWord(map, request.getSession());
    }*/
}
