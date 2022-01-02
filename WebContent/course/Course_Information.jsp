<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dqpi.Model.Course" %>
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
    	ArrayList list = (ArrayList)session.getAttribute("StudentSelectCourse");
%>

<form method="post" action="first" id="listform">
 
    <div class="padding border-bottom">
    <table class="table table-hover text-center">
      <tr>
        <th width="340">课程号</th>
        <th width="120">课程名</th>
        <th width="290">学分</th>
        <th width="120">学时</th>
          <th width="120">类别</th>
<!--        <th width="310">操作</th>-->
      </tr>

	<%for(int i=0;i<list.size();i++){
		Course user=(Course)list.get(i);%> 
      <tr>   
          <td><%=user.getCno()%></td>
          <td><font color="#00CC99"><%=user.getCname()%></font></td>
          <td><%=user.getCgrade() %></td>
          <td><%=user.getCtime()%></td>
          
          <td><%=user.getType() %></td>
        </tr>
    <%}%>
    </table>
  </div>
</form>
</body>
</html>