package com.godvoice.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.utils.DataSourceUtils;

public class LikeDaoImp implements LikeDao{

	QueryRunner qu = new QueryRunner();
	
	
	@Override
	public List<Song> likeSong(String songName) {
		
		String sql = "select * from singer join song on singer.sigid=song.sigid where songname like ?";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Song>(Song.class),
					"%"+songName+"%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Singer> likeSinger(String singerName) {
		
		String sql = "select distinct(signame) from singer join song on singer.sigid=song.sigid where signame like ?";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Singer>(Singer.class),
					"%"+singerName+"%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public List<Album> likeAlbum(String albumName) {

		String sql = "select * from singer join album on singer.sigid=album.sigid where albname like ?";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Album>(Album.class),
					"%"+albumName+"%");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Song> likeAnySong(String word) {

		String sql = "select * from song join singer on song.sigid = singer.sigid join album on song.albid = album.albid join style on song.styleid = style.styleid  where songname like ? or signame like ? or albname like ? or stylename like ?";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Song>(Song.class),
					"%"+word+"%","%"+word+"%","%"+word+"%","%"+word+"%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Song> likeSongs(String word) {
		
		String sql = "select * from song join singer on song.sigid = singer.sigid join album on song.albid = album.albid join style on song.styleid = style.styleid  where songname like ? ";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Song>(Song.class),
					"%"+word+"%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<Song> likeAlbums(String word) {
		
		String sql = "select * from song join singer on song.sigid = singer.sigid join album on song.albid = album.albid join style on song.styleid = style.styleid  where albname like ? ";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Song>(Song.class),
					"%"+word+"%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Song> likeSingers(String word) {

		String sql = "select * from song join singer on song.sigid = singer.sigid join album on song.albid = album.albid join style on song.styleid = style.styleid  where signame like ? ";
			
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Song>(Song.class),
					"%"+word+"%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Song> likeStyles(String word) {

		String sql = "select * from song join singer on song.sigid = singer.sigid join album on song.albid = album.albid join style on song.styleid = style.styleid  where stylename like ?";
		
		try {
			return qu.query(DataSourceUtils.getConnection(),
					sql, new BeanListHandler<Song>(Song.class),
					"%"+word+"%");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	

}
