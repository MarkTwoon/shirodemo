package com.chinasoft.controller;

import com.chinasoft.entity.UserInfo;
import com.chinasoft.util.FinalMsg;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 首页控制器
 * @author pan_junbiao
 **/
@Controller
public class IndexController {
    /**
     * 首页
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpSession session)
    {
        //获取当前登录人
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        session.setAttribute(FinalMsg.SESSION_USERDATA,userInfo);
        request.setAttribute("userInfo",userInfo);
        return "index";
    }
}
