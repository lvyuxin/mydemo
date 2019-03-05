package com.senon.mvpretrofitrx.mvp.base;

import com.google.gson.annotations.SerializedName;

public class Response <T>{
    @SerializedName("reason")
    private String reason;
    @SerializedName("error_code")
    private int error_code;

    private T result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {

        return "{" +
                "reason:'" + reason + '\'' +
                ", error_code=" + error_code +
                ", result" + result +
                '}';
    }
}
