package com.pdsu.pojo;

/**
 * 图片表
 * 
 * @author wcyong
 * 
 * @date 2019-03-24
 */
public class Picture {
    /**
     * 图片id
     */
    private String picId;

    /**
     * 路径
     */
    private String path;

    /**
     * 图片名称
     */
    private String picName;

    /**
     * 状态
     */
    private Integer status;

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId == null ? null : picId.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}