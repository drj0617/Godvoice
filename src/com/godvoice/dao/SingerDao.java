package com.godvoice.dao;

import java.util.List;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.beans.Style;

public interface SingerDao {

	List<Singer> getAllSingers();
	
	Singer getSingerByAlbum(Album album);
	
	Singer getSingerBySong(Song song);
	
	List<Singer> getSingerByStyle(Style style);

	Singer addsinger(String singername, int styleid);

	String getSingerByName(String singername);



	
	
	
	
	
}
