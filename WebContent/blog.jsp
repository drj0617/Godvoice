<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Godvoice - Blogs</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
 <!-- Meters graphs -->
<script src="js/jquery-1.10.2.min.js"></script>

</head> 
   
 <body class="sticky-header left-side-collapsed"  >
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
		<div class="left-side sticky-left-side">

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
						
						<li><a href="blog.jsp"><i class="lnr lnr-book"></i><span>Blog</span></a></li>
						<li><a href="typography.jsp"><i class="lnr lnr-pencil"></i> <span>Typography</span></a></li>
						<li class="menu-list"><a href="/Godvoice/ShowListServlet?do=showMyCollection&usid=${user.usid }"><i class="lnr lnr-heart"></i>  <span>My Favourities</span></a> 
							<ul class="sub-menu-list">
								<li><a href="/Godvoice/ShowListServlet?do=showMyCollection&usid=${user.usid }">All Songs</a></li>
							</ul>
						</li>
						<li class="menu-list"><a href="contact.jsp"><i class="fa fa-thumb-tack"></i><span>Contact</span></a>
							<ul class="sub-menu-list">
								<li><a href="contact.jsp">Location</a> </li>
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
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
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
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
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
							<div id="page-wrapper">
								<div class="inner-content">
									<!-- /blog -->
										<div class="tittle-head">
											<h3 class="tittle">Our Blogs </h3>
											<div class="clearfix"> </div>
										</div>
										<!-- /music-left -->
										<div class="music-left">
											<div class="post-media">
												  <a href="single.jsp"><img src="images/33.jpg" class="img-responsive" alt="" /></a>
												  <div class="blog-text">
														<a href="single.jsp"><h3 class="h-t">Lorem Ipsum is simply dummy text</h3></a>
												      <div class="entry-meta">
															<h6 class="blg"><i class="fa fa-clock-o"></i> Jan 25, 2016</h6>
															<div class="icons">
																<a href="#"><i class="fa fa-user"></i> Admin</a>
																<a href="#"><i class="fa fa-comments-o"></i> 2</a>
																<a href="#"><i class="fa fa-thumbs-o-up"></i> 152</a>
																<a href="#"><i class="fa fa-thumbs-o-down"></i>  26</a>
															</div>
																<div class="clearfix"></div>
															<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Non semper, inquam; Quo modo autem philosophus loquitur? Duo Reges: constructio interrete. Dici enim nihil potest verius. Hic ambiguo ludimur. An hoc usque quaque, aliter in vita? Bonum incolumis acies: misera caecitas. Favorite</p>
													  </div>
												  </div>
											</div>
											<div class="post-media second">
												  <a href="single.jsp"><img src="images/11.jpg" class="img-responsive" alt="" /></a>
												  <div class="blog-text">
														<a href="single.jsp"><h3 class="h-t">Lorem Ipsum is simply dummy text</h3></a>
												      <div class="entry-meta">
															<h6 class="blg"><i class="fa fa-clock-o"></i> Feb 13, 2016</h6>
															<div class="icons">
																<a href="#"><i class="fa fa-user"></i> Admin</a>
																<a href="#"><i class="fa fa-comments-o"></i> 2</a>
																<a href="#"><i class="fa fa-thumbs-o-up"></i> 152</a>
																<a href="#"><i class="fa fa-thumbs-o-down"></i>  26</a>
															</div>
																<div class="clearfix"></div>
															<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Non semper, inquam; Quo modo autem philosophus loquitur? Duo Reges: constructio interrete. Dici enim nihil potest verius. Hic ambiguo ludimur. An hoc usque quaque, aliter in vita? Bonum incolumis acies: misera caecitas. Favorite</p>
													  </div>
												  </div>
											</div>
											<div class="post-media">
												  <a href="single.jsp"><img src="images/22.jpg" class="img-responsive" alt="" /></a>
												  <div class="blog-text">
														<a href="single.jsp"><h3 class="h-t">Lorem Ipsum is simply dummy text</h3></a>
												      <div class="entry-meta">
															<h6 class="blg"><i class="fa fa-clock-o"></i> Mach 30, 2016</h6>
															<div class="icons">
																<a href="#"><i class="fa fa-user"></i> Admin</a>
																<a href="#"><i class="fa fa-comments-o"></i> 2</a>
																<a href="#"><i class="fa fa-thumbs-o-up"></i> 152</a>
																<a href="#"><i class="fa fa-thumbs-o-down"></i>  26</a>
															</div>
																<div class="clearfix"></div>
															<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Non semper, inquam; Quo modo autem philosophus loquitur? Duo Reges: constructio interrete. Dici enim nihil potest verius. Hic ambiguo ludimur. An hoc usque quaque, aliter in vita? Bonum incolumis acies: misera caecitas. Favorite</p>
													  </div>
												  </div>
											</div>
											<!--start-blog-pagenate-->
												<div class="blog-pagenat">
													<ul>
														<li><a class="frist" href="#">Prev</a></li>
														<li><a href="#">1</a></li>
														<li><a href="#">2</a></li>
														<li><a href="#">3</a></li>
														<li><a href="#">4</a></li>
														<li><a href="#">5</a></li>
														<li><a class="last" href="#">Next</a></li>
														<div class="clearfix"> </div>
													</ul>
												</div>
												<!--//end-blog-pagenate-->

										</div>
										<!-- //music-left-->
										<!-- /music-right-->
										<div class="music-right">
											<!-- //widget -->
											  <div class="widget-side">
												<h4 class="widget-title">Recent Posts</h4>
													<ul>
														<li>
															<a href="single.jsp">Taylor Swift – Shake It Off</a>
															<span class="post-date">Feb 13, 2016</span>
														</li>
														<li>
															<a href="single.jsp">Love Me Like You Do – Ellie Goulding (Fifty Shades of Grey Soundtrack) HQ</a>
															<span class="post-date">Feb 14, 2016</span>
														</li>
														<li>
															<a href="single.jsp">Jessie J – Flashlight (from Pitch Perfect 2)</a>
															<span class="post-date">Feb 16, 2016</span>
														</li>
														<li>
															<a href="single.jsp">Sol – “Ain’t Gon’ Stop”</a>
															<span class="post-date">Feb 18, 2016</span>
														</li>
														<li>
															<a href="single.jsp">Eminem – No Love (Explicit Version) ft. Lil Wayne</a>
															<span class="post-date">Feb 19, 2016</span>
														</li>
													</ul>
												 </div>
												 <div class="widget-side second">
												<h4 class="widget-title">Top Songs</h4>
													<ul>
														<li>
															<div class="song-img">
															  <a href="single.jsp"><img src="images/play1.png" class="img-responsive" alt="" /></a>
															</div>
															<div class="song-text">
																<a href="single.jsp">Ellie-Goulding</a>
																<span class="post-date">Feb 13, 2016</span>
															</div>
															<div class="clearfix"></div>
														</li>
														<li>
															<div class="song-img">
															  <a href="single.jsp"><img src="images/play2.png" class="img-responsive" alt="" /></a>
															</div>
															<div class="song-text">
																<a href="single.jsp">Mark-Ronson-Uptown</a>
																<span class="post-date">Feb 14, 2016</span>
															</div>
															<div class="clearfix"></div>
														</li>
														<li>
															<div class="song-img">
															  <a href="single.jsp"><img src="images/play4.png" class="img-responsive" alt="" /></a>
															</div>
															<div class="song-text">
																<a href="single.jsp">Pharrell-Williams</a>
																<span class="post-date">Feb 16, 2016</span>
															</div>
															<div class="clearfix"></div>
														</li>
														<li>
															<div class="song-img">
															  <a href="single.jsp"><img src="images/play5.png" class="img-responsive" alt="" /></a>
															</div>
															<div class="song-text">
																<a href="single.jsp">Taylor Swift – Shake It Off</a>
																<span class="post-date">Feb 18, 2016</span>
															</div>
															<div class="clearfix"></div>
														</li>
														
													</ul>
												 </div>
											  <!-- //widget -->
										</div>
										<div class="clearfix"></div>
									<!-- //blog -->
								</div>
							<div class="clearfix"></div>
						<!--body wrapper end-->

					</div>
			  <!--body wrapper end-->
			       <div class="footer two">
				<div class="footer-grid">
					<h3>Navigation</h3>
					<ul class="list1">
					  <li><a href="index.jsp">Home</a></li>
					  <li><a href="single.jsp">All Songs</a></li>
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
			</div>

      <!-- main content end-->
   </section>
  
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
</body>
</html>