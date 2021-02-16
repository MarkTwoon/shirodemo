package com.chinasoft.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 权限信息实体类
 * @author pan_junbiao
 **/
@Entity
@Table(name="permission_info")
public class PermissionInfo implements Serializable {
    //权限ID（主键、自增）
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private int permissionId;

    //权限编号
    @Column(name = "permission_code")
    private String permissionCode;

    //权限名称
    @Column(name = "permission_name")
    private String permissionName;

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
