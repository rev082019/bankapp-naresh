package com.revature.bankapp.model;

import java.time.LocalDateTime;

public class Account {

	private Integer id;
	
	//private int userId;
	private User user; // HAS-A
	
	private String type;	

	private Integer balance;	

	private LocalDateTime createdDate;
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", type=" + type + ", balance=" + balance + ", createdDate="
				+ createdDate + "]";
	}


	public Integer getId() {
		return id;
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
}
