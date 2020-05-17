/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SampleController
 * Author:   ${白帅}
 * Date:     2019/9/17 22:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aaa.miaosha.controller;

import com.aaa.miaosha.entity.User;
import com.aaa.miaosha.redis.RedisService;
import com.aaa.miaosha.redis.UserKey;
import com.aaa.miaosha.service.SampleService;
import com.aaa.miaosha.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ${白帅}
 * @create 2019/9/17
 * @since 1.0.0
 */
@RequestMapping("/sample")
@Controller
public class SampleController {

    @Autowired
    private SampleService service;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/get")
    @ResponseBody
    public Result getRedis(){
      User key1 = redisService.get(UserKey.getById,""+123, User.class);
        System.out.println("key1"+key1.getName());
        return Result.success(key1.getName());
    }
    @RequestMapping("/set")
    @ResponseBody
    public Result setRedis(){
       User user=new User(123,"李四");
        boolean set = redisService.set(UserKey.getById, "" + 123, user);
        return Result.success(set);
    }


}
