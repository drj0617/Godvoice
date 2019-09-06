package com.godvoice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.service.SingerService;
import com.godvoice.service.SingerServiceImpl;
import com.godvoice.service.SongServiceImpl;
import com.godvoice.service.SongsService;
import com.google.gson.Gson;

public class AlbumListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String albid=request.getParameter("albid");
		String albname=request.getParameter("albname");
		Album album=new Album();
		album.setAlbid(Integer.valueOf(albid));
		album.setAlbname(albname);
		SongsService ss=new SongServiceImpl();
	    List<Song>songs=ss.getSongByAlbums(album);
	    System.out.println(songs);
	    SingerService ss1=new SingerServiceImpl();
	    Singer singer=ss1.getSingerByAlbum(album);
	    request.setAttribute("songs", songs);
	    request.setAttribute("album", album);
	    request.setAttribute("singer", singer);
	    request.getRequestDispatcher("/albumlist.jsp").forward(request, response);;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}