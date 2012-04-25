<%-- 
    Document   : About
    Created on : Apr 13, 2012, 4:03:14 AM
    Author     : Moy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" />
<title>About</title>
</head>

<body>


<%String username = (String) session.getAttribute("username"); %>
<%String email = (String) session.getAttribute("email"); %>

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

<h1><%=username%>'s Page</h1>

<h2>Welcome <%=username%>!</h2>
<br/>

Select video to upload:
<br />
<br />

<form action="VidUploadServlet" method="post" enctype="multipart/form-data">
    <div id="upload-input-name">Title: </div><div id="upload-input-field"><input type="text" name="title" class="text" size="25"/></div>
    <div id="upload-input-areaname">Description: </div><div id="upload-input-area"><textarea name="desc" rows="4"></textarea></div>
    <br />
    
    <input type="file" accept="video/mp4" name="vidFile" />
    <br />
    <br />
    <input type="submit" value="Upload!" />
</form>
<br />

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