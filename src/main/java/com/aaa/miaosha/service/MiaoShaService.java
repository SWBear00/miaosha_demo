package com.aaa.miaosha.service;

import com.aaa.miaosha.entity.LoginEntity;
import com.aaa.miaosha.util.CodeMsg;

import javax.servlet.http.HttpServletResponse;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
public interface MiaoShaService {
    boolean login(HttpServletResponse response,LoginEntity login);
}
