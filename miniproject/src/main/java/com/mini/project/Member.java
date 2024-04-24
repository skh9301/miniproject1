package com.mini.project;

public class Member {
	public String userId;
	public String pass;
	public String nickName;
	public String mPhone;
	public String eMail;
	
	public Member() {}
	
	
	public Member(String userId, String pass, String nickName, String mPhone, String eMail) {
		super();
		this.userId = userId;
		this.pass = pass;
		this.nickName = nickName;
		this.mPhone = mPhone;
		this.eMail = eMail;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	
}
