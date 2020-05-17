/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Result
 * Author:   ${白帅}
 * Date:     2019/9/18 0:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aaa.miaosha.util;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ${白帅}
 * @create 2019/9/18
 * @since 1.0.0
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(T data2) {
        this.code=0;
        this.msg="成功";
        this.data=data2;
    }
    public Result(CodeMsg cm) {
        if(cm==null){
            return;
        }
        this.code=cm.getCode();
        this.msg=cm.getMsg();
    }
    /**
     * 成功时调用
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }
    /**
     * 失败时调用
     * @return
     */
    public static <T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    
}
