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
</head>
<body>
  <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 添加课程</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="first">
    <input type="hidden" name="jsp" value="AddSelect"/>
        <div class="label">
          	请输入新信息 
        </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">新教师号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mTeacherStno" name="mTeacherStno" size="50" placeholder="新教师号" on data-validate="required:新教师号" />       
        </div>
      </div>  
      <div class="form-group">
        <div class="label">
          <label for="sitename">新课程号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="mTeacherStname" size="50" placeholder="请输入新课程名" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">新班号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="mTeacherSsex" size="50" placeholder="请输入新班号" />          
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>      
    </form>
  </div>
</div>
</body></html>