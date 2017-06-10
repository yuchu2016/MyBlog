<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>个人博客后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${sessionScope.username}</span><a href="/home/logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>		<li class="nav-item dl-selected"><div class="nav-item-inner nav-order">业务管理</div></li>

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/assets/js/bui-min.js"></script>
<script type="text/javascript" src="/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="/assets/js/config-min.js"></script>
<p>${status}</p>
<c:if test="${role==30}"><script>
    BUI.use('common/main',function(){
        var config = [{id:'1',menu:[{text:'系统管理',items:[{id:'1',text:'用户管理',href:'./user/index'},{id:'2',text:'新增用户',href:'./user/add'},{id:'1',text:'修改资料',href:'./user/edit'}]}]},{id:'2',homePage : '1',menu:[{text:'文章管理',items:[{id:'1',text:'查询管理',href:'./post/index'},{id:'2',text:'添加文章',href:'./post/add'}]}]}];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</c:if>
<c:if test="${role==20}"><script>
	BUI.use('common/main',function(){
		var config = [{id:'1',menu:[{text:'系统管理',items:[{id:'1',text:'修改资料',href:'./user/edit'}]}]},{id:'2',homePage : '1',menu:[{text:'文章管理',items:[{id:'1',text:'查询管理',href:'./post/index'},{id:'2',text:'添加文章',href:'./post/add'}]}]}];
	    new PageUtil.MainPage({
	        modulesConfig : config
	    });
	});
</script>
</c:if>
<c:if test="${role==10}"><script>
	BUI.use('common/main',function(){
		var config = [{id:'1',menu:[{text:'系统管理',items:[{id:'1',text:'修改资料',href:'./user/edit'}]}]},{id:'2',homePage : '1',menu:[{text:'文章管理',items:[{id:'1',text:'查询管理',href:'./post/index'}]}]}];
	    new PageUtil.MainPage({
	        modulesConfig : config
	    });
	});
</script>
</c:if>
<div style="text-align:center;">
<!-- <p>来源：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p> -->
</div>
</body>
</html>