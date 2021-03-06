<%-- 
    Document   : VideoGallery
    Created on : Apr 13, 2012, 4:02:14 AM
    Author     : Moy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
   <li><a href="VideoGalleryServlet">Video Gallery</a></li>
   <li><a href="sign-up.jsp">Sign Up</a></li>
   <li><a href="index.jsp">Home</a></li>
</div><!-- close h_navcontainer -->

<div id="page_top"></div>

<div id="page">

<h1>Gallery</h1>

<form name="SearchBox" action="TagSearchServlet" method="post">
  <table width="400" border="1" cellpadding="5">
    <tr>
      <td>
        <input type="hidden" name="view" value="grid">
        Search Videos:<input type="text" name="tag" size="30" maxlength="50"><input type="submit" value="Search">
      </td>
    </tr>
  </table>
</form>
<p></p>
<p></p>
<div id="gallery">
    <c:forEach var="vid" items="${gallVidList}">
        <div class="float_left_thumb">
            <a href='VideoServlet?videoid=${vid.getVideoID()}' title="${vid.getTitle()}"  class="group" rel="group">
                <video width="140" height="140" controls="controls">
                    <source src="${vid.getLocation()}" type="video/mp4" />
                    Your browser does not support HTML5
                </video>
            </a>
        </div>
    </c:forEach>
<!--    <div class="float_left_thumb"><a href='photos/1.jpg' title="Old Tree"  class="group" rel="group">
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
                -->
    <!--    <a href="VideoPage.jsp">Video page link</a>-->
</div><!-- close gallery -->

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
