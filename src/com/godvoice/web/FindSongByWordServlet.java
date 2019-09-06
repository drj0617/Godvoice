package com.godvoice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.godvoice.beans.Song;
import com.godvoice.service.QueryService;
import com.godvoice.service.QueryServiceImp;
import com.google.gson.Gson;

/**
 * Servlet implementation class FindSongByWordServlet
 */
@WebServlet("/FindSongByWordServlet")
public class FindSongByWordServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String word = request.getParameter("search");
		QueryService qs = new QueryServiceImp();
//		List<Song> songByWord = qs.getSongByWord(word);
		
//		List<Song> songs = qs.getSongByAnyWord(word);
		List<Song> songs = qs.getSongList(word);

		
//		System.out.println(songs);
		Gson gson = new Gson();
		String json = gson.toJson(songs);
		
//		System.out.println(json);
		response.getWriter().write(json.toString());
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
