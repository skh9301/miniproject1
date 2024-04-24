package com.mini.project;

import java.sql.Timestamp;

public class Comment1 {
	public int comNo;
	public String userId;
	public String comText;
	public int comGood;
	public int comBad;
	public Timestamp comDate;
	
	public Comment1() {}

	public Comment1(int comNo, String userId, String comText, int comGood, int comBad, Timestamp comDate) {
		super();
		this.comNo = comNo;
		this.userId = userId;
		this.comText = comText;
		this.comGood = comGood;
		this.comBad = comBad;
		this.comDate = comDate;
	}

	public int getComNo() {
		return comNo;
	}

	public void setComNo(int comNo) {
		this.comNo = comNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getComText() {
		return comText;
	}

	public void setComText(String comText) {
		this.comText = comText;
	}

	public int getComGood() {
		return comGood;
	}

	public void setComGood(int comGood) {
		this.comGood = comGood;
	}

	public int getComBad() {
		return comBad;
	}

	public void setComBad(int comBad) {
		this.comBad = comBad;
	}

	public Timestamp getComDate() {
		return comDate;
	}

	public void setComDate(Timestamp comDate) {
		this.comDate = comDate;
	}

	
	

}
