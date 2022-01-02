<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
    <script type="text/javascript">  
    function refresh() {  
        //IE存在缓存,需要new Date()实现更换路径的作用  
        document.getElementById("image").src="image.jsp?"+new Date();  
    }  
	</script>
</head>
<body>
	<% String message = (String)session.getAttribute("message");%>
	<%if(message!=null){ 
		if(message.equals("验证码出错")){%>
			<script type="text/javascript">
				alert("请输入正确的验证码");
			 </script>
		<% }%>
		<%if(message.equals("用户名或密码输入错误")){%>
			 <script type="text/javascript">
		     	alert("用户名或密码输入错误");
		     </script>
		<%}%>
    	<%message=null;
     	session.setAttribute("message",message);%>	
     <%}%>
	<div class="bg"></div>
	<div class="container">
	    <div class="line bouncein">
	        <div class="xs6 xm4 xs3-move xm4-move">
	            <div style="height:150px;"></div>
	            <div class="media media-y margin-big-bottom">           
	            </div> 
	            <form action="first" method="post">
	            <input type="hidden" name="jsp" value="login">
	            <div class="panel loginbox">
	                <div class="text-center margin-big padding-big-top"><h1>学生成绩管理系统</h1></div>
	                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
	                    <div class="form-group">
	                        <div class="field field-icon-right">
	                            <input type="text" class="input input-big" name="name" placeholder="登录账号" data-validate="required:请填写账号" />
	                            <span class="icon icon-user margin-small"></span>
	                        </div>
	                    </div>
	                    <div class="form-group">
	                        <div class="field field-icon-right">
	                            <input type="password" class="input input-big" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
	                            <span class="icon icon-key margin-small"></span>
	                        </div>
	                    </div>
	                    <hr>
	                    <div class="form-group">
	                        <div class="field person">
	                                                                     用户类型：
								<input type="radio"  name="usertype"  value="student" />学生
								<input type="radio"  name="usertype"  value="teacher" />教师
								<input type="radio"  name="usertype" value="manager" />管理员                   
	                        </div>
	                    </div> 
	                    <br>
				                验证码：<input type="text" name="code" maxlength="4">  
				        <img id="image" border="0"  onclick="refresh()" src="image.jsp" title="点击更换图片">  
	                </div>
	                <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
	            </div>
	            </form>          
	        </div>
	    </div>
	</div>
</body>
</html>