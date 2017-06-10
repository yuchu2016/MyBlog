<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="/css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<link rel="stylesheet" type="text/css" href="/css/fileinput.css" />
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.sorted.js"></script>
<script type="text/javascript" src="/js/bootstrap.js"></script>
<script type="text/javascript" src="/js/ckform.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/upload.js"></script>
<script type="text/javascript" charset="utf-8" src="/ue/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/ue/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="/ue/lang/zh-cn/zh-cn.js"></script>


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


	<table class="table table-bordered table-hover definewidth m10">
		<tr>
			<td width="10%" class="tableleft">标题:</td>
			<td><input type="text" style="width: 50%" name="title" id="title"/></td>
		</tr>
		<tr>
			<td class="tableleft">分类:</td>
			<td><select id="cat" 
				name="catId" class="selectpicker" /></select></td>
		</tr>
	<tr>
		<td class="tableleft">封面图片:</td>
		<td>
			<form id="uploadForm" enctype="multipart/form-data">
				<input id="file" type="file" name="file" />
				<button id="upload" type="button">upload</button>
				<p id="label_img"></p>
			</form>
		</td>
	</tr>
	<tr>
			<td width="10%" class="tableleft">正文:</td>
			<td><div><script id="editor" type="text/plain" style="width:1024px;height:500px;"></script></div></td>
		</tr>
		<tr>
			<td class="tableleft">状态:(默认禁用)</td>
			<td><input type="radio" id="isValid" name="isValid" value="1"  /> 启用 
				<input type="radio" id="isValid" name="isValid" value="0" checked/> 禁用</td>
		</tr>
		<tr>
			<td class="tableleft">标签:(以'/'隔开)</td>
			<td><input style="width: 50%" type="text" id="tags" name="tags"/></td>
		</tr>
		<tr>
			<td class="tableleft"></td>
			<td>
				<button type="button" class="btn btn-success" name="backid"
					id="backid">返回列表</button>
				<button type="button" class="btn btn-success" onclick="getContent()">发布</button>
					
			</td>
		</tr>
	</table>


</body>
</html>
<script>
	$(function (){
		$('#saveid').click(function(){
			
		});
	});
    $(function () {       
		$('#backid').click(function(){
				window.location.href="/home/post/index";
		 });
    });
    $(document).ready(function sendAjax()
    {
        $.ajax(
        {
            url:"./getAllCats",
            type:"post",
            dataType:"json",
            success:function(data)
            {
                var jsons = data;
                var html="";
                for(var i = 0; i < jsons.length; i++)
                {
                    html += "<option value= '"+jsons[i].id+"'>"+jsons[i].catName+"</option>";
                } 
                $("#cat").html('').append(html);   
            }
        });
    });
    
</script>
<script type="text/javascript">
var img;

 $("#upload").click(function () {
	 alert("Ok");
	 $.ajax({
		    url: './addpic',
		    type: 'POST',
		    cache: false,
		    data: new FormData($('#uploadForm')[0]),
		    processData: false,
		    contentType: false
		}).done(function(res) {
		img=res;
		var html ="<img src= '"+img+"' class='img-responsive center-block'></img>";
		$("#label_img").html('').append(html);
		}).fail(function(res) {});
	});
</script>
<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
    function getContent() {
        var labelImg = img;
    	var title = $("#title").val();
    	var catId = $("#cat").val();
    	var isValid=$("input[name='isValid']:checked").val();
    	var tags=$("#tags").val();
    	var content = [];
    	content.push(UE.getEditor('editor').getContent());
        var summary = [];
        summary.push(UE.getEditor('editor').getPlainTxt());
        $.post("./postadd", { title: title, catId: catId, isValid:isValid, content:content, summary:summary,tags:tags ,labelImg:labelImg} );
    }
</script>