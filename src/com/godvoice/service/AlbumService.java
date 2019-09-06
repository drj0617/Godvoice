package com.godvoice.service;

import java.util.List;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;

public interface AlbumService {
    List<Album> getAllAlbums();
    Album getAlbumBySong(Song song);
    List<Album> getAlbumBySinger(Singer singer);
	Album addAlbum(String albumname ,String singername);
	String getAlbumByAlbumname(String albumname );
}
