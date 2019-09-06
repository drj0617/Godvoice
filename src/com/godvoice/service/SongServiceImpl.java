package com.godvoice.service;

import java.util.List;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.beans.Style;
import com.godvoice.dao.SongDao;
import com.godvoice.dao.SongDaoImp;
import com.godvoice.utils.PageBean;

public class SongServiceImpl implements SongsService {
    SongDao sd=new SongDaoImp();
    List<Song> list;
	@Override
	public List<Song> getAllSongs() {
	   list=sd.getAllSong();
	 return list;
	}
	@Override
	public List<Song> getSongBySingers(Singer singer) {
		list=sd.getSongBySinger(singer); 
	    	  return list;
	}
	@Override
	public List<Song> getSongByAlbums(Album album) {
		list=sd.getSongByAlbum(album);
	    return list;
	}
	@Override
	public List<Song> getSongByStyles(Style style) {
		list=sd.getSongByStyle(style);
		return list;
	}
	@Override
	public PageBean<Song> showAllSong(String currentPageStr, String pageSizeStr) {
		int currentPage = 0;
		int pageSize = 0;
		int totalCount = sd.getCount();
		if(pageSizeStr == null) {
			pageSize = 5;
		}else {
			pageSize = Integer.valueOf(pageSizeStr);
		}
		
		int totalPage = (totalCount + pageSize - 1) / pageSize;
		//System.out.println(totalCount);
		if("NaN".equals(currentPageStr)) {
			currentPageStr="1";
		}
		if(currentPageStr == null||Integer.valueOf(currentPageStr)<=1) {
			currentPage = 1;
		}else if(Integer.valueOf(currentPageStr)>=totalPage){//最大页数
			currentPage=totalPage;
		}else {
			currentPage = Integer.valueOf(currentPageStr);
		}
		
		List<Song> list = sd.findSongByPage(currentPage,pageSize);
//		System.out.println(list);
		PageBean<Song> pb = new PageBean<Song>(totalCount,currentPage,pageSize);
		pb.setList(list);
		return pb;
		
	}
	@Override
	public boolean deleteSongById(int songId) {
		
		boolean deleteSong = sd.removeSongById(songId);
		if(deleteSong == true) {
			return deleteSong;
		}
		return false;
	}
	@Override
	public Song getSongById(String id) {
		return sd.getSongById(id);
	}
	@Override
	public Song addSong(String songname,String songURL, String singername, String stylename, String albumname) {
	    //System.out.println("stylename"+stylename);
	   // System.out.println("singername"+singername);
	   // System.out.println("albumname"+albumname);
		int styleid= sd.getStyleIdByStylename(stylename); 
	    //System.out.println(albumname);
	    int albumid= sd.getAlbumIdByAlbumname(albumname);
	    int sigid=sd.getSingerIDBySingername(singername);
		return sd.addSong(songname,songURL,styleid,sigid,albumid);
		
	}
	@Override
	public String getSongbySongname(String songname) {
		return sd.getSongIDByName(songname);
		
	}


	

}
