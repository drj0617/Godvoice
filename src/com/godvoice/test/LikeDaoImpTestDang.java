package com.godvoice.test;

import java.util.List;

import org.junit.Test;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.dao.LikeDao;
import com.godvoice.dao.LikeDaoImp;

public class LikeDaoImpTestDang {

	LikeDao d = new LikeDaoImp();
	
	@Test
	public void test01() {
		List<Album> likeAlbum = d.likeAlbum("f");
		System.out.println(likeAlbum);
	}
	
	@Test
	public void test02() {
		List<Singer> likeSinger = d.likeSinger("陈");
		System.out.println(likeSinger);
	}

	@Test
	public void test03() {
		List<Song> likeSong = d.likeSong("手");
		System.out.println(likeSong);
	}
	
}
