package com.pdsu.pojo;

/**
 * 分类信息表
 * 
 * @author wcyong
 * 
 * @date 2019-04-18
 */
public class Classify {
    /**
     * 分类id
     */
    private String classifyId;

    /**
     * 父id
     */
    private String pid;

    /**
     * 分类名称
     */
    private String classifyName;

    /**
     * 分类序号
     */
    private Integer classifySort;

    /**
     * 状态
     */
    private Integer classifyStatus;

    /**
     * 是否为父类目
     */
    private Integer isParent;

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId == null ? null : classifyId.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    public Integer getClassifySort() {
        return classifySort;
    }

    public void setClassifySort(Integer classifySort) {
        this.classifySort = classifySort;
    }

    public Integer getClassifyStatus() {
        return classifyStatus;
    }

    public void setClassifyStatus(Integer classifyStatus) {
        this.classifyStatus = classifyStatus;
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }
}