<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人博客</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	-webkit-touch-callout: none;
	/* prevent callout to copy image, etc when tap to hold */
	-webkit-text-size-adjust: none;
	/* prevent webkit from resizing text to fit */
	-webkit-tap-highlight-color: rgba(210, 210, 210, 0.35);
	/* make transparent link selection, adjust last value opacity 0 to 1.0 */
	-webkit-user-select: none;
	/* prevent copy paste, to allow, change 'none' to 'text' */
}

body {
	font-family: "微软雅黑";
	font-size: 12px;
}

ul, li {
	list-style: none;
}

.ylcon {
	width: 100%;
	min-width: 320px;
}

.tit {
	height: 26px;
	line-height: 26px;
	padding: 0px 15px;
	position: relative;
	font-size: 15px;
	color: #aaa;
	border-bottom: 1px solid rgba(0, 0, 0, 0.15);
}

.story {
	border-bottom: 1px dashed #cecece;
	padding: 0 15px 3px;
	position: relative;
}

.story_t {
	font-size: 1.2em;
	color: rgba(0, 0, 0, 1);
	padding-top: 5px;
	padding-bottom: 2px;
}

.story_m {
	color: rgba(110, 110, 110, 1);
	line-height: 21px;
	word-break: break-all;
	word-wrap: break-word;
	overflow: hidden;
	font-size: 1.2em;
	padding: 2px 0;
}

.story_time {
	color: rgba(154, 154, 154, 1);
	padding: 2px 0;
}

.story_hf {
	background: rgb(245, 245, 245);
	font-size: 1.2em;
	border: 1px solid rgba(204, 204, 204, 0.2);
	border-radius: 2px;
	color: rgba(110, 110, 110, 1);
	padding: 4px;
	margin-bottom: 5px;
}

.opbtn {
	position: absolute;
	top: 0;
	right: 0;
}
</style>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="/css/base.css" rel="stylesheet">
<link href="/css/index.css" rel="stylesheet">
<link rel="stylesheet" href="/css/layui.css" media="all">
<script src="/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/sliders.js"></script>
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<!-- 返回顶部调用 begin -->
<script type="text/javascript" src="/js/up/jquery.js"></script>
<script type="text/javascript" src="/js/gotop.js">  </script>
<!-- 返回顶部调用 end-->
</head>
<body>
	<header>
	<div class="logo f_l">
		<a href="/"><img src="/images/logo.png"></a>
	</div>
	<nav id="topnav" class="f_r">
	<ul>
		<a href="/index" target="_blank">首页</a>
		<a href="/about" target="_blank">关于我</a>
		<a href="/post" target="_blank">文章</a>
		<a href="/feels" target="_blank">心情</a>
		<a href="/photolist" target="_blank">相册</a>
		<a href="/words" target="_blank">留言</a>
	</ul>
	<script src="/js/nav.js"></script> </nav> </header>
	<article>
	<div class="l_box f_l">
		<div class="topnews">
			<h2>
				<span></a><a href="/${post.userName}" target="_blank">作者:${post.userName}</a><a
					href="/" target="_blank">日期:${post.createdAt}</a></span><b>${post.title}</b>
			</h2>
			<div style="width: 600px;">${post.content}</div>
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 50px;">
				<legend>我觉得：</legend>
			</fieldset>

			<div style="margin-bottom: 20px; width: 600px;">
				<textarea class="layui-textarea" id="content" style="display: none"></textarea>
			</div>
			<button class="layui-btn site-demo-layedit" onclick="getContent()">发表</button>
			<script>
				var layedit_my = null;
				var layedit = null;
				layui.use('layedit', function() {
					layedit = layui.layedit;
					//创建编辑器
					layedit_my = layedit.build('content', {
						tool : [ 'face' ],
						height : 100
					})

				});
				function getContent() {
					var postid = ${post.id};
					var content = layedit.getContent(layedit_my);
					//alert(postid);
					//alert(content);
					$.post("/post/addComment", { postid:postid ,content:content}, function(){
						window.location.reload();
						},"json");
				}
			</script>
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 10px;">
				<legend>最新热评：</legend>
			</fieldset>
			<div class="ylcon">
				<div id="messDivId">
					<c:forEach items="${comments}" var="comments">
					<div class="story">
						<div class="opbtn"></div>
						<p class="story_t">${comments.username}:</p>
						<p class="story_time">${comments.createdAt}</p>
						<p class="story_m">${comments.content}</p>
					</div>
					</c:forEach>
					<!-- <div class="story">
						<div class="opbtn"></div>
						<p class="story_t">怜星</p>
						<p class="story_time">2015/07/12 20:48</p>
						<p class="story_m">我想问最近最火的tfboys呢他们的八卦呢我想问最近最火的tfboys呢,他们的八卦呢我想问最近最火的tfboys呢？！他们的八卦呢？！</p>
					</div> -->
				</div>
			</div>
</body>


</div>
</div>






<!-- <div class="r_box f_r">
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
	tit01 end
	<div class="ad300x100">
		<img src="/images/ad300x100.jpg">
	</div>
	<div class="moreSelect" id="lp_right_select">
		<script>
			window.onload = function() {
				var oLi = document.getElementById("tab").getElementsByTagName(
						"li");
				var oUl = document.getElementById("ms-main")
						.getElementsByTagName("div");

				for (var i = 0; i < oLi.length; i++) {
					oLi[i].index = i;
					oLi[i].onmouseover = function() {
						for (var n = 0; n < oLi.length; n++)
							oLi[n].className = "";
						this.className = "cur";
						for (var n = 0; n < oUl.length; n++)
							oUl[n].style.display = "none";
						oUl[this.index].style.display = "block"
					}
				}
			}
		</script>
		<div class="ms-top">
			<ul class="hd" id="tab">
				<li class="cur"><a href="/">点击排行</a></li>
				<li><a href="/">最新文章</a></li>
				<li><a href="/">站长推荐</a></li>
			</ul>
		</div>
		<div class="ms-main" id="ms-main">
			<div style="display: block;" class="bd bd-news">
				<ul>
					<li><a href="/" target="_blank">住在手机里的朋友</a></li>
					<li><a href="/" target="_blank">教你怎样用欠费手机拨打电话</a></li>
					<li><a href="/" target="_blank">原来以为，一个人的勇敢是，删掉他的手机号码...</a></li>
					<li><a href="/" target="_blank">手机的16个惊人小秘密，据说99.999%的人都不知</a></li>
					<li><a href="/" target="_blank">你面对的是生活而不是手机</a></li>
					<li><a href="/" target="_blank">豪雅手机正式发布! 在法国全手工打造的奢侈品</a></li>
				</ul>
			</div>
			<div class="bd bd-news">
				<ul>
					<li><a href="/" target="_blank">原来以为，一个人的勇敢是，删掉他的手机号码...</a></li>
					<li><a href="/" target="_blank">手机的16个惊人小秘密，据说99.999%的人都不知</a></li>
					<li><a href="/" target="_blank">住在手机里的朋友</a></li>
					<li><a href="/" target="_blank">教你怎样用欠费手机拨打电话</a></li>
					<li><a href="/" target="_blank">你面对的是生活而不是手机</a></li>
					<li><a href="/" target="_blank">豪雅手机正式发布! 在法国全手工打造的奢侈品</a></li>
				</ul>
			</div>
			<div class="bd bd-news">
				<ul>
					<li><a href="/" target="_blank">手机的16个惊人小秘密，据说99.999%的人都不知</a></li>
					<li><a href="/" target="_blank">你面对的是生活而不是手机</a></li>
					<li><a href="/" target="_blank">住在手机里的朋友</a></li>
					<li><a href="/" target="_blank">豪雅手机正式发布! 在法国全手工打造的奢侈品</a></li>
					<li><a href="/" target="_blank">教你怎样用欠费手机拨打电话</a></li>
					<li><a href="/" target="_blank">原来以为，一个人的勇敢是，删掉他的手机号码...</a></li>
				</ul>
			</div>
		</div>
		ms-main end
	</div>
	切换卡 moreSelect end

	<div class="cloud">
		<h3>标签云</h3>
		<ul>
			<li><a href="/">个人博客</a></li>
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
			<li><a href="/">百度</a></li>
		</ul>
	</div>
	<div class="tuwen">
		<h3>图文推荐</h3>
		<ul>
			<li><a href="/"><img src="/images/01.jpg"><b>住在手机里的朋友</b></a>
				<p>
					<span class="tulanmu"><a href="/">手机配件</a></span><span
						class="tutime">2015-02-15</span>
				</p></li>
			<li><a href="/"><img src="/images/02.jpg"><b>教你怎样用欠费手机拨打电话</b></a>
				<p>
					<span class="tulanmu"><a href="/">手机配件</a></span><span
						class="tutime">2015-02-15</span>
				</p></li>
			<li><a href="/" title="手机的16个惊人小秘密，据说99.999%的人都不知"><img
					src="/images/03.jpg"><b>手机的16个惊人小秘密，据说...</b></a>
				<p>
					<span class="tulanmu"><a href="/">手机配件</a></span><span
						class="tutime">2015-02-15</span>
				</p></li>
			<li><a href="/"><img src="/images/06.jpg"><b>住在手机里的朋友</b></a>
				<p>
					<span class="tulanmu"><a href="/">手机配件</a></span><span
						class="tutime">2015-02-15</span>
				</p></li>
			<li><a href="/"><img src="/images/04.jpg"><b>教你怎样用欠费手机拨打电话</b></a>
				<p>
					<span class="tulanmu"><a href="/">手机配件</a></span><span
						class="tutime">2015-02-15</span>
				</p></li>
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
</div> -->
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
<!--r_box end -->
</article>
<footer>
<p class="ft-copyright">Z09414208 陆庆林</p>
<div id="tbox">
	<a id="togbook" href="/"></a> <a id="gotop" onclick="GoTop()" href="javascript:void(0)"></a>
</div>
</footer>
</body>
</html>