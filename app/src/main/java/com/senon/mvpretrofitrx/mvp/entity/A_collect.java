package com.senon.mvpretrofitrx.mvp.entity;

/**
 * Created by Administrator on 2019/2/22.
 */

public class A_collect {

    /**
     * errorCode : -1001
     * errorMsg : 请先登录！
     */

    private int errorCode;
    private String errorMsg;

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
