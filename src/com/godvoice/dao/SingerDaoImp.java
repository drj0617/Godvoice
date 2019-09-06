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
import com.godvoice.beans.Style;
import com.godvoice.utils.DataSourceUtils;

public class SingerDaoImp implements SingerDao{
	
	QueryRunner qu = new QueryRunner();
    SongDao sd=new SongDaoImp();
	@Override
	public List<Singer> getAllSingers() {
		
		String sql = "select * from singer";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Singer>(Singer.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Singer getSingerByAlbum(Album album) {
		
		String sql = "select * from singer where sigid = (select sigid from album where albid=?);";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanHandler<Singer>(Singer.class),
					album.getAlbid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Singer getSingerBySong(Song song) {
		
		String sql = "select * from singer where sigid=?";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanHandler<Singer>(Singer.class),
					song.getSigid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override

	public List<Singer> getSingerByStyle(Style style) {
		String sql = "select * from singer where styleid=?";
		try {
			List<Singer> list = qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Singer>(Singer.class),
					style.getStyleid());
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}



	@Override
	public Singer addsinger(String singername, int styleid) {
		Singer singer=new Singer();
     String sql="insert into singer values(null,?,?,?)";	
     try {
    	 singer.setPicURL("/Godvoice/album/default.jpg");
    	 qu.update(DataSourceUtils.getConnection(),
    			 sql,singername,singer.getPicURL(),styleid);
		singer.setStyleid(styleid);
		singer.setSigname(singername);
		SongDao sd=new SongDaoImp();
		int sigid=sd.getSingerIDBySingername(singername);
		singer.setSigid(sigid);
	   return singer;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}

	@Override
	public String getSingerByName(String singername) {
		String sql = "select picURL from singer where signame=?";
		try {
			return (String) (qu.query(DataSourceUtils.getConnection(),sql, new ScalarHandler(),singername));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
