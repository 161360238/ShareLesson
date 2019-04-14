package com.pdsu.mypojo;

/**
 * @Auther: http://wangjie
 * @Date: 2019/3/16
 * @Description: com.pdsu.pojo
 * @version: 1.0
 */
public class Result {

    private static final String SUCCESS_CODE = "200";

    private static final String ERROR_CODE = "201";

    private static final String SUCCESS_MSG = "success";

    private static final String ERROR_MSG = "error";

    private Object data;

    private String code;

    private String token;

    private String message;

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public Result() {

    }
    public Result( boolean success,String message) {
        this.message = message;
        this.success = success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public static Result ok() {
        Result r = new Result();
        r.setCode(SUCCESS_CODE);
        r.setMessage(SUCCESS_MSG);
        return r;
    }

    public static Result ok(Object data) {
        Result r = ok();
        if (data != null) {
            r.setData(data);
        }
        return r;
    }

    public static Result ok(Object data, String message) {
        Result r = new Result();
        r.setCode(SUCCESS_CODE);
        r.setData(data != null ? data : null);
        r.setMessage(message != null ? message : SUCCESS_MSG);
        return r;
    }

    public static Result error() {
        Result r = new Result();
        r.setCode(ERROR_CODE);
        r.setMessage(ERROR_MSG);
        return r;
    }

    public static Result error(Object data) {
        Result r = error();
        if (data != null) {
            r.setData(data);
        }
        return r;
    }

    public static Result error(Object data, String message) {
        Result r = new Result();
        r.setCode(ERROR_CODE);
        r.setData(data != null ? data : null);
        r.setMessage(message != null ? message : ERROR_MSG);
        return r;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

