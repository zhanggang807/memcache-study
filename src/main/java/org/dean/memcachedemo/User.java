package org.dean.memcachedemo;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name = "sam";
	private String passwd = "sam123";
	private int age = 23;
	
	@Override
	public String toString() {
		return "User [name=" + name + ", passwd=" + passwd + ", age=" + age
				+ "]";
	}
	
	/** 获得 name */
	public String getName() {
		return name;
	}
	/** 设置 name */
	public void setName(String name) {
		this.name = name;
	}
	/** 获得 passwd */
	public String getPasswd() {
		return passwd;
	}
	/** 设置 passwd */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/** 获得 age */
	public int getAge() {
		return age;
	}
	/** 设置 age */
	public void setAge(int age) {
		this.age = age;
	}
	
}
