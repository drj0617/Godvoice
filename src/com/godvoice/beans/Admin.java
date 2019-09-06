package com.godvoice.beans;

public class Admin {
	private int adid;
	private String adname;
	private String adpassword;
	public Admin() {
		super();
	}
	public int getAdid() {
		return adid;
	}
	public void setAdid(int adid) {
		this.adid = adid;
	}
	public String getAdname() {
		return adname;
	}
	public void setAdname(String adname) {
		this.adname = adname;
	}
	public String getAdpassword() {
		return adpassword;
	}
	public void setAdpassword(String adpassword) {
		this.adpassword = adpassword;
	}
	@Override
	public String toString() {
		return "Admin [adid=" + adid + ", adname=" + adname + ", adpassword=" + adpassword + "]";
	}
	
	
	

}
