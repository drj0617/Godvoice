<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html style="overflow: hidden;"><head>
<title>Godvoice - index</title>
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
<!-- //lined-icons -->
 <!-- Meters graphs -->
<script src="js/jquery-1.10.2.min.js"></script>


</head> 
   
 <body class="sticky-header left-side-collapsed" style="">

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
									});
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
														<span >${user.uname }
														
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
		<div class="left-side sticky-left-side" tabindex="5000" style="overflow: visible; outline: none;">

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
						<li class=""><a href="radio.jsp"><i class="lnr lnr-users"></i> <span>Artists</span></a></li> 
						<li class=""><a href="browse.jsp"><i class="lnr lnr-music-note"></i> <span>Albums</span></a></li>						
						
						
						<li class="menu-list"><a href="/Godvoice/ShowListServlet?do=showMyCollection&usid=${user.usid }"><i class="lnr lnr-heart"></i>  <span>My Favourities</span></a> 
							<ul class="sub-menu-list">
								<li><a href="/Godvoice/ShowListServlet?do=showMyCollection&usid=${user.usid }">All Songs</a></li>
							</ul>
						</li>
						   
					</ul>
				<!--sidebar nav end-->
			</div>
		</div>
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
		<div class="main-content" style="padding-top: 0px">


			

			<!--notification menu end -->

		<!-- //header-ends -->
			<div id="page-wrapper">
				<div class="inner-content">
				      <div class="music-left" style="width: 90%;padding-left: 150px">
					      <!--banner-section-->
							<div class="banner-section">
								<div class="banner">
									 <div class="callbacks_container">
										<ul class="rslides callbacks callbacks1" id="slider4">
											   	<li id="callbacks1_s0" class="" style="display: block; float: none; position: absolute; opacity: 0; z-index: 1; transition: opacity 500ms ease-in-out 0s;">
														<div class="banner-img">
															 <img src="images/11.jpg" class="img-responsive" alt="">
														 </div>
														<div class="banner-info">
																	  <h3>Let Your Home</h3>
																	  <p>Album by <span>Rock star</span></p>
														 </div>

												</li>
												<li id="callbacks1_s1" class="callbacks1_on" style="display: block; float: left; position: relative; opacity: 1; z-index: 2; transition: opacity 500ms ease-in-out 0s;">
													<div class="banner-img">
															 <img src="images/22.jpg" class="img-responsive" alt="">
														 </div>
														<div class="banner-info">
																	  <a class="trend" href="single.jsp">TRENDING</a>
																	  <h3>Charis Brown feet</h3>
																	  <p>Album by <span>Rock star</span></p>
														 </div>


												</li>
												<li id="callbacks1_s2" class="" style="display: block; float: none; position: absolute; opacity: 0; z-index: 1; transition: opacity 500ms ease-in-out 0s;">
												 <div class="banner-img">
															 <img src="images/33.jpg" class="img-responsive" alt="">
														 </div>
														<div class="banner-info"> 
														             <a class="trend" href="single.jsp">TRENDING</a>
																	  <h3>Let Your Home</h3>
																	  <p>Album by <span>Rock star</span></p>
														 </div>

												
												</li>
											</ul>
										</div>
										<!--banner-->
									<script src="js/responsiveslides.min.js"></script>
								 <script>
									// You can also use "$(window).load(function() {"
									$(function () {
									  // Slideshow 4
									  $("#slider4").responsiveSlides({
										auto: true,
										pager:true,
										nav:true,
										speed: 500,
										namespace: "callbacks",
										before: function () {
										  $('.events').append("<li>before event fired.</li>");
										},
										after: function () {
										  $('.events').append("<li>after event fired.</li>");
										  
										}
									  });
									  
									});
								  </script>
								<div class="clearfix"> </div>
							</div>
						</div>	
				<!--//End-banner-->
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
						
					<!--//End-albums-->
						<!--//discover-view-->
						
								<!--//discover-view-->
							</div>
							<!--//music-left-->
						    <!--/music-right-->
						   
													 <!--//music-right-->
											<div class="clearfix"></div>
			
										</div>
						<!--body wrapper start-->
						
								</div>
							<div class="clearfix"></div>
						<!--body wrapper end-->

					</div>
			  <!--body wrapper end-->
			     
			
        <!--footer section start-->
			
        <!--footer section end-->

      <!-- main content end-->    
   </section>
  
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script><div id="ascrail2000" class="nicescroll-rails" style="width: 5px; z-index: 1000; background: rgb(68, 68, 68); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0;"><div style="position: relative; top: 0px; float: right; width: 5px; height: 46px; background-color: rgb(69, 179, 157); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 5px; z-index: 1000; background: rgb(68, 68, 68); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;"><div style="position: relative; top: 0px; height: 5px; width: 1440px; background-color: rgb(69, 179, 157); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2000" class="nicescroll-rails" style="width: 5px; z-index: 1000; background: rgb(68, 68, 68); cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0;"><div style="position: relative; top: 0px; float: right; width: 5px; height: 207px; background-color: rgb(69, 179, 157); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div><div id="ascrail2000-hr" class="nicescroll-rails" style="height: 5px; z-index: 1000; background: rgb(68, 68, 68); position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;"><div style="position: relative; top: 0px; height: 5px; width: 1440px; background-color: rgb(69, 179, 157); border: 0px; background-clip: padding-box; border-radius: 10px;"></div></div>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>




</body></html>


