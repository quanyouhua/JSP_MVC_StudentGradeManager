<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dqpi.Model.User" %>
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
<body>
	 <% 
    	String user=(String)session.getAttribute("name");
	 String password=(String)session.getAttribute("password");
	 String usertype=(String)session.getAttribute("usertype");
    %>
  <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 查看账户信息</strong></div>
 <div title="欢迎使用" style="padding:20px;overflow:hidden; " >
  	<p>账户名:<%=user %></p>  	
  	<p>密码:<%=password%></p>
  	<p>权限:<%=usertype%></p>
	</div>
 </div>
</div>
</body></html>