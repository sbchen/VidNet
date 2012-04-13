<%-- 
    Document   : VideoGallery
    Created on : Apr 13, 2012, 4:02:14 AM
    Author     : Moy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Video Gallery</title>

<script src="js/jquery.tools.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>


    <link rel="stylesheet" type="text/css" href="js/fancybox/jquery.fancybox.css" media="screen" />
    <script type="text/javascript" src="js/fancybox/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="js/fancybox/jquery.fancybox-1.2.1.js"></script>

     <script type="text/javascript">
		$(document).ready(function() {
			$("a.group").fancybox();
		});
      </script>


</head>

<body>

<div id="container">

<div id="logo">
  <a href="index.html"><img src="images/logo.png" width="136" height="30" alt="logo" /></a>
</div>

<div id="h_navcontainer">
<ul>
   <li><a href="Login.jsp">Login</a></li>
   <li><a href="About.jsp">User Page</a></li>
   <li><a href="VideoGallery.jsp">Video Gallery</a></li>
   <li><a href="sign-up.jsp">Sign Up</a></li>
   <li><a href="index.jsp">Home</a></li>
</div><!-- close h_navcontainer -->

<div id="page_top"></div>

<div id="page">

<h1>Gallery</h1>

<div id="gallery">
	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>
                                   	<div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
				                   <img src="photos/tb_1.jpg" alt="demo" /></a></div>                            
</div><!-- close gallery -->

<div style="clear:both"></div>
</div><!-- close page -->

<div id="page_bottom"></div>


</div><!-- close container -->


<div id="footer_bg">
<div id="footer">

<div id="footer_left">
		<ul>
			<li class="footer_heading"><h4>General</h4></li>
                </ul>
                <ul>
			<li><a href="index.jsp">Home</a></li>
                </ul>
			<li><a href="About.jsp">About Us</a></li>
                <ul>
			<li><a href="#">Services</a></li>
                </ul>
                <ul>
			<li><a href="About.jsp">Contact Us</a></li>
		</ul>
		
                        <!--
		<ul>
			<li class="footer_heading"><h4>Services</h4></li>
			<li><a href="#">Photography</a></li>
			<li><a href="#">Print</a></li>
			<li><a href="#">Design</a></li>
			<li><a href="#">Retouch</a></li>
		</ul>
		
		<ul>
			<li class="footer_heading"><h4>Upcoming</h4></li>
			<li><a href="#">New Offers</a></li>
			<li><a href="#">Free Stock Photos</a></li>
			<li><a href="#">Studio Lightning</a></li>
			<li class="last"><a href="#">New from Canon</a></li>
		</ul>
                        -->
 </div>
        
 <div id="footer_right">
 
 <ul>
   <li><img src="photos/footer_thumb1.jpg" width="60" height="60" alt="demo" /></li>
   <li><img src="photos/footer_thumb2.jpg" width="60" height="60" alt="demo" /></li>
   <li><img src="photos/footer_thumb3.jpg" width="60" height="60" alt="demo" /></li>
   <li><img src="photos/footer_thumb1.jpg" width="60" height="60" alt="demo" /></li>
 </ul>
 
  <ul>
   <li><img src="photos/footer_thumb3.jpg" width="60" height="60" alt="demo" /></li>
   <li><img src="photos/footer_thumb1.jpg" width="60" height="60" alt="demo" /></li>
   <li><img src="photos/footer_thumb2.jpg" width="60" height="60" alt="demo" /></li>
   <li><img src="photos/footer_thumb1.jpg" width="60" height="60" alt="demo" /></li>
 </ul>

 </div>

</div><!-- close footer_bg -->
</div><!-- close footer -->


</body>
</html>
