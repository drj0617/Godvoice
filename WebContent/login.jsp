<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Godvoice - 登录</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css"/>

<style>
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
	 /* position:relative;
	 float:left; */
 }
 
font {
    color: #666;
    font-size: 22px;
    font-weight: normal;
    padding-right:17px;
}
 </style>
</head>
<body>
<script type="text/javascript" src="/Godvoice/jquery.validate.js"></script>
	<script type="text/javascript">
	
	</script>	
	
	
	
<div class="container"  style="width:100%;height:800px;background:#FF2C4C ;">
<div class="row"> 
	<div class="col-md-7">
		<!--<img src="./image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
	</div>
	
	<div class="col-md-5">
				<div style="width:440px;border:1px solid #E7E7E7;padding:0px 0 0px 0px;border-radius:5px;margin-top:60px;background:#fff;">
				<font>会员登录</font>USER LOGIN

				<div>&nbsp;</div>
<form class="form-horizontal" action="${pageContext.request.contextPath }/LoginServlet" method="post">
  <span style="color:red">${exception.message }</span>
 <div class="form-group">
    <label for="email" class="col-sm-2 control-label">帐号</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="email" placeholder="请输入帐号(Eamil)" name="email"
      		value="${user.email }">
    </div>
  </div>
   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label" >密码</label>
    <div class="col-sm-6">
      <input type="password" class="form-control" id="inputPassword3" placeholder="请输入密码" name=f>
    </div>
  </div>
  
  
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    <input type="submit"  width="100px" value="登录" name="submit" border="0"
    style="height:35px;width:100px;">
    </div>
  </div>
</form>
</div>			
	</div>
</div>
</div>	

	
</body></html>