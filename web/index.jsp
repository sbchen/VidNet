<%-- 
    Document   : index
    Created on : Apr 7, 2012, 3:47:30 PM
    Author     : SC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" />
<title>VidNet Home</title>

<script src="js/jquery.tools.min.js" type="text/javascript"></script>
    
<script type="text/javascript">
    $(function() {
	$("#nav ul").tabs("#panes > div", {effect: 'fade', fadeOutSpeed: 400});
});
</script>

<script type="text/javascript">
        $(document).ready(function(){
        $(".pane-list li").click(function(){
    	window.location=$(this).find("a").attr("href");return false;
	});

}); //close doc ready
</script>

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
   <li><a href="VideoGallery.jsp">Video Gallery</a></li>
   <li><a href="sign-up.jsp">Sign Up</a></li>
   <li><a href="index.jsp">Home</a></li>
   
</ul>
</div><!-- close h_navcontainer -->


<div id="header" style="margin-top:4px">


<!-- tab panes -->
<div id="panes">
    
<div>
<img src="images/VideoSharing.png" alt="VidNet" />				
<h3>Welcome to VidNet</h3>
<P>VidNet offers a user friendly online video streaming environment, where user driven content comprises the bulk of the videos, is easily accessible, visible and obtainable from anywhere with Internet access.</p>
<p>VidNet strives to deliver the highest quality video resolution with no interruption in service or annoying ads. With VidNet, you can save and share your videos with family and friends.</p>
<p>As a user, you will have access to share videos, comment on friend videos, and send messages to your friends</p>
<p class="more"> </p>
		
<p> </p>

</div>

	
<div>
<img src="images/defaultuser.jpg" width="300" height="225" alt="VidNet" />	
<h3>User1</h3>
<p class="more">About User</p>
		
<p>User Info</p>		
</div>
	
<div>   
<img src="images/defaultuser.jpg" width="300" height="225" alt="VidNet" />
<h3>User2</h3>
<p class="more">About User</p>
		
<p>User Info</p>		
</div>

<div>   
<img src="images/defaultuser.jpg" width="300" height="225" alt="VidNet" />
<h3>User3</h3>
<p class="more">About User</p>
		
<p>User Info</p>		
</div>

<div>   
<img src="images/defaultuser.jpg" width="300" height="225" alt="VidNet" />
<h3>User4</h3>
<p class="more">About User</p>
		
<p>User Info</p>
</div>

</div><!-- close tab panes -->

<br clear="all" />

<!-- navigator -->
<div id="nav">
<ul>

<li><a href="#1"><img src="images/defaultuser.jpg" width="75" height="75" alt="VidNet"/><strong>VidNet</strong>
January 10th 2010</a></li>

<li><a href="#2"><img src="images/defaultuser.jpg" width="75" height="75" alt="VidNet"/><strong>User1</strong> January 5th 2009</a>
</li>

<li><a href="#3"><img src="images/defaultuser.jpg" width="75" height="75" alt="VidNet" /><strong>User2</strong> January 7th 2010</a>
</li>

<li><a href="#4"><img src="images/defaultuser.jpg" width="75" height="75" alt="VidNet" /><strong>User3</strong> January 8th 2012</a>
</li>

<li><a href="#5"><img src="images/defaultuser.jpg" width="75" height="75" alt="VidNet" /><strong>User4</strong> January 9th 2011</a>
</li>

</ul>

</div> close navigator 


<br clear="all" />


</div><!-- close header -->


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
