package com.godvoice.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.godvoice.beans.Collect;
import com.godvoice.beans.Song;
import com.godvoice.beans.User;
import com.godvoice.utils.DataSourceUtils;

public class CollectDaoImp implements CollectDao {
	private QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	@Override
	public List<Song> getSongsByUser(User usr) {
		String sql = "select * from song where songid in (select songid from collectList where colid = (Select colid from collect where usid = ?));";
		try {
			return qr.query(sql, new BeanListHandler<Song>(Song.class),usr.getUsid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int createListByUserIfNotExist(User usr) {
		String selectSql = "select * from collect where usid=?";
		Collect col = null;
		try {
			col = qr.query(selectSql, new BeanHandler<>(Collect.class), usr.getUsid());
			if(col == null) {
				String updateSql = "insert into collect values(null,?)";
				qr.update(updateSql,usr.getUsid());
				col = qr.query(selectSql, new BeanHandler<>(Collect.class), usr.getUsid());
			}
			return col.getColid();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void addSongToCollect(Song song, Collect col) {
		String sql = "insert into collectList values(?,?)";
		try {
			qr.update(sql,col.getColid(),song.getSongid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteSongFromCollection(Song song, Collect col) {
		String sql = "delete from collectList where colid = ? AND songid = ?";
		try {
			qr.update(sql, col.getColid(),song.getSongid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
