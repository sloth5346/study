package com.example.demo.login.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String password;
	private String userName;
	private Date birthday;
	private BigDecimal age;
	private String marriage;
	private String role;
}
