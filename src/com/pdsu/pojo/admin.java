package com.pdsu.pojo;

/**
 * 管理员信息表
 * 
 * @author wcyong
 * 
 * @date 2019-03-16
 */
public class Admin {
    /**
     * 管理员id
     */
    private String aId;

    /**
     * 管理员姓名
     */
    private String aName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salty;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 角色
     */
    private String role;

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId == null ? null : aId.trim();
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalty() {
        return salty;
    }

    public void setSalty(String salty) {
        this.salty = salty == null ? null : salty.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}