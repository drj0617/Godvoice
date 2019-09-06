package com.godvoice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.godvoice.beans.Song;
import com.godvoice.service.SongServiceImpl;
import com.godvoice.service.SongsService;
import com.godvoice.utils.PageBean;

/**
 * Servlet implementation class ManagementSongServlet
 */
@WebServlet("/AdminManageSongServlet")
public class AdminManageSongServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		SongsService ss = new SongServiceImpl();
		String pageSize = request.getParameter("pageSize");
		String currentPage = request.getParameter("currentPage");
		PageBean<Song> showAllSong = ss.showAllSong(currentPage,pageSize);
		

//		System.out.println(showAllSong);
		
//		request.setAttribute("showAllSong",showAllSong);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("showAllSong", showAllSong);
		
//		request.getRequestDispatcher("/Godvoice/admin.jsp").forward(request, response);
		
		response.sendRedirect("/Godvoice/admin.jsp");
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
