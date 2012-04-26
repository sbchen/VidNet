<%-- 
    Document   : VideoPage
    Created on : Apr 26, 2012, 3:45:41 AM
    Author     : Moy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Video</title>
</head>

<body>

<div id="container">

<div id="logo">
  <a href="index.html"><img src="images/logo.png" width="136" height="30" alt="logo" /></a>
</div>

<div id="h_navcontainer">
<ul>
   <%
        if (request.getSession(false) != null) {
            session = request.getSession();
            if (session.getAttribute("username") == null || session.getAttribute("username").equals("")) {
            %>
                <li><a href="Login.jsp">Login </a></li>
            <%
            } else {
            %>
                <li><a href="LogoutServlet">Logout </a></li>
            <%   
            }
        } else {
        %>
            <li><a href="Login.jsp">Login </a></li>
        <%
        }
   %>
   <li><a href="Profile.jsp">Profile</a></li>
   <li><a href="VideoGallery.jsp">Video Gallery</a></li>
   <li><a href="sign-up.jsp">Sign Up</a></li>
   <li><a href="index.jsp">Home</a></li>
</ul>
</div><!-- close h_navcontainer -->

<div id="page_top"></div>

<div id="page">

<h1>${videoInfo.getTitle()}</h1>
<br />

<div id="vidTitle">
<h2>Uploaded by: ${videoInfo.getUsername()}</h2>
<h2>${videoInfo.getDate()}</h2>
</div>

<div id="vidContainer">
<video width="640" height="480" controls="controls">
    <source src="${videoInfo.getPath()}" type="video/mp4" />
    Your browser does not support HTML 5
</video>
</div>

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
			<li class="footer_heading"><a href="#"><h4>About Us</h4></a></li>
                </ul>
                <ul>
                <li class="footer_heading"><a href="#"><h4>Services</h4></a></li>
                </ul>
                
 </div>
     
 <div id="footer_right">
  <ul>
    <li class="footer_heading"><a href="#"><h4>Contact Us</h4></a></li>
  </ul>
        
 </div>

</div><!-- close footer_bg -->
</div><!-- close footer -->


</body>
</html>