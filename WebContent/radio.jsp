<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html style="overflow: hidden;">
<head>
</head>
	<title>Godvoice - Radio</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="keywords" content="">
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<!-- Custom CSS -->
	<link href="css/style.css" rel="stylesheet" type="text/css">
<!-- Graph CSS -->
	<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<!-- lined-icons -->
	<link rel="stylesheet" href="css/icon-font.min.css" type="text/css">
<body class="sticky-header left-side-collapsed" style="">f





<!-- //lined-icons -->
 <!-- Meters graphs -->
<script src="js/jquery-1.10.2.min.js"></script>
 
    <section>
    		
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog facebook" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>						
						</div>
						<div class="modal-body">
							<div class="app-grids">
								<div class="app">
						<div class="col-md-5 app-left mpl">
							<h3>Mosaic mobile app on your smartphone!</h3>
							<p>Download and Avail Special Songs Videos and Audios.</p>
							<div class="app-devices">
								<h5>Gets the app from</h5>
								<a href="#"><img src="images/1.png" alt=""></a>
								<a href="#"><img src="images/2.png" alt=""></a>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div class="col-md-7 app-image">
							<img src="images/apps.png" alt="">
						</div>
						<div class="clearfix"></div>
					</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		<div>
			
			<div class="header-section">
	
				<div class="menu-right">
					<div class="profile_details">		
						  <div class="col-md-4 serch-part">
								<div id="sb-search" class="sb-search">
								<script type="text/javascript">
									
									$(function(){
										$("#search").keyup(function(){
											$.post(
												"${pageContext.request.contextPath}/FindSongByWordServlet",
												{
													"search":$("#search").val()
												},
												function(data){
													$("#list").empty();
													for(var i=0; i<data.length; i++){
														if(i > 10){
															break;
														}
														$("#list").append("<div style='cursor:pointer' onmouseover='over(this)' onmouseout='out(this)' onmousedown='gogo(this)'>"+data[i].songname+"</div>");
													}
													$("#list").css("display","block");
												},
												"json"
											);
										});
										$("#search").blur(function(){
											$("#list").css("display","none");
										});
										
									}
									
									);
									function over(obj){
										$(obj).css("background-color","lightgray");
									}
									function out(obj){
										$(obj).css("background-color","white");
									}
									function gogo(obj){
										$("#search").val($(obj).html());
										$("#list").css("display","none");
									}
									function showSingers(obj) {
										$.ajax({
											url : "/Godvoice/StyleServlet",
											data : {
												"styleid" : $(obj).val()
											},
											success : function(data) {
												$(".browse-inner").empty();
												for(var i = 0 ; i < data.length ; i ++){
													$(".browse-inner").append(
															"<div class='col-md-3 artist-grid' >"+
															"<a  href='${pageContext.request.contextPath }/SingerServlet?singerid="+data[i].sigid+"&singername="+data[i].signame+"'><img src='"+data[i].picURL+"' style='width: 217px; height: 242px'></a>" + 
															"<a class='art' href='${pageContext.request.contextPath }/SingerServlet?singerid="+data[i].sigid+"&singername="+data[i].signame+"'>"+data[i].signame+"</a>"+
															"</div>"		
													);
												}
											},
											dataType : "json",
											type : "post"
										});
									}
								</script>
								
									<form action="/Godvoice/SearchServlet" method="post">
										<input class="sb-search-input" placeholder="Search" type="search" name="search" id="search">
										<input class="sb-search-submit" type="submit" value="">
										<span class="sb-icon-search"> </span>
								<div id="list" style="width:318px;  border:1px solid gray; 
								background-color:white; position:fixed; z-index:1000;
								display:none;margin-top: 64px"  ></div>								
									</form>
								</div>
							</div>
							  <!-- search-scripts -->
									<script src="js/classie.js"></script>
									<script src="js/uisearch.js"></script>
										<script>
											new UISearch( document.getElementById( 'sb-search' ) );
										</script>
									<!-- //search-scripts -->
											 <!---->
											  <div class="col-md-4 player">
													
												<!---->
												<script type="text/javascript">
													$(function(){
													  $('#audio-player').mediaelementplayer({
														alwaysShowControls: true,
														features: ['playpause','progress','volume'],
														audioVolume: 'horizontal',
														iPadUseNativeControls: true,
														iPhoneUseNativeControls: true,
														AndroidUseNativeControls: true
													});
												 });
												</script>
												<!--audio-->
													<link rel="stylesheet" type="text/css" media="all" href="css/audio.css">
													<script type="text/javascript" src="js/mediaelement-and-player.min.js"></script>
													<!---->


												<!--//-->
												<ul class="next-top">
													<li><a class="ar" href="#"> </a></li>
													<li><a class="ar2" href="#"></a></li>
														
											 </ul>	
											</div>
											<div class="col-md-4 login-pop">
												<c:if test="${empty user }">
												<div id="loginpop">
													<a href="${pageContext.request.contextPath }/login2.jsp" id="loginButton1"  class="">
														<span>Login
															<i class="arrow glyphicon glyphicon-chevron-right"></i>
														</span>
													</a>
												</div> 
												<div id="loginpop">
													<a href="${pageContext.request.contextPath }/regist.html" id="loginButton2" class="">
														<span>Join Us 
															<i class="arrow glyphicon glyphicon-chevron-right"></i>
														</span>
													</a>
												</div>
												</c:if>
												<c:if test="${!empty user }">
														<div id="loginpop">
													<a href="/Godvoice/ShowListServlet?do=showMyCollection&usid=${user.usid }" id="loginButton3"  class="">
														<span>${user.uname }
															<i class="arrow glyphicon glyphicon-chevron-right"></i>
														</span>
													</a>
												</div> 
												<div id="loginpop">
													<a href="${pageContext.request.contextPath }/UserOutServlet" id="loginButton4" class="">
														<span>EXIT
															<i class="arrow glyphicon glyphicon-chevron-right"></i>
														</span>
													</a>
												</div>
												</c:if>
											</div>
										<div class="clearfix"> </div>
								</div>
							<!-------->
						</div>
					<div class="clearfix"></div>
				</div>
			</div>   
			      <!-- left side start-->
		
					<!-- app-->
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog facebook" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>						
						</div>
						<div class="modal-body">
							<div class="app-grids">
								<div class="app">
						<div class="col-md-5 app-left mpl">
							<h3>Mosaic mobile app on your smartphone!</h3>
							<p>Download and Avail Special Songs Videos and Audios.</p>
							<div class="app-devices">
								<h5>Gets the app from</h5>
								<a href="#"><img src="images/1.png" alt=""></a>
								<a href="#"><img src="images/2.png" alt=""></a>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div class="col-md-7 app-image">
							<img src="images/apps.png" alt="">
						</div>
						<div class="clearfix"></div>
					</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //app-->

		<!-- signup -->
			<div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-info">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>						
						</div>
						<div class="modal-body modal-spa">
							<div class="sign-grids">
								<div class="sign">
									
									<script type="text/javascript">
										
									</script>
									<div class="clearfix"></div>								
								</div>
								<p>By logging in you agree to our <span>Terms and Conditions</span> and <span>Privacy Policy</span></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //signup -->

		<!-- left side end-->
		<!-- main content start-->
		<div  style="padding-top: 20px">
			<!-- header-starts -->

			

			<!--notification menu end -->
			<!-- //header-ends -->

		<!-- //header-ends -->
			<div id="page-wrapper">
				<div class="inner-content">
				      
							<!--//music-left-->
						    <!--/music-right-->
						   
													 <!--//music-right-->
											<div class="clearfix"></div>
			
										</div>
				
						
								</div>
							<div class="clearfix"></div>
						<!--body wrapper end-->

					</div>
	
			     
  
    
      <!-- left side start-->
		<div class="left-side sticky-left-side" tabindex="5000" style="overflow: hidden; outline: none;">

			<!--logo and iconic logo start-->
			<div class="logo">
				<h1><a href="index.jsp">Mosai<span>c</span></a></h1>
			</div>
			<div class="logo-icon text-center">
				<a href="index.jsp">M </a>
			</div>

			<!--logo and iconic logo end-->
				<div class="left-side-inner">

				<!--sidebar nav start-->
					<ul class="nav nav-pills nav-stacked custom-nav">
						<li class="active"><a href="index.jsp"><i class="lnr lnr-home"></i><span>Home</span></a></li>
						<li><a href="radio.jsp"><i class="lnr lnr-users"></i> <span>Artists</span></a></li> 
						<li><a href="browse.jsp"><i class="lnr lnr-music-note"></i> <span>Albums</span></a></li>						
						
						<li class="menu-list"><a href="/Godvoice/ShowListServlet?do=showMyCollection&usid=${user.usid }"><i class="lnr lnr-heart"></i>  <span>My Favourities</span></a> 
							<ul class="sub-menu-list">
								<li><a href="/Godvoice/ShowListServlet?do=showMyCollection&usid=${user.usid }">All Songs</a></li>
							</ul>
						</li>
					</ul>
				<!--sidebar nav end-->
			</div>
		</div>
		<!-- left side end-->
					<!-- app-->
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog facebook" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>						
						</div>
						<div class="modal-body">
							<div class="app-grids">
								<div class="app">
						<div class="col-md-5 app-left mpl">
							<h3>Mosaic mobile app on your smartphone!</h3>
							<p>Download and Avail Special Songs Videos and Audios.</p>
							<div class="app-devices">
								<h5>Gets the app from</h5>
								<a href="#"><img src="images/1.png" alt=""></a>
								<a href="#"><img src="images/2.png" alt=""></a>
								<div class="clearfix"> </div>
							</div>
						</div>
						<div class="col-md-7 app-image">
							<img src="images/apps.png" alt="">
						</div>
						<div class="clearfix"></div>
					</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //app-->
		<!-- signup -->
			<div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-info">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>						
						</div>
						<div class="modal-body modal-spa">
							<div class="sign-grids">
								<div class="sign">
									
									
									<div class="clearfix"></div>								
								</div>
								<p>By logging in you agree to our <span>Terms and Conditions</span> and <span>Privacy Policy</span></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //signup -->

		<!-- main content start-->
		<div class="main-content" style="padding-top: 0px">
			<!-- header-starts -->
			
			<!--notification menu end -->
			<!-- //header-ends -->

		<!-- //header-ends -->
			<div id="page-wrapper">
				<div class="inner-content">
				      <div class="music-browse">
					<!--albums-->
					<!-- pop-up-box --> 
							<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all">
							<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
							 <script>
									$(document).ready(function() {
									$('.popup-with-zoom-anim').magnificPopup({
										type: 'inline',
										fixedContentPos: false,
										fixedBgPos: true,
										overflowY: 'auto',
										closeBtnInside: true,
										preloader: false,
										midClick: true,
										removalDelay: 300,
										mainClass: 'my-mfp-zoom-in'
									});
									});
							</script>		
					<!--//pop-up-box -->
						<div class="browse">
								<div class="tittle-head two">
									<h3 class="tittle">所有歌手 </h3>
									 <a href="browse.jsp"><h4 class="tittle third">See all</h4></a>
									<div class="clearfix"> </div>
								</div>
								<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
								  <ul id="myTab" class="nav nav-tabs" role="tablist">
								   <li role="presentation" class="dropdown">
									 <a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown" aria-controls="myTabDrop1-contents" aria-expanded="false">风格筛选 <span class="caret"></span></a>
										<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1" id="myTabDrop1-contents">
										  <li onclick="showSingers(this);" value="1"><a href="#" tabindex="-1" role="tab" id="dropdown1-tab" data-toggle="tab" aria-controls="dropdown1">&nbsp;&nbsp;大陆歌星</a></li>
										  <li onclick="showSingers(this);" value="2"><a href="#" tabindex="-1" role="tab" id="dropdown2-tab" data-toggle="tab" aria-controls="dropdown2">&nbsp;&nbsp;港台歌星</a></li>
										  <li onclick="showSingers(this);" value="3"><a href="#" tabindex="-1" role="tab" id="dropdown3-tab" data-toggle="tab" aria-controls="dropdown2">&nbsp;&nbsp;海外歌星</a></li>
										</ul>
								   </li>
								</ul>
								<div id="myTabContent" class="tab-content">
								<!-- 唯一的 -->
								  <div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">
									<div class="browse-inner">
								

									<c:forEach var="singer" items="${allsingers }">
											<div class="col-md-3 artist-grid" >
												<a  href="${pageContext.request.contextPath }/SingerServlet?singerid=${singer.sigid}&singername=${singer.signame}"><img src="${singer.picURL }" style="width: 217px; height: 242px"></a>
												<a class="art" href="${pageContext.request.contextPath }/SingerServlet?singerid=${singer.sigid}&singername=${singer.signame}">${singer.signame }</a>
											</div>
									</c:forEach>
									
											<div class="clearfix"> </div>
										</div>
										<div class="clearfix"> </div>
								  </div>

			
								</div>
							</div>
						
						</div>
					<!--//End-albums-->
							<!--//music-left-->
							</div>
						

					</div>
			  <!--body wrapper end-->
			      <div class="footer two">
				<div class="footer-grid">
					<h3>Navigation</h3>
					<ul class="list1">
					  <li><a href="index.jsp">Home</a></li>
					  <li><a href="radio.jsp">All Songs</a></li>
					  <li><a href="browse.jsp">Albums</a></li>
					  <li><a href="radio.jsp">New Collections</a></li>
					  <li><a href="blog.jsp">Blog</a></li>
					  <li><a href="contact.jsp">Contact</a></li>
				    </ul>
				</div>
				<div class="footer-grid">
					<h3>Our Account</h3>
				    <ul class="list1">
					  <li><a href="#" data-toggle="modal" data-target="#myModal5">Your Account</a></li>
					  <li><a href="#">Personal information</a></li>
					  <li><a href="#">Addresses</a></li>
					  <li><a href="#">Discount</a></li>
					  <li><a href="#">Orders history</a></li>
					  <li><a href="#">Addresses</a></li>
					  <li><a href="#">Search Terms</a></li>
				    </ul>
				</div>
				<div class="footer-grid">
					<h3>Our Support</h3>
					<ul class="list1">
					  <li><a href="contact.jsp">Site Map</a></li>
					  <li><a href="#">Search Terms</a></li>
					  <li><a href="#">Advanced Search</a></li>
					  <li><a href="#">Mobile</a></li>
					  <li><a href="contact.jsp">Contact Us</a></li>
					  <li><a href="#">Mobile</a></li>
					  <li><a href="#">Addresses</a></li>
				    </ul>
				  </div>
					  <div class="footer-grid">
						<h3>Newsletter</h3>
						<p class="footer_desc">Nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat</p>
						<div class="search_footer">
						 <form>
						   <input type="text" placeholder="Email...." required="">
						  <input type="submit" value="Submit">
						  </form>
						</div>
					 </div>
					 <div class="footer-grid footer-grid_last">
						<h3>About Us</h3>
						<p class="footer_desc">Diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat enim ad minim veniam,.</p>
						<p class="f_text">Phone:  &nbsp;&nbsp;&nbsp;00-250-2131</p>
						<p class="email">Email : &nbsp;<span><a href="mailto:mail@example.com">info(at)mailing.com</a></span></p>	
					 </div>
					 <div class="clearfix"> </div>
				</div>
			

      <!-- main content end-->
   </section>
  
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script><div id="ascrail2000" class="nicescroll-rails" style="width: 5px; z-index: 1000; background: rgb(68, 68, 68); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; display: none; opacity: 0;"><div style="position: relative; top: 0px; float: right; width: 5px; height: 0px; background-color: rgb(69, 179, 157); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 5px; z-index: 1000; background: rgb(68, 68, 68); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;"><div style="position: relative; top: 0px; height: 5px; width: 0px; background-color: rgb(69, 179, 157); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2001" class="nicescroll-rails" style="width: 3px; z-index: 100; background: rgb(68, 68, 68); cursor: default; position: fixed; top: 0px; left: 49px; height: 789px; display: none; opacity: 0;"><div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(69, 179, 157); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2001-hr" class="nicescroll-rails" style="height: 3px; z-index: 100; background: rgb(68, 68, 68); top: 786px; left: 0px; position: fixed; cursor: default; display: none; opacity: 0;"><div style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(69, 179, 157); border: 0px; background-clip: padding-box; border-radius: 10px; left: 0px;"></div></div>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>

</body></html>