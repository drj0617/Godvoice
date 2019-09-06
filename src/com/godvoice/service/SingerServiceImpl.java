package com.godvoice.service;

import java.util.List;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.beans.Style;
import com.godvoice.dao.SingerDao;
import com.godvoice.dao.SingerDaoImp;
import com.godvoice.dao.SongDao;
import com.godvoice.dao.SongDaoImp;

public class SingerServiceImpl implements SingerService {
    SingerDao sd=new SingerDaoImp();
    SongDao sdd=new SongDaoImp();
	@Override
	public List<Singer> getAllSingerss() {
		List<Singer>list=sd.getAllSingers();
		return list;
	}

	@Override
	public Singer getSingerByAlbum(Album album) {
		Singer singer=sd.getSingerByAlbum(album);
		return singer;
	}

	@Override
	public Singer getSingerBySongs(Song song) {
		Singer singer=sd.getSingerBySong(song);
		return singer;
	}

	@Override
	public List<Singer> getSingerByStyle(Style style) {
		List<Singer> singers=sd.getSingerByStyle(style);
		return singers;
	}

	@Override
	public String getSingerBySingername(String singername) {
		
	   return sd.getSingerByName(singername);
	
	}

	@Override
	public Singer addSinger(String singername , String stylename) {
		int styleid=sdd.getStyleIdByStylename(stylename);
		return sd.addsinger(singername,styleid);
		
	}

}
