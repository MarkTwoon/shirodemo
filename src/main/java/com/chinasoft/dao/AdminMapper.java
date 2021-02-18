package com.chinasoft.dao;

import com.chinasoft.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface AdminMapper {
    public List<Map<String,Object>> selectUserById(Map<String,Object> map);
    public List<Map<String,Object>> selectRolePage(Map<String,Object> map);

}
