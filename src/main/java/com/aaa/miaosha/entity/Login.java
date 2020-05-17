package com.aaa.miaosha.entity;

import java.util.Date;
/**
 * table name:  login
 * author name: Mr Bai
 * create time: 2019-11-16 14:49:28
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Login{
	private long id;
	private String nickname;
	private String password;
	private String salt;
	private String head;
	private java.util.Date registerDate;
	private java.util.Date lastLoginDate;
	private int loginCount;

}

