<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.sorted.js"></script>
<script type="text/javascript" src="/js/bootstrap.js"></script>
<script type="text/javascript" src="/js/ckform.js"></script>
<script type="text/javascript" src="/js/common.js"></script>

<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
</head>
<body>
	<form class="form-inline definewidth m20" action="index.html"
		method="get">
		机构名称： <input type="text" name="rolename" id="rolename"
			class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<button type="button" class="btn btn-success" id="addnew">新增机构</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>文章编号</th>
				<th>文章标题</th>
				<th>状态</th>
				<th>管理操作</th>
			</tr>
		</thead>
		<c:forEach items="${posts}" var="posts">
			<tr>
				<td>${posts.id}</td>
				<td><a href="/post/${posts.id}">${posts.title}</a></td>
				<td>${posts.isValid}</td>
				<td>
					<a href="./setValid/${posts.id}">
						<c:if test="${posts.isValid==true}">禁用</c:if>
						<c:if test="${posts.isValid==false}">启用</c:if>
					</a> 
				
					<a href="./delete/${posts.id}">删除</a>
				</td>
			</tr>
		</c:forEach>

	</table>
	<div class="inline pull-right page">
		10122 条记录 1/507 页 <a href='#'>下一页</a> <span class='current'>1</span><a
			href='#'>2</a><a href='/chinapost/index.php?m=Label&a=index&p=3'>3</a><a
			href='#'>4</a><a href='#'>5</a> <a href='#'>下5页</a> <a href='#'>最后一页</a>
	</div>
</body>
</html>
<script>
	$(function() {

		$('#addnew').click(function() {

			window.location.href = "add.html";
		});

	});

	function del(id) {

		if (confirm("确定要删除吗？")) {

			var url = "index.html";

			window.location.href = url;

		}

	}
</script>