/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoginController
 * Author:   ${白帅}
 * Date:     2019/9/21 17:24
 * Description: 登陆跳转控制
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aaa.miaosha.controller;

import com.aaa.miaosha.entity.LoginEntity;
import com.aaa.miaosha.service.MiaoShaService;
import com.aaa.miaosha.util.CodeMsg;
import com.aaa.miaosha.util.Result;
import com.aaa.miaosha.util.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


/**
 * 〈一句话功能简述〉<br> 
 * 〈登陆跳转控制〉
 *
 * @author ${白帅}
 * @create 2019/9/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    MiaoShaService miaoShaService;

    @RequestMapping("/to_login")
    public  String login(){
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> toLogin(HttpServletResponse response,@Valid LoginEntity login){
        log.info(login.toString());
        //登陆
         miaoShaService.login(response,login);
        return Result.success(true);
    }
}
