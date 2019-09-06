package com.godvoice.test;

import java.util.List;

import org.junit.Test;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.dao.AlbumDao;
import com.godvoice.dao.AlbumDaoImp;

public class AlbumDaoImpTestDang {
	
	AlbumDao ad = new AlbumDaoImp();
	Singer ss = new Singer();
	
	@Test
	public void test01() {
		List<Album> allAlbum = ad.getAllAlbum();
		System.out.println(allAlbum);
	}
	
	@Test
	public void test02() {
		ss.setSigid(2);
		List<Album> albumBySinger = ad.getAlbumBySinger(ss);
		System.out.println(albumBySinger);
	}
	

}
