package com.cnpc.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName ResultBean
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/17 14:16
 * @Version 1.0
 **/

@Data
public class ResultBean implements Serializable {
    public static final long seriaVersionUID = 1L;

    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";
    public static final String NO_PERMISSION = "NO_PERMISSION";



    private String msg;

    private int code;

    private Object data;

    public ResultBean setResult(int code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
        return this;
    }

    public ResultBean success(){
        return setResult( 200,SUCCESS,null );
    }

    public ResultBean success(Object data){
        return setResult( 200,SUCCESS,data );
    }

    public ResultBean fail(Object data,String msg){
        return setResult( 400,msg,data );
    }

    public ResultBean fail(Object data,String msg, int code){
        return setResult( code,msg,data );
    }

    public ResultBean fail(String msg,int code){
        return setResult( code,msg,null );
    }

    public ResultBean fail(String msg){
        return setResult( 400,msg,null );
    }
}
