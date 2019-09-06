package com.godvoice.test;

import java.util.List;

import org.junit.Test;

import com.godvoice.beans.Song;
import com.godvoice.service.SongServiceImpl;
import com.godvoice.service.SongsService;
import com.godvoice.utils.PageBean;

public class SongServiceImplTestDang {

	@Test
	public void test01() {
		
		SongsService ss = new SongServiceImpl();
		
		PageBean<Song> showAllSong = ss.showAllSong("1", "10");
		
		System.out.println(showAllSong);
		
		
	}
	
	
}
