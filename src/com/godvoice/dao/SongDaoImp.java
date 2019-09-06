package com.godvoice.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.beans.Style;
import com.godvoice.service.SingerService;
import com.godvoice.service.SingerServiceImpl;
import com.godvoice.utils.DataSourceUtils;

public class SongDaoImp implements SongDao{

	private QueryRunner qu = new QueryRunner(DataSourceUtils.getDataSource());
	
	
	@Override
	public List<Song> getAllSong() {
		
		String sql = "select * from song";
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Song>(Song.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Song> getSongBySinger(Singer singer) {

		String sql = "select * from song where sigid=?";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Song>(Song.class),
					singer.getSigid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Song> getSongByAlbum(Album album) {
		
		String sql = "select * from song where albid=?";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Song>(Song.class),
					album.getAlbid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Song> getSongByStyle(Style style) {
		
		String sql = "select * from song where styleid=?";
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Song>(Song.class),
					style.getStyleid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getCount() {

		String sql = "select count(1) from song";
		
		try {
			long count = (long) qu.query(DataSourceUtils.getConnection(),
					sql, new ScalarHandler());
			return (int) count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<Song> findSongByPage(int currentPage, int pageSize) {

		// 第一个?：从第几条开始 0
		// 第二个?: pageSize
		// currentPage = 3,pageSize=2
		int startRow = (currentPage -1) * pageSize;
		
		String sql = "select songname,signame,albname,stylename from song join singer on song.sigid = singer.sigid join album on song.albid = album.albid join style on song.styleid = style.styleid  limit ?,?";
		
		try {
			List<Song> allSong = qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Song>(Song.class),
					startRow,pageSize);
//			System.out.println(allSong);.
			
			return allSong;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean removeSongById(int songId) {
		
		String sql = "delete from song where songid=?";
		
		try {
			int update = qu.update(DataSourceUtils.getConnection(),
					sql,songId);
			if(update == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Song getSongById(String id) {
		String sql = "select * from song where songid=?";
		try {
			return qu.query(DataSourceUtils.getConnection(),sql, new BeanHandler<Song>(Song.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	
	@Override
	public int getStyleIdByStylename(String stylename) {
		String sql="select styleid from style where stylename=?";
		try {
			return ((Integer) qu.query(sql, new ScalarHandler(),stylename)).intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Song addSong(String songname, String songURL, int styleid, int sigid, int albid) {
		Song song=new Song();
        String sql="insert into song values(null,?,?,?,?,?)";
        try {
			qu.update(sql,songname,songURL,styleid,sigid,albid );
			song.setStyleid(styleid);
			song.setAlbid(albid);
			song.setSigid(sigid);
			song.setSongname(songname);
			song.setSongURL(songURL);
			return song;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getAlbumIdByAlbumname(String albumname) {
		String sql="select albid from album where albname=?";
		try {
//			System.out.println("albid"+qu.query(sql, new BeanHandler<Integer>(Integer.class),albumname));
			return ((Integer)qu.query(sql, new ScalarHandler(),albumname)).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getSingerIDBySingername(String singername) {
		String sql="select sigid from singer where signame=?";
		try {
			return ((Integer)qu.query(sql, new ScalarHandler(),singername)).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override

	public String getSongIDByName(String songname) {
		String sql="select songURL from song where songname=?";
		try {
			return (String) (qu.query(sql, new ScalarHandler(),songname));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	public Map<Song, Singer> getSong_SingerMap(List<Song> songs) {
		SingerService ss = new SingerServiceImpl();
		Map<Song, Singer> map = new HashMap<>();
		for(Song s : songs) {
			Singer singer = ss.getSingerBySongs(s);
			map.put(s, singer);
		}
		return map;
	}


}
