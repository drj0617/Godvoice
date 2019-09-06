package com.godvoice.beans;

public class CollectList {
   private int colid;
   private int songid;
public CollectList() {
	super();
	// TODO Auto-generated constructor stub
}
public int getColid() {
	return colid;
}
public void setColid(int colid) {
	this.colid = colid;
}
public int getSongid() {
	return songid;
}
public void setSongid(int songid) {
	this.songid = songid;
}
@Override
public String toString() {
	return "CollectionList [colid=" + colid + ", songid=" + songid + "]";
}
   
   
}
