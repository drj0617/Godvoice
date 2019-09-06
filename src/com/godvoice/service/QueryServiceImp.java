package com.godvoice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.dao.LikeDao;
import com.godvoice.dao.LikeDaoImp;
import com.godvoice.dao.SongDao;
import com.godvoice.dao.SongDaoImp;

public class QueryServiceImp implements QueryService {
    LikeDao ld = new LikeDaoImp();
	@Override
	public List<Song> getSongByWord(String word) {
		List<Song> list = ld.likeSong(word);
 		return list;
	}
	@Override
	public List<Singer> getSingerByWord(String word) {
		List<Singer> list1 = ld.likeSinger(word);	
		return list1;
	}
	@Override
	public List<Album> getAlbumByWord(String word) {
		List<Album> list2 = ld.likeAlbum(word);
		return list2;
	}
	@Override
	public Map<Song, Singer> getSongSingerMapByword(String word) {
		SingerService ss = new SingerServiceImpl();
		List<Song> songs = getSongList(word);
		SongDao sd = new SongDaoImp();
		return sd.getSong_SingerMap(songs);
	}
	@Override
	public List<Song> getSongByAnyWord(String word) {
		List<Song> list = ld.likeAnySong(word);
		return list;
	}
	@Override
	public List<Song> getSongList(String word) {
		
		List<Song> likeSongs = ld.likeSongs(word);
		List<Song> likeAlbums = ld.likeAlbums(word);
		List<Song> likeSingers = ld.likeSingers(word);
		List<Song> likeStyles = ld.likeStyles(word);
		
		likeSongs.addAll(likeSingers);
		likeSongs.addAll(likeAlbums);
		likeSongs.addAll(likeStyles);
		
		
		return likeSongs;
	}
	
}
