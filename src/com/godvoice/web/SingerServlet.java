package com.godvoice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.service.SongServiceImpl;
import com.godvoice.service.SongsService;
import com.google.gson.Gson;

public class SingerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sigid = request.getParameter("singerid");
		String signame = request.getParameter("singername");
		Singer s = new Singer();
		s.setSigname(signame);
		s.setSigid(Integer.parseInt(sigid));
		SongsService ss = new SongServiceImpl();
		List<Song> songs = ss.getSongBySingers(s);
		System.out.println(songs);
		Gson gson = new Gson();
		gson.toJson(songs);
		request.setAttribute("songs", songs);
		request.setAttribute("singer", s);
		request.getRequestDispatcher("/single.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}