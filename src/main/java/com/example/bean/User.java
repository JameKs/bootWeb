package com.example.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 如何持久化呢？
 * 
 * 1、使用@Entity进行实体类的持久化操作.
 * 当JPA检测到我们的实体类中有@Entity注解的时候，会在数据库中生成对应的表结构信息.
 * 
 * 如何指定主键以及主键的生成策略
 * 
 * 2、使用@Id指定主键、使用@GeneratedValue指定主键的生成策略
 * @author PVer
 *
 */
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String userName;
	
	private int userAge;
	
	private Date date;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
