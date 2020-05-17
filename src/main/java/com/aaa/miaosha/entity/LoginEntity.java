package com.aaa.miaosha.entity;



import com.aaa.miaosha.validator.IsMobile;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
public class LoginEntity {
    @NotNull
    @IsMobile
    private String mobile;

    @NotNull
    @Length(min=32)
    private String password;

    @Override
    public String toString() {
        return "LoginEntity{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
