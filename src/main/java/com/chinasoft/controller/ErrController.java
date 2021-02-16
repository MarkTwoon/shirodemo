package com.chinasoft.controller;

import com.chinasoft.exception.MyException;
import com.chinasoft.exception.StatusCode;
import org.apache.shiro.authc.*;
import org.springframework.boot.web.servlet.error.ErrorController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ErrController implements ErrorController {
   /* @RequestMapping("/")
    public String showIndex(HttpServletRequest request) {
        *//*request.setAttribute("name","张顺飞");
        request.getSession().setAttribute("name","李顺爬");*//*
        return "login";
    }*/




     @RequestMapping("/error")
    public String showError(HttpServletRequest request,HttpServletResponse response) {
System.out.println(response.getStatus()+">>>>>>>>>>");
        return getErrorPath();
    }

    @Override
    public String getErrorPath() {

        throw new MyException(StatusCode.RETURN_ERROR,"抱歉，请求异常！");
    }
}
