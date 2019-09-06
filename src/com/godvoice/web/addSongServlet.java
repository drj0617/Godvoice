package com.godvoice.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;


import com.godvoice.beans.Album;
import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.service.AlbumService;
import com.godvoice.service.AlbumServiceImpl;
import com.godvoice.service.SingerService;
import com.godvoice.service.SingerServiceImpl;

import com.godvoice.beans.Song;
import com.godvoice.beans.User;
import com.godvoice.service.CollectService;
import com.godvoice.service.CollectServiceImp;

import com.godvoice.service.SongServiceImpl;
import com.godvoice.service.SongsService;

public class addSongServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("do");
		if("upload".equals(method)) {
			upload(request, response);
	    }else if("addinfo".equals(method)) {
			addinfo(request, response);
		}else if("addtocollect".equals(method)) {
			addtocollect(request,response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempPath =getServletContext().getRealPath("/WEB-INF/temp");
		File tmpFile = new File(tempPath);
	    if (!tmpFile.exists()) {
	        // 创建临时目录
	     	tmpFile.mkdir();
	    }
	    DiskFileItemFactory factory = new DiskFileItemFactory();
	    factory.setSizeThreshold(1024 * 100);// 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
	    factory.setRepository(new File(tempPath));// 设置上传时文件的保存目录
	    // 2.创建文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置允许上传文件的内存，这里设置为100KB，根据实际情况设置
        upload.setSizeMax(1024 * 1024 * 15);
	    // 3.判断提交上来的数据是否是上传表单的数据
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                // 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
                List<FileItem> list = upload.parseRequest(request);
               // 设置解析到的文件编码格式
                upload.setHeaderEncoding("utf-8");
                for (FileItem fileItem : list) {
                    // 判断是否文件，结果为“true”就是普通表单，如果为“false”则是文件
                    if (fileItem.isFormField()) {
                        String fileName = fileItem.getFieldName();// 获得表单name属性名
                        
                    } else {
                        String name = fileItem.getName();// 获取上传文件的名字
                        // 限制上传文件的类型
                        name = name.replaceAll("\\s*-\\s*", "-");
                        List<String> fileType = Arrays.asList("mp3");//允许上传文件的类型
                        String fileExtName = name.substring(name.lastIndexOf(".") + 1);//获得文件的后缀名
                        //System.out.println("上传文件的后缀名为:"+fileExtName);
                        if (!fileType.contains(fileExtName)) {
                            System.out.println("上传失败！文件类型只能是mp3!");
                        } else {
                            InputStream input = fileItem.getInputStream();// 获得上传文件字节流

                            // 创建输出文件
                            String outPath = request.getServletContext().getRealPath(name);
                            System.out.println("outPath"+outPath);
                            String [] outPath1 = outPath.split("\\\\");
                            StringBuffer sb=new StringBuffer();
                            for(int i=0;i<outPath1.length;i++) {
                            	
                            	if(i==outPath1.length-2) {
                            		sb.append(outPath1[i]);
                            		sb.append("\\song\\");
                            	}else if(i==outPath1.length-1) {
                            		sb.append(outPath1[i]);
                            	}
                            	else {
                            		sb.append(outPath1[i]);
                                	sb.append("\\");
                            	}
                            }
                            System.out.println("sb"+sb);
                            FileOutputStream output = new FileOutputStream(new File(sb.toString()));
                            // 使用IOUtils工具输出，也就是copy文件
                            IOUtils.copy(input, output);
                             System.out.println("上传成功！");
                             System.out.println("保存的路径为：" + sb);
                             //String split = sb.toString().replaceAll("\\\\", "/");
                             //String[] split2 = split.split("/");
//                           songURL =  "/Godvoice/song/"+split2[split2.length-1];   
                            //System.out.println(songURL);
                            // 关闭输入流
                            input.close();
                            // 关闭输出流
                            output.close();
                            // 删除处理文件上传时生成的临时文件
                            fileItem.delete();
                        }
                    }
                }
             
            } catch (FileUploadBase.SizeLimitExceededException e) {
                System.out.println("上传失败！上传的文件大小超出限制，最大只能上传"+upload.getSizeMax()+"bytes的文件");
            } catch (Exception e) {
                System.out.println("上传失败！");
                e.printStackTrace();
            }
        } else {
            // 如果不是文件上传类型，则采用普通表单获取方式
            request.setCharacterEncoding("UTF-8");
            String parameter = request.getParameter("para"+"username");
        }
	  response.sendRedirect("/Godvoice/AdminManageSongServlet");
	}
	@SuppressWarnings("unchecked")
	public void addinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String songname = new String(request.getParameter("songname").getBytes("ISO8859-1"),"UTF-8");
		String singername = new String(request.getParameter("singername").getBytes("ISO8859-1"),"UTF-8");
		String stylename = new String(request.getParameter("stylename").getBytes("ISO8859-1"),"UTF-8");
		//System.out.println(stylename);
		String albumname = new String(request.getParameter("albumname").getBytes("ISO8859-1"),"UTF-8");;
		//System.out.println(albumname);
		String serverPath = "/Godvoice/song/"+singername+"-"+songname+".mp3";
		SongsService ss = new SongServiceImpl();
		SingerService sse=new SingerServiceImpl();
		AlbumService as=new AlbumServiceImpl();
		Singer singer=null;
		Album album=null;
		Song song=null;
		List<Song>allSongs=(List<Song>)request.getServletContext().getAttribute("allsongs");
		List<Singer>allSingers=(List<Singer>)request.getServletContext().getAttribute("allsingers");
		List<Album>allAlbums=(List<Album>)request.getServletContext().getAttribute("allalbums");
		System.out.println("——添加前——");
		System.out.println("歌曲数："+ allSongs.size());
		System.out.println(allSongs);
		System.out.println("歌手数："+ allSingers.size());
		System.out.println(allSingers);
		System.out.println("专辑数："+ allAlbums.size());
		
		if(ss.getSongbySongname(songname)==null) {//歌名不存在
			if(sse.getSingerBySingername(singername)==null) {
				// 歌手不存在
				//singer加新歌手 album加新专辑 song加新歌
				//System.out.println(sse.getSingerBySingername(singername));
				singer=sse.addSinger(singername,stylename);
				album=as.addAlbum(albumname,singername);
				song=ss.addSong(songname, serverPath, singername, stylename, albumname);
				allSongs.add(song);
				allSingers.add(singer);
				allAlbums.add(album);
			}else {//歌手存在
				if(as.getAlbumByAlbumname(albumname)==null) {// 专辑不存在
					//album加新专辑 song加歌
					album=as.addAlbum(albumname,singername);
					song=ss.addSong(songname, serverPath, singername, stylename, albumname);
					allSongs.add(song);
					allAlbums.add(album);
				}else {//专辑存在 song加入对应专辑				
					song=ss.addSong(songname, serverPath, singername, stylename, albumname);
					allSongs.add(song);
				}
			}
		}
		request.getServletContext().setAttribute("allsongs", allSongs);
		request.getServletContext().setAttribute("allalbums", allAlbums);
		request.getServletContext().setAttribute("allsingers", allSingers);
		System.out.println("——添加后——");
		System.out.println("歌曲数："+ allSongs.size());
		System.out.println(allSongs);
		System.out.println("歌手数："+ allSingers.size());
		System.out.println(allSingers);
		System.out.println("专辑数："+ allAlbums.size());
		request.getRequestDispatcher("/addSong.jsp").forward(request, response);
	}
	

	public void addtocollect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String songid = request.getParameter("songid");
		String userid = request.getParameter("usid");
		if(userid == null || userid.equals(""))
		{
			response.getWriter().append("Login");
			return;
		}
		User user = new User();
		user.setUsid(Integer.parseInt(userid));
		SongsService ss = new SongServiceImpl();
		Song song = ss.getSongById(songid);
		CollectService cs = new CollectServiceImp();
		cs.addSongToUserCollect(song, user);
	}

}