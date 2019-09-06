package com.godvoice.dao;

import java.util.List;
import java.util.Map;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.beans.Style;

public interface SongDao {

	List<Song> getAllSong();
	
	List<Song> getSongBySinger(Singer singer);
	
	List<Song> getSongByAlbum(Album album);
	
	List<Song> getSongByStyle(Style style);
	
	Song getSongById(String id);

	int getCount();

	List<Song> findSongByPage(int currentPage, int pageSize);

	boolean removeSongById(int songId);


	Song addSong(String songname, String songURL, int styleid, int sigid, int sigid2);

	int getStyleIdByStylename(String stylename);

	int getAlbumIdByAlbumname(String albumname);

	int getSingerIDBySingername(String singername);
	

	String getSongIDByName(String songname);

	

	Map<Song, Singer> getSong_SingerMap(List<Song> songs);

	
}
