package com.godvoice.service;

import java.util.List;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.dao.AlbumDao;
import com.godvoice.dao.AlbumDaoImp;
import com.godvoice.dao.SingerDao;
import com.godvoice.dao.SingerDaoImp;
import com.godvoice.dao.SongDao;
import com.godvoice.dao.SongDaoImp;

public class AlbumServiceImpl implements AlbumService{
    AlbumDao ad=new AlbumDaoImp();
    SongDao sd=new SongDaoImp();
    SingerDao sdd=new SingerDaoImp();
	@Override
	public List<Album> getAllAlbums() {
		List<Album> list=ad.getAllAlbum();
		return list;
	}

//	@Override
//	public Album getAlbumBySong(Song song) {
//	   Album album= ad.getAlbumBySong(song);
//		return album;
//	}

	@Override
	public List<Album> getAlbumBySinger(Singer singer) {
		List<Album> albums=ad.getAlbumBySinger(singer);
		return albums;
	}

	@Override
	public Album getAlbumBySong(Song song) {
		Album album = ad.getAlbumBySong(song);
		return album;
	}

	@Override
	public Album addAlbum(String albumname,String singername) {
	    int singerid=sd.getSingerIDBySingername(singername);
		return ad.addAlbums(albumname,singerid);
		
	}

	@Override
	public String getAlbumByAlbumname(String albumname) {
		return ad.getAlbumByName( albumname);
		
	}



}
