package com.chinasoft.service;


import java.util.List;
import java.util.Map;

public interface AdminService {
    public List<Map<String,Object>> selectUserById(Map<String,Object> map);
    public List<Map<String,Object>> selectRolePage(Map<String,Object> map);
}
