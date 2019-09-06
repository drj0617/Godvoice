package com.godvoice.dao;

import java.util.List;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;

public interface LikeDao {
	
	List<Song> likeSong(String songName);
	
	List<Singer> likeSinger(String singerName);
	
	List<Album> likeAlbum(String albumName);

	List<Song> likeAnySong(String word);
	
	List<Song> likeSongs(String word);
	
	List<Song> likeAlbums(String word);
	
	List<Song> likeSingers(String word);
	
	List<Song> likeStyles(String word);

}
