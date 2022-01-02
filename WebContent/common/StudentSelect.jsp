<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dqpi.Model.Student" %>
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
    	ArrayList list = (ArrayList)session.getAttribute("StudentSelect");
		Student user = (Student)list.get(0);
	    
%>
<form method="post" action="first" id="listform">
 
    <div class="padding border-bottom">
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">学号</th>
        <th width="340">姓名</th>
        <th width="120">性别</th>
        <th width="290">年龄</th>
        <th width="120">院系</th>
        <th width="200">班号</th>
<!--        <th width="310">操作</th>-->
      </tr>

      <tr>   
          <td><%=user.getSno() %></td>
          <td><font color="#00CC99"><%=user.getSname() %></font></td>
          <td><%=user.getSsex() %></td>
          <td><%=user.getSage() %></td>
          <td><%=user.getSdept() %></td>
          <td><%=user.getClno() %></td>
        </tr>
    </table>
  </div>
</form>
</body>
</html>