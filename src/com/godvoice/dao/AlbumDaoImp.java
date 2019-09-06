package com.godvoice.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.utils.DataSourceUtils;

public class AlbumDaoImp implements AlbumDao{

	QueryRunner qu = new QueryRunner();
	
	@Override
	public List<Album> getAllAlbum() {
		
		String sql = "select * from album";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Album>(Album.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Album> getAlbumBySinger(Singer singer) {

		String sql = "select * from album where sigid=?";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Album>(Album.class),
					singer.getSigid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Album getAlbumBySong(Song song) {
		String sql = "select * from album where albid=(select albid from song where songid=?);";
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanHandler<Album>(Album.class),
					song.getSongid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public Album addAlbums(String albumname ,int singerid) {
	     String sql="insert into album values(null,?,?,?)";	
	     Album album=new Album();
	     try {
	    	 album.setPicURL("/Godvoice/album/default.jpg");
	    	 qu.update(DataSourceUtils.getConnection(),
	    			 sql,albumname,album.getPicURL(),singerid);
			album.setSigid(singerid);
			album.setAlbname(albumname);
			SongDao sd=new SongDaoImp();
			int albumid=sd.getAlbumIdByAlbumname(albumname);
			album.setAlbid(albumid);
			System.out.println("albumdao"+album);
			return album;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}


	@Override
	public String getAlbumByName(String albumname) {
		String sql = "select picURL from album where albname=?";
		try {
			return (String) (qu.query(DataSourceUtils.getConnection(),sql, new ScalarHandler(),albumname));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}
