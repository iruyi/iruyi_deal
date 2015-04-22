package com.faxintong.iruyi.utils;

/**
 * Created by yunaxie on 2015/4/22.
 * 提供result 实体，方便controller 封装标准返回结果
 */
public class Result {
    private Integer errcode;
    private String errmessage;

    public Result(Integer errcode, String errmessage) {
        this.errcode = errcode;
        this.errmessage = errmessage;
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
}
