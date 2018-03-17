package com.example.junittestforproperty;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

	@Value("${app.count}")
	private Integer count;
	
	@Value("${app.countStr}")
	private String countStr;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCountStr() {
		return countStr;
	}

	public void setCountStr(String countStr) {
		this.countStr = countStr;
	}
	
	@PostConstruct
	public int demoMethod() {
		return count + Integer.parseInt(countStr);
	}
}
