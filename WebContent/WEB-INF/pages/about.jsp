<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>兔小白个人博客</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/sliders.js"></script>
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<!-- 返回顶部调用 begin -->
<script type="text/javascript" src="js/up/jquery.js"></script>
<script type="text/javascript" src="js/up/js.js"></script>
<!-- 返回顶部调用 end-->
</head>
<body>
	<header>
	<div class="logo f_l">
		<a href="/"><img src="images/logo.png"></a>
	</div>
	<nav id="topnav" class="f_r">
	<ul>
		<a href="index" target="_blank">首页</a>
		<a href="about" target="_blank">关于我</a>
		<a href="post" target="_blank">文章</a>
		<a href="feels" target="_blank">心情</a>
		<a href="photolist" target="_blank">相册</a>
		<a href="words" target="_blank">留言</a>
	</ul>
	<script src="js/nav.js"></script> </nav> </header>
	<article>
	<div class="l_box f_l">
		
	</div>
	<div class="r_box f_r">
		<div class="tit01">
			<h3>关注我</h3>
			<div class="gzwm">
				<ul>
					<li><a class="xlwb" href="#" target="_blank">新浪微博</a></li>
					<li><a class="txwb" href="#" target="_blank">腾讯微博</a></li>
					<li><a class="rss" href="portal.php?mod=rss" target="_blank">RSS</a></li>
					<li><a class="wx" href="mailto:admin@admin.com">邮箱</a></li>
				</ul>
			</div>
		</div>
		<!--tit01 end-->
		<div class="ad300x100">
			<img src="/images/ad300x100.jpg">
		</div>
		<div class="moreSelect" id="lp_right_select">
			<script>
window.onload = function ()
{
	var oLi = document.getElementById("tab").getElementsByTagName("li");
	var oUl = document.getElementById("ms-main").getElementsByTagName("div");
	
	for(var i = 0; i < oLi.length; i++)
	{
		oLi[i].index = i;
		oLi[i].onmouseover = function ()
		{
			for(var n = 0; n < oLi.length; n++) oLi[n].className="";
			this.className = "cur";
			for(var n = 0; n < oUl.length; n++) oUl[n].style.display = "none";
			oUl[this.index].style.display = "block"
		}	
	}
}
</script>
			<div class="ms-top">
				<ul class="hd" id="tab">
					<li class="cur"><a href="/">点击排行</a></li>
					<li><a href="/">最新文章</a></li>
				</ul>
			</div>
			<div class="ms-main" id="ms-main">
				<div style="display: block;" class="bd bd-news">
					<ul>
						<c:forEach items="${topposts}" var="tposts">
							<li><a href="/post/${tposts.id}" target="_blank">${tposts.title}</a></li>
						</c:forEach>
						<!-- <li><a href="/" target="_blank">住在手机里的朋友</a></li>
						<li><a href="/" target="_blank">教你怎样用欠费手机拨打电话</a></li>
						<li><a href="/" target="_blank">原来以为，一个人的勇敢是，删掉他的手机号码...</a></li>
						<li><a href="/" target="_blank">手机的16个惊人小秘密，据说99.999%的人都不知</a></li>
						<li><a href="/" target="_blank">你面对的是生活而不是手机</a></li>
						<li><a href="/" target="_blank">豪雅手机正式发布! 在法国全手工打造的奢侈品</a></li> -->
					</ul>
				</div>
				<div class="bd bd-news">
					<ul>
						<c:forEach items="${newposts}" var="nposts">
							<li><a href="/post/${nposts.id}" target="_blank">${nposts.title}</a></li>
						</c:forEach>
						<!-- <li><a href="/" target="_blank">原来以为，一个人的勇敢是，删掉他的手机号码...</a></li>
						<li><a href="/" target="_blank">手机的16个惊人小秘密，据说99.999%的人都不知</a></li>
						<li><a href="/" target="_blank">住在手机里的朋友</a></li>
						<li><a href="/" target="_blank">教你怎样用欠费手机拨打电话</a></li>
						<li><a href="/" target="_blank">你面对的是生活而不是手机</a></li>
						<li><a href="/" target="_blank">豪雅手机正式发布! 在法国全手工打造的奢侈品</a></li> -->
					</ul>
				</div>
				
			</div>
			<!--ms-main end -->
		</div>
		<!--切换卡 moreSelect end -->

		<div class="cloud">
			<h3>标签云</h3>
			<ul>
				<c:forEach items="${tags}" var="tags">
					<li><a href="/tags/${tags.id}">${tags.tagName}</a></li>
				</c:forEach>
				<!-- <li><a href="/">个人博客</a></li>
				<li><a href="/">web开发</a></li>
				<li><a href="/">前端设计</a></li>
				<li><a href="/">Html</a></li>
				<li><a href="/">CSS3</a></li>
				<li><a href="/">Html5+css3</a></li>
				<li><a href="/">百度</a></li>
				<li><a href="/">Javasript</a></li>
				<li><a href="/">web开发</a></li>
				<li><a href="/">前端设计</a></li>
				<li><a href="/">Html</a></li>
				<li><a href="/">CSS3</a></li>
				<li><a href="/">Html5+css3</a></li>
				<li><a href="/">百度</a></li> -->
			</ul>
		</div>
		<div class="ad">
			<img src="/images/03.jpg">
		</div>
		<div class="links">
			<h3>
				<span>[<a href="/">申请友情链接</a>]
				</span>友情链接
			</h3>
			<ul>
				<li><a href="/">杨青个人博客</a></li>
				<li><a href="/">web开发</a></li>
				<li><a href="/">前端设计</a></li>
				<li><a href="/">Html</a></li>
				<li><a href="/">CSS3</a></li>
				<li><a href="/">Html5+css3</a></li>
				<li><a href="/">百度</a></li>
			</ul>
		</div>
	</div>
	<!--r_box end --> </article>
	<footer>
	<p class="ft-copyright">Z09414208 陆庆林</p>
	<div id="tbox">
		<a id="togbook" href="/"></a> <a id="gotop" href="javascript:void(0)"></a>
	</div>
	</footer>
</body>
</html>