package com.aaa.miaosha.exception;

import com.aaa.miaosha.util.CodeMsg;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 * 异常处理类
 **/
public class GlobalException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm){
        super(cm.toString());
        this.cm =cm;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public CodeMsg getCm() {
        return cm;
    }

    public void setCm(CodeMsg cm) {
        this.cm = cm;
    }
}
