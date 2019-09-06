package com.godvoice.web;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.service.AlbumService;
import com.godvoice.service.AlbumServiceImpl;
import com.godvoice.service.SingerService;
import com.godvoice.service.SingerServiceImpl;
import com.godvoice.service.SongServiceImpl;
import com.godvoice.service.SongsService;
import com.godvoice.utils.DataSourceUtils;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
@WebListener
public class MyServletContextListener  implements ServletContextListener {
      
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
			DataSourceUtils.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	ServletContextListener.super.contextInitialized(sce);
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	SongsService ss=new SongServiceImpl();
    	SingerService ss1=new SingerServiceImpl();
    	AlbumService as=new AlbumServiceImpl();
    	List<Singer>allsingers=ss1.getAllSingerss();
    	List<Song> allsongs=ss.getAllSongs();
    	List <Album> allalbums=as.getAllAlbums();
    	sce.getServletContext().setAttribute("allsingers", allsingers);
    	sce.getServletContext().setAttribute("allsongs", allsongs);
    	sce.getServletContext().setAttribute("allalbums",allalbums);
    	ServletContextListener.super.contextInitialized(sce);
    }
	
}
