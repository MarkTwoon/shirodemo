package com.chinasoft.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinasoft.entity.UserInfo;
import com.chinasoft.exception.MyException;
import com.chinasoft.exception.StatusCode;
import com.chinasoft.service.AdminService;
import com.chinasoft.util.FinalMsg;
import com.chinasoft.util.RequestUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("test")
  public Object test(@RequestParam Map<String,Object> map, HttpSession session){
      //  int ab=10/0;
       // throw new MyException(StatusCode.DATA_NULL,"查询数据为空空？？");
        //return adminService.selectUserById(map);
     map.put("SessionId",session.getId());
     map.put("登录用户", JSONObject.toJSON(session.getAttribute(FinalMsg.SESSION_USERDATA)));
    return map;
    }

    @RequestMapping("getPage")
    public Object getPage(@RequestParam Map<String,Object> map){
        List<Map<String,Object>> list= RequestUtil.checkNullData(adminService.selectRolePage(map));
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<Map<String,Object>>(list);
        map.put("total",pageInfo.getTotal());
        map.put("list",list);
        return map;
    }

    /*@RequestMapping("login")
    public Object login(@RequestBody Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
        *//*当前登录控制器 分2步进行
         * 第一步  和工具类中  验证码判断状态 功能一致*//*

        *//*第二步 继续判断账户与密码 在数据库中是否已存在，是否为已注册账户  select * where usename and password *//*

        return adminService.selectUserByNameAndPassWord(map, request.getSession());
    }*/
}
