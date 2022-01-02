<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dqpi.Model.StudentCourse" %>
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
    	ArrayList list = (ArrayList)session.getAttribute("StudentCourse"); 
        String main_Index_message= (String)session.getAttribute("main_Index_message");
%>

<form method="post" action="first" id="listform">
    <div class="panel admin-panel">
   <div class="panel-head"><strong class="icon-reorder">项目列表</strong></div>
    <div class="padding border-bottom">
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">学号</th>
        <th width="340">姓名</th>
        <th width="120">课程号</th>
        <th width="290">课程名</th>
        <th width="120">老师</th>
        <%if(main_Index_message!=null){
        	  if(main_Index_message.equals("选课")){%>
          <th width="120">成绩</th>
          		<%} %>
          <%} %>
<!--        <th width="310">操作</th>-->
      </tr>

	<%for(int i=0;i<list.size();i++){
		StudentCourse user=(StudentCourse)list.get(i);%> 
      <tr>   
          <td><%=user.getSno() %></td>
          <td><font color="#00CC99"><%=user.getSname()%></font></td>
          <td><%=user.getCno() %></td>
          <td><%=user.getCname()%></td>
          
          <td><%=user.getTeacher() %></td>
          <%if(main_Index_message!=null){
        	  if(main_Index_message.equals("选课")){%>
          <td><%=user.getCgrade()%></td>
          		<%} %>
          <%} %>
        </tr>
    <%}%>
    </table>
  </div>
</form>
</body>
</html>