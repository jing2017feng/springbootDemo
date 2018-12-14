package com.ocloudwork.boot.demo.service;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "com.ocloudwork.boot.demo")
public class RandomService implements Serializable {
	private static final long serialVersionUID = -3674989147710261166L;
	private String value;
	private Integer number;
	private Long bignumber;
	private Integer randomInt1;
	private Integer randomInt2;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Long getBignumber() {
		return bignumber;
	}

	public void setBignumber(Long bignumber) {
		this.bignumber = bignumber;
	}

	public Integer getRandomInt1() {
		return randomInt1;
	}

	public void setRandomInt1(Integer randomInt1) {
		this.randomInt1 = randomInt1;
	}

	public Integer getRandomInt2() {
		return randomInt2;
	}

	public void setRandomInt2(Integer randomInt2) {
		this.randomInt2 = randomInt2;
	}

}
