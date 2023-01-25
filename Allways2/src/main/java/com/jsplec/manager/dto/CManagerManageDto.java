package com.jsplec.manager.dto;

public class CManagerManageDto {
	String managerId;
	String managerPw;
	String managerInintdate;
	String managerDeletedate;
	String managerUpdatedate;
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerPw() {
		return managerPw;
	}
	public void setManagerPw(String managerPw) {
		this.managerPw = managerPw;
	}
	public String getManagerInintdate() {
		return managerInintdate;
	}
	public void setManagerInintdate(String managerInintdate) {
		this.managerInintdate = managerInintdate;
	}
	public String getManagerDeletedate() {
		return managerDeletedate;
	}
	public void setManagerDeletedate(String managerDeletedate) {
		this.managerDeletedate = managerDeletedate;
	}
	public String getManagerUpdatedate() {
		return managerUpdatedate;
	}
	public void setManagerUpdatedate(String managerUpdatedate) {
		this.managerUpdatedate = managerUpdatedate;
	}
	public CManagerManageDto(String managerId, String managerPw, String managerInintdate, String managerDeletedate,
			String managerUpdatedate) {
		super();
		this.managerId = managerId;
		this.managerPw = managerPw;
		this.managerInintdate = managerInintdate;
		this.managerDeletedate = managerDeletedate;
		this.managerUpdatedate = managerUpdatedate;
	}
	
	
}
