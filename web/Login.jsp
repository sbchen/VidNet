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
<link rel="stylesheet" type="text/css" href="style.css" />
<title></title>

</head>

<body>

<div id="container">

<div id="logo">
  <a href="index.jsp"><img src="images/logo.png" width="136" height="30" alt="logo" /></a>
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

<h1>Login</h1>

<div id="signup_info">
<h2 style="margin-bottom:10px"> Welcome to VidNet </h2>
<p>Please Log in to your account.</p>
<p>Are you new to VidNet? Join Vidnet and create an account for free.</p>
<p>Create new VidNet User <a href="sign-up.jsp"> here</a>.</p>

</div>

<!-- twitter style notification bar for validation errors -->


<!-- the form -->
<form action="login" method="post">
<div style="padding: 100px 0 0 250px;">


<div id="login-box">

<H2>Login to VidNet</H2>
<br />
<br />
<div id="login-box-name" style="margin-top:20px;">Email:</div><div id="login-box-field" style="margin-top:20px;"><input name="email" class="form-login" title="Username" value="" size="30" maxlength="2048" /></div>
<div id="login-box-name">Password:</div><div id="login-box-field"><input name="pass" type="password" class="form-login" title="Password" value="" size="30" maxlength="2048" /></div>
<br />
<span class="login-box-options"><input type="checkbox" name="1" value="1"> Remember Me <a href="#" style="margin-left:30px;">Forgot password?</a></span>
<br />
<br />
<input id="login-btn" type="submit">

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