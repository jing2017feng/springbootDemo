package com.ocloudwork.boot.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User  extends Domain{

	private static final long serialVersionUID = 9174216117528433153L;
	
	@Column(columnDefinition = "varchar(128) not null comment '姓名'")
	private String name;

	@Column(columnDefinition = "integer(3) comment '年龄'")
	private Integer age;

	/**
	 * 不持久化的属性
	 */
	@Transient
	private String message;

	public User() {
	}

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
