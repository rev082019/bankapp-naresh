package com.revature.bankapp.model;

import java.time.LocalDateTime;

public class Account {

	private Integer id;
	
	private User user;
	
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private Integer balance;
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", type=" + type + ", balance=" + balance + ", createdDate="
				+ createdDate + "]";
	}

	private LocalDateTime createdDate;

	public Integer getId() {
		return id;
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
