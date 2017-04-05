package com.android.benben.retrofitlibrary.model;

/**
 * Time      2017/4/5 10:07 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class BaseModel<T> {
    private String reason;//查询是否成功
    private T result;//所返回的内容
    private int error_code;//对应的参数
    private boolean success;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return error_code==0;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
