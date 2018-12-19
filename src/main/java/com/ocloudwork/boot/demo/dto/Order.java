package com.ocloudwork.boot.demo.dto;

import java.util.Date;
import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = -766830546603566730L;

	private String no;

	private Date date;

	private int quantity;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
