package com.hz.demo.resp;

import lombok.Data;

@Data
public class Result<T> {

    private int code;
    private String msg;
    // 一个对象
    private T data;


    /**
     * 返回失败
     * @param code
     * @param msg
     * @return
     */
    public static Result getFail(int code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
