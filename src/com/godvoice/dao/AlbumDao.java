package com.godvoice.dao;

import java.util.List;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;

public interface AlbumDao {
	
	List<Album> getAllAlbum();
	
	//Album getAlbumBySong(Song song);
	
	List<Album> getAlbumBySinger(Singer singer);
	
	Album getAlbumBySong(Song song);

	Album addAlbums(String albumname,int singerid);

	String getAlbumByName(String albumname);
	
}
