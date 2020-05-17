/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MD5Util
 * Author:   ${白帅}
 * Date:     2019/9/21 17:02
 * Description: md5加密
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aaa.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 〈一句话功能简述〉<br> 
 * 〈md5加密〉
 *
 * @author ${白帅}
 * @create 2019/9/21
 * @since 1.0.0
 */
public class MD5Util {
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }
    private static final String salt="1a2b3c4d5e6f7h";

    /**
     * 第一次加密
     * @param inputPass
     * @return
     */
    public  static String inputPassToFormPass(String inputPass){
        String str=""+salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    /**
     * 第二次加密
     * @param
     */
    public  static String formPassToDBPass(String formPass,String salt){
        String str=""+salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    /**
     * 两次一起加密
     * @param
     */
    public static String inputPassToDbPass(String inputPass, String saltDB) {
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }
    public static void main(String[] args) {
        System.out.println(inputPassToDbPass("123456","1a2b3c4d"));
    }
}
