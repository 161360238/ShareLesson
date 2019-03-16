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
     * id
     */
    private String centerId;

    /**
     * 导航栏信息1
     */
    private String msg1;

    /**
     * 导航栏信息2
     */
    private String msg2;

    /**
     * 导航栏信息3
     */
    private String msg3;

    /**
     * 导航栏信息4
     */
    private String msg4;

    /**
     * 导航栏信息5
     */
    private String msg5;

    /**
     * 首页大广告
     */
    private String bigPic;

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId == null ? null : centerId.trim();
    }

    public String getMsg1() {
        return msg1;
    }

    public void setMsg1(String msg1) {
        this.msg1 = msg1 == null ? null : msg1.trim();
    }

    public String getMsg2() {
        return msg2;
    }

    public void setMsg2(String msg2) {
        this.msg2 = msg2 == null ? null : msg2.trim();
    }

    public String getMsg3() {
        return msg3;
    }

    public void setMsg3(String msg3) {
        this.msg3 = msg3 == null ? null : msg3.trim();
    }

    public String getMsg4() {
        return msg4;
    }

    public void setMsg4(String msg4) {
        this.msg4 = msg4 == null ? null : msg4.trim();
    }

    public String getMsg5() {
        return msg5;
    }

    public void setMsg5(String msg5) {
        this.msg5 = msg5 == null ? null : msg5.trim();
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic == null ? null : bigPic.trim();
    }
}