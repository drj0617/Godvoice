package com.godvoice.beans;

public class Album {
 	private int albid;
	private String albname;
	private String picURL;
	private int sigid;
	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAlbid() {
		return albid;
	}
	public void setAlbid(int albid) {
		this.albid = albid;
	}
	public String getAlbname() {
		return albname;
	}
	public void setAlbname(String albname) {
		this.albname = albname;
	}
	public String getPicURL() {
		return picURL;
	}
	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}
	public int getSigid() {
		return sigid;
	}
	public void setSigid(int sigid) {
		this.sigid = sigid;
	}
	@Override
	public String toString() {
		return "Album [albid=" + albid + ", albname=" + albname + ", picURL=" + picURL + ", sigid=" + sigid + "]";
	}
	
	

}
