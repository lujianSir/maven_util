package com.dh.entity;

import java.io.Serializable;

public class User extends Page implements Serializable {
	
	private String id;
 	
	private String username;//登陆名
	
	private String userpwd;//登陆密码
	
	private  double  money;//钱

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	
	
	
}
