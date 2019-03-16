package com.pdsu.pojo;

/**
 * 用户信息表
 * 
 * @author wcyong
 * 
 * @date 2019-03-15
 */
public class User {
    /**
     * 用户id
     */
    private String uId;

    /**
     * 用户名，手机号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salty;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 院系
     */
    private String department;

    /**
     * 身份
     */
    private Integer identity;

    /**
     * 个人介绍
     */
    private String introduction;

    /**
     * 个人头像
     */
    private String pic;

    /**
     * 个人签名
     */
    private String signature;

    /**
     * 昵称
     */
    private String nicname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 角色
     */
    private String role;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public String getNicname() {
        return nicname;
    }

    public void setNicname(String nicname) {
        this.nicname = nicname == null ? null : nicname.trim();
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