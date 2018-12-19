package com.ocloudwork.boot.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ocloudwork.boot.demo.domain.Domain;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UserDto extends Domain {
	private static final long serialVersionUID = -5813517055228068355L;
	private String userName;
	private Integer age;
	private String message="abcd";
	
	private String status="9";

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
