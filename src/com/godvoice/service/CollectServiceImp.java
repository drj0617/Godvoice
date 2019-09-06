package com.godvoice.service;

import java.util.List;
import java.util.Map;

import com.godvoice.beans.Collect;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.beans.User;
import com.godvoice.dao.CollectDao;
import com.godvoice.dao.CollectDaoImp;
import com.godvoice.dao.SongDao;
import com.godvoice.dao.SongDaoImp;

public class CollectServiceImp implements CollectService {
	CollectDao cd = new CollectDaoImp();
	@Override
	public void addSongToUserCollect(Song song, User usr) {
		int colid = cd.createListByUserIfNotExist(usr);
		if(colid != -1 ){
			Collect col = new Collect();
			col.setColid(colid);
			col.setUsid(usr.getUsid());
			cd.addSongToCollect(song, col);
			System.out.println("收藏成功");
		}else 
			System.out.println("收藏失败");
	}
	@Override
	public Map<Song, Singer> getCollectionMapByUser(User user) {
		CollectDao cd = new CollectDaoImp();
		SongDao sd = new SongDaoImp();
		List<Song> songs = cd.getSongsByUser(user);
		return sd.getSong_SingerMap(songs);
	}

}
