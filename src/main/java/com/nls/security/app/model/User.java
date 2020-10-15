package com.nls.security.app.model;


public class User {
	private String username;
	private String password;
	private String fullname;
	private String idCard;
	private String branId;
	private Integer status;
	private String positionId;
	private String subBranId;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getBranId() {
		return branId;
	}
	public void setBranId(String branId) {
		this.branId = branId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	public String getSubBranId() {
		return subBranId;
	}
	public void setSubBranId(String subBranId) {
		this.subBranId = subBranId;
	}
}