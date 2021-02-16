package com.chinasoft.service.impl;

import com.chinasoft.dao.AdminMapper;
import com.chinasoft.service.AdminService;
import com.chinasoft.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    public AdminMapper adminMapper;

    @Autowired
    public RedisUtil redisUtil;


    @Override
    public List<Map<String, Object>> selectUserById(Map<String, Object> map) {
        /*注意  数据通过限定参数区分*/
        String key="user_"+map.get("userId");
        boolean hasKey=redisUtil.hasKey(key);
        if(hasKey){
            List<Map<String,Object>> list= (List<Map<String, Object>>) redisUtil.get(key);
            System.out.println("从redis缓存中获取数据："+list);
            return  list;
        }else{
            List<Map<String,Object>> list=adminMapper.selectUserById(map);
            System.out.println("查询数据库获得数据"+list);
            System.out.println("------数据结果集存入缓存中------------------");
            //写入缓存  最好在缓存中添加生效时间 默认是秒单位
            redisUtil.set(key,list, RedisUtil.RandomNumber(14,30));
            return  list;
        }
    }


   /* @Override
    public Object
    selectUserByNameAndPassWord(Map<String, Object> map, HttpSession session) {
        *//*注意  数据通过限定参数区分*//*
    String key = "user_" + map.get("userName") + map.get("passWord");
    boolean hasKey = redisUtil.hasKey(key);
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (hasKey) {
        list = (List<Map<String, Object>>) redisUtil.get(key);
        System.out.println("从redis缓存中获取数据：" + list);
        //return  list;
    } else {
        System.out.println("查询数据库获得数据" + list);
        list = adminMapper.selectUserByNameAndPassWord(map);
        if (list.size() <= 0) {
            System.out.println("------查无此人 登录失败------------------");
            throw new MyException(StatusCode.ACCOUNT_OR_PASSWORD_ERROR, "账户名或密码错误！222了");
        }
    }
    //写入缓存  最好在缓存中添加生效时间 默认是秒单位
    *//*将登录ID存入session 将sessionId存入redis缓存中*//*
        session.setAttribute("loginUserId", list.get(0).get("ADMIN_ID"));
        redisUtil.set("loginUser:" + list.get(0).get("ADMIN_ID"), session.getId(), 60 * 60 * 24 * 7);
    *//*存储缓存 用户详细信息*//*
        redisUtil.set(key, list, 60 * 60 * 24 * 7);
        return new ReturnData(StatusCode.REQUEST_SUCCESS, list.get(0), "登录成功！");
}*/

}
