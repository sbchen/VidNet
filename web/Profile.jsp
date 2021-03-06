<%-- 
    Document   : About
    Created on : Apr 13, 2012, 4:03:14 AM
    Author     : Moy
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.vidnet.db.UserModel, java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Profile</title>
</head>

<body>


<%String username = (String) session.getAttribute("username"); %>
<%String email = (String) session.getAttribute("email"); %>
<%UserModel userModel = new UserModel(); %>

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

<h1>Welcome <%=username%>!</h1>
<br/>

<table>
    <tr>
        
        <td>
            Upload Video
            <br />
            <br />

            <form action="VidUploadServlet" method="post" enctype="multipart/form-data">
                <div id="upload-input-name">Title: </div><div id="upload-input-field"><input type="text" name="title" class="text" size="25" /></div>
                <div id="upload-input-areaname">Description: </div><div id="upload-input-area"><textarea name="desc" rows="4"></textarea></div>
                <br />

                <input type="file" accept="video/mp4" name="vidFile" />
                <br />
                <br />
                <input type="submit" value="Upload!" />
            </form>
        </td>
        
        <td>
            Send Messages
            <br />
            <br />
            
            <form action="SendMsgServlet" method="post">
<!--                <div id="msg-input-name">Send to Username: </div><div id="msg-input-field"><input type="text" name="recUsername" class="text" size="25" /></div>-->
                <div id="msg-input-name">Send to Username: </div>
                <select name="recUsername" id="msg-select">
                    <option value="">--Select a User--</option>
                    <c:forEach var="item" items="${userList}">
                        <option>${item.getUsername()}</option>
                    </c:forEach>
                </select>
                <div id="msg-input-areaname">Message: </div><div id="msg-input-area"><textarea name="msg" rows="4"></textarea></div>
                <br />
                <input type="submit" value="Message!" />
            </form>
        </td>
    </tr>
</table>
<br />

<h1>Messages</h1>
<!--iterate through list of messages-->

<table>
    <%
    if (session.getAttribute("userMsgList") == null || ((LinkedList)session.getAttribute("userMsgList")).isEmpty()) {
        %>
        <tr>
            <td>
                No Messages!
            </td>
        </tr>
        <%
    } else {
    %>
    <tr>
        <td>From   </td>
        <td>Content</td>
    </tr>
    <c:forEach var="msg" items="${userMsgList}">
        <tr>
            <td>${msg.getUsername()}</td>
            <td>${msg.getMsg()}</td>
        </tr>
    </c:forEach>
    <%
    }
    %>
</table>

<br />
<h1>Videos</h1>

<!--iterate through list of videos-->
<table>
    <%
    if (session.getAttribute("userVidList") == null || ((LinkedList)session.getAttribute("userVidList")).isEmpty()) {
        %>
        <tr>
            <td>
                No Videos!
            </td>
        </tr>
        <%
    } else {
    %>
    <c:forEach var="vid" items="${userVidList}">
        <tr>
            <td>
                <h2>${vid.getTitle()}</h2>
                ${vid.getPosted()}
                <div id="userVideo">
                    <a href='VideoServlet?videoid=${vid.getVideoID()}' title="${vid.getTitle()}"  class="group" rel="group">
                        <video width="320" height="240" controls="controls">
                            <source src="${vid.getLocation()}" type="video/mp4" />
                            Your browser does not support HTML5
                        </video>
                    </a>
                </div>
                ${vid.getDescription()}
            </td>
<!--            <td>
                <a href="VideoServlet?videoid=${vid.getVideoID()}">Watch Now!</a>
            </td>-->
        </tr>
    </c:forEach>
    <%
    }
    %>
</table>
<br />
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