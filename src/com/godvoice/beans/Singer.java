package com.godvoice.beans;

public class Singer {
	private int sigid;
    private	String signame;
    private String picURL;
    private int styleid;
	public Singer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSigid() {
		return sigid;
	}
	public void setSigid(int sigid) {
		this.sigid = sigid;
	}
	public String getSigname() {
		return signame;
	}
	public void setSigname(String signame) {
		this.signame = signame;
	}
	public String getPicURL() {
		return picURL;
	}
	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}
	
	public int getStyleid() {
		return styleid;
	}
	public void setStyleid(int styleid) {
		this.styleid = styleid;
	}
	@Override
	public String toString() {
		return "Singer [sigid=" + sigid + ", signame=" + signame + ", picURL=" + picURL + ", styleid=" + styleid + "]";
	}
	

}
