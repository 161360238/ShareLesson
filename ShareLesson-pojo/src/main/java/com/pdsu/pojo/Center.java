package com.pdsu.pojo;

/**
 * 首页信息表
 * 
 * @author wcyong
 * 
 * @date 2019-03-16
 */
public class Center {
    /**
     * 模块id
     */
    private String centerId;

    /**
     * 模块名称
     */
    private String modelName;

    /**
     * 点击模块跳转的url
     */
    private String modelUrl;

    /**
     * 类型
     */
    private Integer modelType;

    /**
     * 排序信息
     */
    private Integer modelSort;

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId == null ? null : centerId.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getModelUrl() {
        return modelUrl;
    }

    public void setModelUrl(String modelUrl) {
        this.modelUrl = modelUrl == null ? null : modelUrl.trim();
    }

    public Integer getModelType() {
        return modelType;
    }

    public void setModelType(Integer modelType) {
        this.modelType = modelType;
    }

    public Integer getModelSort() {
        return modelSort;
    }

    public void setModelSort(Integer modelSort) {
        this.modelSort = modelSort;
    }
}