package com.godvoice.service;

import java.util.Map;

import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.beans.User;

public interface CollectService {
	public abstract void addSongToUserCollect(Song song,User usr);
	Map<Song, Singer> getCollectionMapByUser(User user);
}
