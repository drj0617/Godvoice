package com.godvoice.service;

import java.util.List;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.beans.Style;

public interface SingerService {
List<Singer> getAllSingerss();
Singer getSingerByAlbum(Album album);
Singer getSingerBySongs(Song song);
List<Singer> getSingerByStyle(Style style);
String getSingerBySingername(String singername);
Singer addSinger(String singername, String stylename);

}
