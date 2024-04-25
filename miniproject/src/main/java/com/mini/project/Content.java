package com.mini.project;

import java.sql.Timestamp;

public class Content {
	public int contentNo;
	public Timestamp conReDate;
	public String userId;
	public String conTitle;
	public String conText;
	public String conFile;
	public int conCount;
	public int conGood;
	public int conBad;
	public String conShare;
	
	public Content() {}

	public Content(int contentNo, Timestamp conReDate, String userId, String conTitle, String conText, String conFile,
			int conCount, int conGood,int conBad, String conShare) {
		super();
		this.contentNo = contentNo;
		this.conReDate = conReDate;
		this.userId = userId;
		this.conTitle = conTitle;
		this.conText = conText;
		this.conFile = conFile;
		this.conCount = conCount;
		this.conGood = conGood;
		this.conShare = conShare;
	}

	public int getContentNo() {
		return contentNo;
	}

	public void setContentNo(int contentNo) {
		this.contentNo = contentNo;
	}

	public Timestamp getConReDate() {
		return conReDate;
	}

	public void setConReDate(Timestamp conReDate) {
		this.conReDate = conReDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getConTitle() {
		return conTitle;
	}

	public void setConTitle(String conTitle) {
		this.conTitle = conTitle;
	}

	public String getConText() {
		return conText;
	}

	public void setConText(String conText) {
		this.conText = conText;
	}

	public String getConFile() {
		return conFile;
	}

	public void setConFile(String conFile) {
		this.conFile = conFile;
	}

	public int getConCount() {
		return conCount;
	}

	public void setConCount(int conCount) {
		this.conCount = conCount;
	}

	public int getConGood() {
		return conGood;
	}

	public void setConGood(int conGood) {
		this.conGood = conGood;
	}
	public int getConBad() {
		return conGood;
	}
	
	public void setConBad(int conBad) {
		this.conGood = conGood;
	}

	public String getConShare() {
		return conShare;
	}

	public void setConShare(String conShare) {
		this.conShare = conShare;
	}

	
	
}
