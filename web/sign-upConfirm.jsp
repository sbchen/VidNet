<%-- 
    Document   : sign-upConfirm
    Created on : Apr 19, 2012, 5:12:28 PM
    Author     : Moises
--%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
<title>About</title>
</head>

<body>

    <!--
<%--
String Name = request.getParameter(username);
String Email = request.getParameter(email);
String Password = request.getParameter(password);
String PasswordV = request.getParameter(passwordV);
String Address = request.getParameter(Address);
--%>
-->
<div id="container">

<div id="logo">
  <a href="index.html"><img src="images/logo.png" width="136" height="30" alt="logo" /></a>
</div>

<div id="h_navcontainer">
<ul>
   <!--<li><a href="Login.jsp">Login</a></li>-->
   <li><a href="About.jsp">User Page</a></li>
   <li><a href="VideoGallery.jsp">Video Gallery</a></li>
   <li><a href="sign-up.jsp">Sign Up</a></li>
   <li><a href="index.jsp">Home</a></li>
</ul>
</div><!-- close h_navcontainer -->

<div id="page_top"></div>

<div id="page">

<h1>User's Page</h1>

<h2>User's Name</h2>
<p></p>
<h2>Messages</h2>
<p></p>
<h2>Videos</h2>
<p></p>
<div style="clear:both"></div>
</div><!-- close page -->

<div id="page_bottom"></div>

</div><!-- close container -->


<div id="footer_bg">
<div id="footer">

<div id="footer_left">
		
                <ul>
			<li class="footer_heading"><a href="index.jsp"><h4>Home</h4></a></li>
                </ul>
                <ul>
			<li class="footer_heading"><a href="About.jsp"><h4>About Us</h4></a></li>
                </ul>
                <ul>
                <li class="footer_heading"><a href="#"><h4>Services</h4></a></li>
                </ul>
                
 </div>
     
 <div id="footer_right">
  <ul>
    <li class="footer_heading"><a href="About.jsp"><h4>Contact Us</h4></a></li>
  </ul>
        
 </div>

</div><!-- close footer_bg -->
</div><!-- close footer -->


</body>
</html>