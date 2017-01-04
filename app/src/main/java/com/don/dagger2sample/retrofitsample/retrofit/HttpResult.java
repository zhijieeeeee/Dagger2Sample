package com.don.dagger2sample.retrofitsample.retrofit;

import com.google.gson.annotations.SerializedName;

public class HttpResult<T> {

    @SerializedName("error_code")
    private int errorCode;

    private String reason;

    private T result;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
