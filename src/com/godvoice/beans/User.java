package com.godvoice.beans;

public class User {
	private int usid;
	private String  uname;
	private String mobilenum;
	private String email;
	private String password;
	
	
	
	public User() {
		super();
	}
	public int getUsid() {
		return usid;
	}
	public void setUsid(int usid) {
		this.usid = usid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getMobilenum() {
		return mobilenum;
	}
	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [usid=" + usid + ", uname=" + uname + ", mobilenum=" + mobilenum + ", email=" + email
				+ ", password=" + password + "]";
	}
	

}
