<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dqpi.Model.Teacher"%>
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
<script>
function getkey(a) {
        var pms ='&mSno=' + document.getElementById("sno").value+'&mCno='+document.getElementById("cno").value
        			+'&Sname='+document.getElementById("mTeacherStno").value+'&Cname='+document.getElementById("mTeacherStname").value
        			+'&Scg='+document.getElementById("mTeacherSage").value;
  		a.href ='first?Ajsp=TimeAddGrade'+pms;
  }
</script>
</head>
<body>
<% 
  String Sno=request.getParameter("Sno");
  String Cno=request.getParameter("Cno");
 %>
  <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改学生信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="first">
    <input type="hidden" name="jsp" value="Student_update_Grade"/>
    <input type="hidden" id="sno" name="Sno" value="<%=Sno%>"/>
    <input type="hidden" id="cno" name="Cno" value="<%=Cno%>">
    <!-- <input type="hidden" name="message1" value=""> -->
        <div class="label">
          	请输入新信息 
        </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">新学生名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mTeacherStno" name="mTeacherStno" size="50" placeholder="请输入新学生名" on data-validate="required:请输入新学生名" />       
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label for="sitename">新课程名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mTeacherStname" name="mTeacherStname" size="50" placeholder="请输入新课程名" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">新成绩：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mTeacherSage" name="mTeacherSage" size="50" placeholder="请输入新成绩" />          
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button> 
         <a href="" onClick="getkey(this)" class="button bg-main icon-check-square-o">暂存</a>
        </div>
      </div> 
      </form>     
  </div>
</div>
</body></html>