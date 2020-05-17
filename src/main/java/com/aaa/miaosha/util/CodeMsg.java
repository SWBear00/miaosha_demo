/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CodeMsg
 * Author:   ${白帅}
 * Date:     2019/9/18 8:32
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
public class CodeMsg {
    private int code;
    private String msg;
    //通用模块
    public static CodeMsg SUCCESS = new CodeMsg(0,"success");
    public static CodeMsg SERVER_ERROR =new CodeMsg(500100,"服务端异常");
    public static CodeMsg BIND_ERROR =new CodeMsg(500101,"参数校验异常：%s");
    //登陆模块5002xx
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登陆密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST= new CodeMsg(500214, "手机号码不存在");
    public static CodeMsg PASSWORD_ERROR= new CodeMsg(500215, "密码错误");
    public static CodeMsg USER_NOT_EXIST= new CodeMsg(500215, "用户不存在");
    //商品模块5003xx
    //订单模块5004xx
    //秒杀模块5005xx
    public static CodeMsg MIAO_SHA_OVER= new CodeMsg(500500, "商品已经秒杀完毕");
    public static CodeMsg REPEATE_MIAOSHA= new CodeMsg(500500, "不能重复秒杀");

    public CodeMsg(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
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

    public CodeMsg fillArgs(Object...args){
        int code=this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }
}
