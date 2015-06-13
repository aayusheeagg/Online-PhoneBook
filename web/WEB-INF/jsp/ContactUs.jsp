
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Us</title>
        <link rel="icon" type="image/ico" href="images/logo.png"/>
        <link href="styles/mystyle.css" rel="stylesheet" type="text/css" />
        
        <script type="text/javascript" src="https://apis.google.com/js/plusone.js">
	{"parsetags": "explicit"}
</script> <!--
<script type="text/javascript">
    
	function renderPlusone() {
		gapi.plusone.render("plusone-div", {"size": "medium", "annotation": "inline", "href": "http://www.voicent.com" });
	}
	
	function renderInRecommend() {
		var parent = document.getElementById('inrecdiv');
		var child = document.getElementById('inrecimg');
		parent.removeChild(child);
		
		var e = document.createElement('script');
		e.type="text/javascript";
		e.src = 'http://platform.linkedin.com/in.js';
		document.getElementsByTagName('head')[0].appendChild(e);
	}
	
	function renderFbLike() {
		var parent = document.getElementById('fblikediv');
		var child = document.getElementById('fblikeimg');
		parent.removeChild(child);
		
		var html2 = "<iframe src=\"http://www.facebook.com/plugins/like.php?href=http%3A%2F%2Fwww.facebook.com%2FVoicent&send=false&layout=standard&width=450&show_faces=false&action=like&colorscheme=light&font&height=60&appId=258346014244946\" scrolling=\"no\" frameborder=\"0\" style=\"border:none; overflow:hidden; width:450px; height:40px;\" allowTransparency=\"true\"></iframe>";
    		document.getElementById('fblikediv').innerHTML = html2;
	}
</script>
-->
    </head>
    <body>     
    
            <div id="page">
            <img src="images/logo.png" style="height: 150px; width:100px; margin-left: 10px; "/>           
            <br>            
            <h2>Total Visitors : ${applicationScope["visitor"]}</h2>
            <h2>Online Users :  ${applicationScope["online"]}</h2>
            <br><br><br><br><br><br>
            <h4> Follow us on Facebook :<br/><img src="images/facebook.jpeg" height="40px" width="35px" /></h4>
            
            <div id="fblikediv"><img src="images/fb-like-button.png" id="fblikeimg" onMouseOver="return renderFbLike();"></div>
<p/>
<div id="inrecdiv"><img src="images/in-recommend-button.png" id="inrecimg" onMouseOver="renderInRecommend();"><script type="IN/RecommendProduct" data-company="480490" data-product="335985" data-counter="right"></script></div>
<p/>
<div id="plusone-div"><img src="images/gplus-button.png" onMouseOver="renderPlusone();"></div>
<p/>
        </div>
     
        
    </body>
</html>
