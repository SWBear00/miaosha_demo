/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: User
 * Author:   ${白帅}
 * Date:     2019/9/21 10:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aaa.miaosha.entity;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ${白帅}
 * @create 2019/9/21
 * @since 1.0.0
 */
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
