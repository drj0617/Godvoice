package com.godvoice.service;

import java.util.List;
import java.util.Map;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;

public interface QueryService {
	List<Song> getSongByWord(String word);
	List<Singer> getSingerByWord(String word);
	List<Album> getAlbumByWord(String word);
	Map<Song,Singer> getSongSingerMapByword(String word);
	List<Song> getSongByAnyWord(String word);
	List<Song> getSongList(String word);
}
