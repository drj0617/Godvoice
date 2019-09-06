<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script type="text/javascript">

</script>
</head>
<body class="body" >

	<fieldset >
		<legend>歌曲上传</legend>
		<form action="${pageContext.request.contextPath}/addSongServlet?do=addinfo" style="font-size: 18pt; "  method="post">
			歌曲名称：<input type="text" id="songname" name="songname"><br /> <span id="span"></span>
			歌手名称：<input type="text" name="singername"><br />
			 风格：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="stylename"> (大陆歌星/港台歌星/海外歌星)<br />
			 专辑名称：<input type="text" name="albumname"><br />
			 <input type="submit" value="录入信息">
		</form>
		<form style=" font-size: 18pt"  method="post"   enctype="multipart/form-data"
			action="${pageContext.request.contextPath}/addSongServlet?do=upload">
			<input type="file" name="upload"/><br>
			<input type="submit" value="开始上传">
		</form>
	</fieldset>

</body>
</html>