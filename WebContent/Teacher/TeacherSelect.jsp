<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dqpi.Model.Teacher" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
</head>
<body style="border-top: 2px solid#999999;">
<% 
    	ArrayList list = (ArrayList)session.getAttribute("index_teacher_user");
		Teacher user = (Teacher)list.get(0);
	    
%>
<form method="post" action="first" id="listform">
 
    <div class="padding border-bottom">
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">教师号</th>
        <th width="340">姓名</th>
        <th width="120">性别</th>
        <th width="290">年龄</th>
        <th width="120">职称</th>
		<th width="310">操作</th>
      </tr>
      <tr>   
          <td><%=user.getStno() %></td>
          <td><font color="#00CC99"><%=user.getStname() %></font></td>
          <td><%=user.getStsex() %></td>
          <td><%=user.getStage() %></td>
          <td><%=user.getSto() %></td>
          <td ><div> <a class="button border-main" href="updateTeacher1.jsp?Sno=<%=user.getStno()%>&Sto=<%=user.getStname()%>" style="padding: 2px 8px;"><span class="icon-edit">
			</span> 修改</a></div></td>
        </tr>
    </table>
  </div>
</form>
</body>
</html>