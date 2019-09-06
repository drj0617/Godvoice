package com.godvoice.test;

import java.util.List;

import org.junit.Test;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.beans.Style;
import com.godvoice.dao.SingerDao;
import com.godvoice.dao.SingerDaoImp;

public class SingerDaoImpTestDang {
	
	SingerDao sd = new SingerDaoImp();
	Album a = new Album();
	Style s = new Style();
	Song ss= new Song();
	
	@Test
	public void test01() {
		List<Singer> allSingers = sd.getAllSingers();
		System.out.println(allSingers);
	}
	
	@Test
	public void test02() {
		a.setAlbid(12);
		Singer singerByAlbum = sd.getSingerByAlbum(a);
		System.out.println(singerByAlbum);
	}
	
	@Test
	public void test03() {
		//怎么输入style从而获得style对应的歌手信息
		s.setStyleid(1);
		List<Singer> singerByStyle = sd.getSingerByStyle(s);
		System.out.println(singerByStyle);
	}

	@Test
	public void test04() {
		ss.setSigid(3);
		Singer singerBySong = sd.getSingerBySong(ss);
		System.out.println(singerBySong);
	}
	
}

