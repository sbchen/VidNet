<%-- 
    Document   : Login
    Created on : Apr 13, 2012, 6:27:17 AM
    Author     : Moy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style2.css" />
<title></title>


</head>

<body>

<div id="container">

<div id="logo">
  <a href="index.jsp"><img src="images/logo.png" width="136" height="30" alt="logo" /></a>
</div>

<div id="h_navcontainer">
<ul>
   <li><a href="Login.jsp">Login</a></li>
   <li><a href="About.jsp">User Page</a></li>
   <li><a href="VideoGallery.jsp">Video Gallery</a></li>
   <li><a href="sign-up.jsp">Sign Up</a></li>
   <li><a href="index.jsp">Home</a></li>
</ul>
</div><!-- close h_navcontainer -->

<div id="page_top"></div>

<div id="page">

<h1>Sign Up</h1>

<div id="signup_info">
<h2 style="margin-bottom:10px"> VidNet </h2>
<p>Some VidNet Info</p>
</div>

<!-- twitter style notification bar for validation errors -->


<!-- the form -->
<form action='#'>
<div style="padding: 100px 0 0 250px;">


<div id="login-box">

<H2>Login to VidNet</H2>
<br />
<br />
<div id="login-box-name" style="margin-top:20px;">Email:</div><div id="login-box-field" style="margin-top:20px;"><input name="q" class="form-login" title="Username" value="" size="30" maxlength="2048" /></div>
<div id="login-box-name">Password:</div><div id="login-box-field"><input name="q" type="password" class="form-login" title="Password" value="" size="30" maxlength="2048" /></div>
<br />
<span class="login-box-options"><input type="checkbox" name="1" value="1"> Remember Me <a href="#" style="margin-left:30px;">Forgot password?</a></span>
<br />
<br />
<a href="#"><img src="images/login-btn.png" width="103" height="42" style="margin-left:90px;" /></a>

</div>

</div>
</form>


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