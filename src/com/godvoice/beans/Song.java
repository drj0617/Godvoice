package com.godvoice.beans;

public class Song {
	private int songid;
	private String songname;
	private String songURL;
	private int styleid;
	private int sigid;
	private int albid;
	private String signame;
	private String stylename;
	private String albname;

    public Song() {
		super();
	}
 	public String getSigname() {
		return signame;
	}
	public void setSigname(String signame) {
		this.signame = signame;
	}
	public String getStylename() {
		return stylename;
	}
	public void setStylename(String stylename) {
		this.stylename = stylename;
	}
	public String getAlbname() {
		return albname;
	}
	public void setAlbname(String albname) {
		this.albname = albname;
	}
	public int getSongid() {
		return songid;
	}

	public void setSongid(int songid) {
		this.songid = songid;
	}

	public String getSongname() {
		return songname;
	}

    public void setSongname(String songname) {
		this.songname = songname;
	}

	public String getSongURL() {
		return songURL;
	}

	public void setSongURL(String songURL) {
		this.songURL = songURL;
	}

	public int getStyleid() {
		return styleid;
	}

	public void setStyleid(int styleid) {
		this.styleid = styleid;
	}

	public int getSigid() {
		return sigid;
	}

	public void setSigid(int sigid) {
		this.sigid = sigid;
	}

	public int getAlbid() {
		return albid;
	}

	public void setAlbid(int albid) {
		this.albid = albid;
	}

	@Override
	public String toString() {
		return "Song [songid=" + songid + ", songname=" + songname + ", songURL=" + songURL + ", styleid=" + styleid
				+ ", sigid=" + sigid + ", albid=" + albid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + albid;
		result = prime * result + ((albname == null) ? 0 : albname.hashCode());
		result = prime * result + sigid;
		result = prime * result + ((signame == null) ? 0 : signame.hashCode());
		result = prime * result + songid;
		result = prime * result + ((songname == null) ? 0 : songname.hashCode());
		result = prime * result + styleid;
		result = prime * result + ((stylename == null) ? 0 : stylename.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (albid != other.albid)
			return false;
		if (albname == null) {
			if (other.albname != null)
				return false;
		} else if (!albname.equals(other.albname))
			return false;
		if (sigid != other.sigid)
			return false;
		if (signame == null) {
			if (other.signame != null)
				return false;
		} else if (!signame.equals(other.signame))
			return false;
		if (songid != other.songid)
			return false;
		if (songname == null) {
			if (other.songname != null)
				return false;
		} else if (!songname.equals(other.songname))
			return false;
		if (styleid != other.styleid)
			return false;
		if (stylename == null) {
			if (other.stylename != null)
				return false;
		} else if (!stylename.equals(other.stylename))
			return false;
		return true;
	}
	
}
