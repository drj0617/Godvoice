package com.godvoice.dao;

import java.util.List;
import java.util.Map;

import com.godvoice.beans.Collect;
import com.godvoice.beans.Song;
import com.godvoice.beans.User;

public interface CollectDao {
	List<Song> getSongsByUser(User usr);
	
	int createListByUserIfNotExist(User usr);
	
	void addSongToCollect(Song song, Collect col);
	
	void deleteSongFromCollection(Song song,Collect col);
}
