<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="gb2312">
<title>个人博客</title>
<meta name="keywords" content="个人博客" />
<link href="/css/feelsbase.css" rel="stylesheet">
<link href="/css/mood.css" rel="stylesheet">
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link rel="stylesheet" href="/css/layui.css" media="all">
<script src="/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/sliders.js"></script>
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<!-- 返回顶部调用 begin -->
<link href="/css/lrtk.css" rel="stylesheet" />

<script type="text/javascript" src="/js/gotop.js">  </script>
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
<div class="moodlist">
  <h1 class="t_nav"><span>删删写写，回回忆忆，虽无法行云流水，却也可碎言碎语。</span><a href="/index" class="n1">网站首页</a><a href="#" class="n2">碎言碎语</a></h1>
  <div class="bloglist"> 
  			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 10px;">
				<legend>留言墙:</legend>
			</fieldset>
			<ul class="arrow_box">
    		 <div class="sy">
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
					
					var content = layedit.getContent(layedit_my);
					$.post("/feels/add", { content:content}, function(){
						window.location.reload();
						},"json"); 
				}
			</script>
    		 </div>
    		  <span class="dateview">我：</span>
			</ul>
  
   
    <c:forEach items="${data.list}" var="list">
    <ul class="arrow_box">
     <div class="sy"><p>${list.content}</p><br>
     <p class="autor">
     <span class="dtime f_1">${list.createdAt}</span>
     </p>
     </div>
      <span class="dateview">${list.user}</span>
    </ul>
    </c:forEach> 
  </div>
  <div class="page">
  <c:forEach var="i" begin="1" end="${data.total}">
  	<a href="/feels?page=${i}"><b>${i}</b></a>
  </c:forEach>
  
  </div> 
</div>
<footer>
	<p class="ft-copyright">Z09414208 陆庆林</p>
	<div id="tbox">
		<a id="gotop" onclick="GoTop()" href="javascript:void(0)"></a>
	</div>
	</footer>
<script type="text/javascript">
    /*Yangqq图+创建于 2017/2/16*/
    var cpro_id = "u2896052";
</script>
<script type="text/javascript" src="/js/i.js"></script>

</body>
</html>
