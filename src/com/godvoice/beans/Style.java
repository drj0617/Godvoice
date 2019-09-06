package com.godvoice.beans;

public class Style {
	 private int styleid;
      private String stylename;
      
      
  	public Style() {
		super();
	}
      
	public int getStyleid() {
		return styleid;
	}

	public void setStyleid(int styleid) {
		this.styleid = styleid;
	}
	public String getStylename() {
		return stylename;
	}
	public void setStylename(String stylename) {
		this.stylename = stylename;
	}

	@Override
	public String toString() {
		return "Style [styleid=" + styleid + ", stylename=" + stylename + "]";
	}
	
      
}
