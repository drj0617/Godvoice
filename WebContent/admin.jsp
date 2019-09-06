<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.godvoice.* , java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
<style type="text/css">
.btn {
	width: 100px;
	height: 30px;
	font-size: 13pt;
}

.body{
	background-image:url(/Godvoice/images/adminBackground.jpg);
	background-repeat:repeat;
}




</style>

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

	$(function() {
		$("#selectAll").click(function() {
			$("input[type='checkbox']").prop("checked",$("#selectAll").prop("checked"));
		});
		
		$("#add").click(function() {
			window.location.href="${pageContext.request.contextPath }/addSong.jsp";
		});
	});
	function go(val) {
		// 改变currentPage
		$("#currentPage").val(parseInt($("#currentPage").val())+val);
		// 提交表单
		$("#page").submit();
	}
	
	
</script>

</head>
<body class="body" >

	<form  id="page" action="${pageContext.request.contextPath }/AdminManageSongServlet">
	<table align="center" style="font-size: 18pt; FILTER:alpha(opacity=40)">
		<caption>音乐后台管理</caption>
		
		<tr>
			<td>
				<input type="button" value="歌曲上传" class="btn" id="add"> 
			<td>
		</tr>
		<tr>
			<td>
				<table border="1"  cellpadding="0" cellspacing="0" width="900px" style=" font-size: 15pt">
					<thead>
						<tr>
							<th><input type="checkbox" id="selectAll"></th>
							<th>音乐名</th>
							<th>歌手</th>
							<th>风格</th>
							<th>专辑</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<%session.getAttribute("showAllSong"); %>
						<c:forEach items="${showAllSong.list}" var="entry">
							<tr align="center">
								<td><input type="checkbox" name="id" value="${entry.songid }"></td>
								<td>${entry.songname}</td>
								<td>${entry.signame}</td>
								<td>${entry.stylename}</td>
								<td>${entry.albname}</td>
								<td>
									<a href="${pageContext.request.contextPath }/AdminDeleteSongSevlet?id=${entry.songid}" id="delete">删除</a> 
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</td>
		</tr>
			<tr align="center" style="font-size: 10pt">
			<td >
				共[<B>${showAllSong.totalCount }</B>]条记录,
				[<B>${showAllSong.totalPage }</B>]页 , 
				每页显示 <select name="pageSize" onchange="go(0)">
							<option value="5" ${showAllSong.pageSize==5? "selected":"" }>5</option>
							<option value="10" ${showAllSong.pageSize==10? "selected":"" }>10</option>
						</select> 条 
				[<A href="javascript:void(0)" onclick="go(-1)">前一页</A>] 
				<B>${showAllSong.currentPage }</B> 
				[<A href="javascript:void(0)" onclick="go(1)">后一页</A>] 
				到 <input type="text" size="3" id="currentPage" name="currentPage" value="${showAllSong.currentPage }" /> 页 
					<input type="submit" value="Go" />
			</td>
		</tr>
	</table>
	</form>
</body>
</html>