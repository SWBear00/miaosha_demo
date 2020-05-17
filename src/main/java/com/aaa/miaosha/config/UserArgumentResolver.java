package com.aaa.miaosha.config;

import com.aaa.miaosha.entity.MiaoShaUser;
import com.aaa.miaosha.service.MiaoShaService;
import com.aaa.miaosha.service.impl.MiaoShaServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    /**
     * 判断方法中是否有MiaoShaUser的类
     * @param methodParameter
     * @return
     */
    @Autowired
    MiaoShaServiceImpl miaoShaService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> type = methodParameter.getParameterType();
        return type== MiaoShaUser.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);
         String paramToken = getCookieValue(request,MiaoShaServiceImpl.COOKI_NAME_TOKEN);
         String cookieToken = request.getParameter(MiaoShaServiceImpl.COOKI_NAME_TOKEN);
         if (StringUtils.isEmpty(paramToken)&&StringUtils.isEmpty(cookieToken)){
             return null;
         }
        String token =StringUtils.isEmpty(paramToken)?cookieToken:paramToken;

         return miaoShaService.getByToken(response, token);
    }

    private String getCookieValue(HttpServletRequest request, String cookiNameToken) {
       Cookie[] cookies = request.getCookies();
       if (cookies == null || cookies.length<=0){
           return  null;
       }
       for (Cookie cookie : cookies){
           if (cookie.getName().equals(cookiNameToken)){
                return cookie.getValue();
           }
       }
       return null;
    }

    }


