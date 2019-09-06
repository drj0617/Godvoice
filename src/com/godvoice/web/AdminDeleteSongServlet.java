package com.godvoice.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.godvoice.service.SongServiceImpl;
import com.godvoice.service.SongsService;

/**
 * Servlet implementation class AdminDeleteSongServlet
 */
@WebServlet("/AdminDeleteSongServlet")
public class AdminDeleteSongServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String songid = request.getParameter("songid");
		
		SongsService ss = new SongServiceImpl();
		
		boolean deleteSong = ss.deleteSongById(Integer.valueOf(songid));
		
		if(deleteSong) {
			response.sendRedirect("/Godvoice/admin.jsp");
		}else {
			response.sendRedirect("/Godvoice/header.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
