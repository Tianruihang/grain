<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"   %>    
<%request.setCharacterEncoding("UTF-8");%>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="${ctx }/css/pintuer.css">
<link rel="stylesheet" href="${ctx }/css/admin.css">
<script src="${ctx }/js/jquery.js"></script>
<script src="${ctx }/js/pintuer.js"></script>
</head>
<body>
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="${ctx }/product/add.jsp"> 添加内容</a> </li>
        <li>搜索：</li>
        <li>
          <input id="searchParam" type="text" placeholder="请输入搜索名称" " name="" value="${searchParam }" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascrpt:search()" class="button border-main icon-search" onclick="searchp();return false;" > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
        <th>名称</th>
        <th>价格</th>
        <th width="310">操作</th>
      </tr>
      <volist name="list" id="vo">
        <tr>
        <c:forEach items="${page.list }" var="p">
        <tr>
			<td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />
           ${p.productId}</td>
          <td>${p.name }</td>
          <td><font color="#00CC99">${p.price }</font></td>
          <td>
          <div class="button-group"> 
          <a class="button border-main" href="${ctx }/product/edit?productId=${p.productId }"><span class="icon-edit"></span> 修改</a> 
          <a class="button border-red" href="${ctx }/product/delete?productId=${p.productId }"><span class="icon-trash-o"></span> 删除</a> 
          </div>
          </td>
		</tr>
		</c:forEach>
        </tr>

      <tr>
        <td  width="160" style="text-align:left; padding:19px 0;padding-left:20px;"><input type="checkbox" id="checkall"/>
          全选/反选 </td>
        <td colspan="7" style="text-align:left;padding-left:20px;"><a href="javascript:void(0)" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick="DelSelect()"> 删除</a> 
          </td>
      </tr>
      <tr>
        <td colspan="8">
        <div class="pagelist">
         <a href="${ctx }/product/list?pageNum=1">首页</a> 
        	<c:forEach begin="1" end="${page.totalPageNum }" var="pageNum">
				<a name="pagen" href="${ctx }/product/list?pageNum=${pageNum }">${pageNum }</a>
			</c:forEach>
        	 <a href="${ctx }/product/list?pageNum=${page.totalPageNum }">尾页</a> 
         </div>
         </td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">
//搜索
function searchp(){
	var p=$("#searchParam").val();
	 //document.write(p);
	window . location . href = "${ctx }/product/list?searchParam="+p;


//	document.write("${ctx }/product/list?searchParam="+p);
	
	//$("[name='pagen']").each(function(key,value){
		//$(this).attr("href",$(this).attr("href")+"&searchParam='"+p+"'");
	//});
}


//全选
$("#checkall").click(function(){ 
	$("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;		
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

</script>
</body>
</html>