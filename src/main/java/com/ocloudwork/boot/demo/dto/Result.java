package com.ocloudwork.boot.demo.dto;

import java.io.Serializable;

public class Result<T> implements Serializable {
	
	private static final long serialVersionUID = 5626461829931431306L;
	
	protected boolean success = true;
	protected String message = "";
	protected T data;
	
	public Result(){}
	
	public Result(boolean success){
		this.success = success;
	}
	
	public Result(boolean success,String message){
		this.success = success;
		this.message = message;
	}
	
	public Result(boolean success,String message,T data){
		this.success = success;
		this.message = message;
		this.data = data;
	}
	
	public Result(boolean success,T data){
		this.success = success;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	

}
