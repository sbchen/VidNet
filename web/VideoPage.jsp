<%-- 
    Document   : VideoPage
    Created on : Apr 26, 2012, 3:45:41 AM
    Author     : Moy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.LinkedList"%>
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
   <li><a href="VideoGalleryServlet">Video Gallery</a></li>
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
On: ${videoInfo.getDate()}
</div>

<div id="vidContainer">
<video width="640" height="480" controls="controls">
    <source src="${videoInfo.getPath()}" type="video/mp4" />
    Your browser does not support HTML 5
</video>
</div>
    
    <br />
    <br />
    
<div id="vidDescContainer">
    <h2>Description: </h2>
    <p>${videoInfo.getDesc()}</p>
</div>

<div id="vidCommentContainer">
    <form action="SendCommentServlet" method="post">
        <textarea name="com" rows="3" cols="45"></textarea>
        <input type="hidden" name="vidID" value="${videoInfo.getVideoID()}"/>
        <br />
        <input type="submit" value="Comment!" />
    </form>
        
    <br />
    <br />
    
    <h2>Comments: </h2>
    <table>
        <%
        if (session.getAttribute("vidComList") == null || ((LinkedList)session.getAttribute("vidComList")).isEmpty()) {
            %>
            <tr>
                <td>
                    No Comments!
                </td>
            </tr>
            <%
        } else {
        %>
        <tr>
            <td>From   </td>
            <td>Content</td>
            <td>Posted</td>
        </tr>
        <c:forEach var="com" items="${vidComList}">
            <tr>
                <td>${com.getUsername()}</td>
                <td>${com.getContent()}</td>
                <td>${com.getPosted()}</td>
            </tr>
        </c:forEach>
        <%
        }
        %>
    </table>
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