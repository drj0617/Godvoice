package com.godvoice.service;

import java.util.List;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.beans.Style;
import com.godvoice.utils.PageBean;

public interface SongsService {
	List<Song> getAllSongs();
    List<Song> getSongBySingers(Singer singer);
    List<Song> getSongByAlbums(Album album);
    List<Song> getSongByStyles(Style style);
	PageBean<Song> showAllSong(String currentPageStr, String pageSizeStr);
	boolean deleteSongById(int songid);
	Song getSongById(String id);
	Song addSong(String songname,String songURL, String singername, String stylename, String albumname);
	String getSongbySongname(String songname);
  
}
