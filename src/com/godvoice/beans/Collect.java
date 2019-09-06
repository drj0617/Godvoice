package com.godvoice.beans;

public class Collect {
     private int colid;
     private int usid;
	public Collect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getColid() {
		return colid;
	}
	public void setColid(int colid) {
		this.colid = colid;
	}
	public int getUsid() {
		return usid;
	}
	public void setUsid(int usid) {
		this.usid = usid;
	}
	@Override
	public String toString() {
		return "Colllection [colid=" + colid + ", usid=" + usid + "]";
	}
     
}
