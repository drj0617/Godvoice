package com.godvoice.web;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.godvoice.beans.Album;
import com.godvoice.beans.Song;
import com.godvoice.beans.SongJson;
import com.godvoice.service.AlbumService;
import com.godvoice.service.AlbumServiceImpl;
import com.godvoice.service.SongServiceImpl;
import com.godvoice.service.SongsService;
import com.google.gson.Gson;


@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String songid = request.getParameter("songid");
		SongsService ss = new SongServiceImpl();
		AlbumService as = new AlbumServiceImpl();
		Song addsong = ss.getSongById(songid);
		Album album = as.getAlbumBySong(addsong);
		System.out.println(album);
		SongJson songJson = new SongJson(album.getPicURL(),addsong.getSongURL(),addsong.getSongname());
		System.out.println("添加一首歌到播放列表："+songJson);
		HttpSession session = request.getSession();
		if(session.getAttribute("playlist") == null) {
			Set<SongJson> playlist = new LinkedHashSet<SongJson>();
			playlist.add(songJson);
			session.setAttribute("playlist", playlist);
			session.setAttribute("playlistJson", new Gson().toJson(playlist));
			session.setAttribute("size", playlist.size());
		}else {
			Set<SongJson> playlist = (Set<SongJson>) session.getAttribute("playlist");
			playlist.add(songJson);
			session.setAttribute("playlist", playlist);
			session.setAttribute("playlistJson", new Gson().toJson(playlist));
			session.setAttribute("size", playlist.size());
		}
		request.getRequestDispatcher("/header.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
