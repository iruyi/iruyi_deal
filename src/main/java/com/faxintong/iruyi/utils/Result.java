package com.faxintong.iruyi.utils;

/**
 * Created by yunaxie on 2015/4/22.
 * 提供result 实体，方便controller 封装标准返回结果
 */
public class Result {
    private Integer errcode;
    private String errmessage;
    private String data;

    public Result(Integer errcode, String errmessage, String data) {
        this.errcode = errcode;
        this.errmessage = errmessage;
        this.data = data;
    }

    public Result(Integer errcode, String errmessage) {
        this(errcode, errmessage, "");
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmessage() {
        return errmessage;
    }

    public void setErrmessage(String errmessage) {
        this.errmessage = errmessage;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
