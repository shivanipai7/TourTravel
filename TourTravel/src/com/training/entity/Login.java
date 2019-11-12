package com.training.entity;

public class Login {

	private long userId;
	private String passWord;
	private String userType;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(long userId, String passWord, String userType) {
		super();
		this.userId = userId;
		this.passWord = passWord;
		this.userType = userType;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", passWord=" + passWord + ", userType=" + userType + "]";
	}
	
	
}
