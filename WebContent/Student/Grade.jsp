<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dqpi.Model.StudentCourse" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
	<link rel="stylesheet" href="../css/pintuer.css">
	<link rel="stylesheet" href="../css/admin.css">
	<script src="../js/jquery.js"></script>
	<script src="../js/pintuer.js"></script>
<script>
	/* 全选 */
	function cli(Obj) {
		var collid = document.getElementById("all")
		var coll = document.getElementsByName(Obj)
		if (collid.checked) {
			for (var i = 0; i < coll.length; i++)
				coll[i].checked = true;
		} else {
			for (var i = 0; i < coll.length; i++)
				coll[i].checked = false;
		}
	}
	/*删除确定  */
	function confirmit() {
		if (confirm("是否确定删除？")) {
			return true;
		} else {
			alert("删除成功")
			return false;
		}
	}
	/*批量删除  */
	function deleAll(Obj) {
		var check = document.getElementsByName(Obj);
		var len = check.length;
		var idAll = ""
		for (var i = 0; i < len; i++) {
			if (check[i].checked) {
				idAll[i] = check[i].value;
				idAll = idAll + check[i].value + ",";
			}
		}
		window.location.href = "first?Ajsp=Student.Grade.delete&idAll=" + idAll;
	}
	function getkey(a) {
        var pms = '&keywords=' + document.getElementById("keywords").value;
  a.href = 'first?Ajsp=Student_Grade_Select' + pms;
  }
</script>
</head>
<body>
<% 
    	ArrayList list = (ArrayList)session.getAttribute("IndexTeacherStudentGrade");
		  
%>
<form method="post" action="" id="listform">
   <div class="panel admin-panel">
   <div class="panel-head"><strong class="icon-reorder">项目列表</strong></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="Time.jsp"> 编辑已保存项目</a> </li>
        <li>搜索：</li>
        <li>
          <input type="text" placeholder="请输入学号" Id="keywords"  name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="" onClick="getkey(this)" class="button border-main icon-search" > 搜索</a>
          <a href="first?Ajsp=index(teacher).Student.Grade" class="button border-main icon-search" > 查询全部</a></li>
        </ul>
    </div>
    <div>
     	<table class="table table-hover text-center">
		<tr >
			<th width="110" style="text-align:left; padding-left:20px;" >全选：<input type="checkbox"
				name="boxname" id="all" onclick="cli('boxname')" value="checkbox" />
			</th>
	        <th width="218" style="text-align:left; padding-left:20px;">学号</th>
	        <th width="21">总成绩</th>
	        <th width="200">操作</th>
		</tr>
	<% 
		int p=0;
		if(request.getParameter("p")!=null){//考虑到刚打开查询页面的情况，如果p没有传参，打开第一页，否则获得p值
			p=Integer.parseInt(request.getParameter("p").toString());
		}
		if(p<0){ //处于第一页时，无法向上翻页
			System.out.println("已经是第一页了！");
			p+=5;
		}
		if(p>list.size()){ //处于第一页时，无法向下翻页
			System.out.println("已经是最后一页了！");
			p-=5;
		}
		for(int i=0;i<5;i++){
			int p1=p+i;
			if(p1>=list.size()) { //如果该页面记录少于五条，输入到记录末尾就截止
				break;
			}
			StudentCourse user = (StudentCourse)list.get(p1);
		%>
		<tr>
			<td style="text-align:left; padding-left:20px;"><input type="checkbox" name="boxname" value="<%=user.getSno()%>"/></td>
		  <td width="218" style="text-align:left; padding-left:20px;"><%=user.getSno() %></td>
          <td width="21"><%=user.getCgrade()%></td>
			<td width="200"><div> 
			<%String xx="first?Ajsp=Student.Grade&sno="+user.getSno();%>
			<a class="button border-main" href="<%=xx%>" style="padding: 2px 8px;"><span class="icon-edit">
			</span> 详情</a></div></td>
		</tr>
		<%}%>
		<tr style="text-align:left; padding-left:20px" height="50px">
			<td>
				<div style="margin-right: 20px;">
					<input type="submit" value="批量删除" onclick="deleAll('boxname')">
				</div>
			</td>
			<td width="218" style="text-align:left; padding-left:20px;">
				<div>
					<a href="Grade.jsp?p=<%=p-5%>">上一页&nbsp;&nbsp;&nbsp;&nbsp;</a>
					<a href="Grade.jsp?p=<%=p+5%>">&nbsp;&nbsp;&nbsp;&nbsp;下一页</a>
				</div>
			</td>
		</tr>
	</table>
	</div>
</div>
</form>
</body></html>