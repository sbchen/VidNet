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
  <a href="index.html"><img src="images/logo.png" width="136" height="30" alt="logo" /></a>
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


<div id="header" style="margin-top:4px">


<!-- tab panes -->
<div id="panes">

<div>
<img src="images/1.jpg" alt="VidNet" />				
<h3>Welcome to VidNet</h3>
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

</div><!-- close navigator -->


<br clear="all" />


</div><!-- close header -->


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
