package com.lnavm.entity;
/**
 * 封装返回信息，规范化
 * @param <T>
 */
public class Resultentity<T> {

    public static final int SUCCESS=1;
    public static final int ERROR=-1;

    private int result;
    private String message;
    private T data;


    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
