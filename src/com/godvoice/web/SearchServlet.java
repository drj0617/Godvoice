package com.godvoice.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.dao.LikeDao;
import com.godvoice.dao.LikeDaoImp;
import com.godvoice.service.QueryService;
import com.godvoice.service.QueryServiceImp;
import com.godvoice.service.SingerService;
import com.godvoice.service.SingerServiceImpl;
import com.godvoice.service.SongServiceImpl;
import com.godvoice.service.SongsService;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = new String(request.getParameter("search").getBytes("ISO8859-1"),"UTF-8");
		QueryService qs = new QueryServiceImp();
		Map<Song, Singer> sonsigmap = qs.getSongSingerMapByword(search);
		request.setAttribute("sonsigmap", sonsigmap);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}