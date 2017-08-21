<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>
<%
  response.setCharacterEncoding("utf-8");
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	   </head>
      <%@ include file = "/common/head.inc"%>
       <%@ taglib uri = "/struts-tags" prefix = "s"  %>
       
       
     <div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->

       <h2 align = "center"><s:text name="register.info"></s:text></h2>
       
        <s:fielderror></s:fielderror>
        
	    <s:form action = "Customerregister.action" validate="true" theme="simple" namespace="" >
	      <p align = "center">
	           用户名&nbsp;&nbsp;&nbsp;&nbsp;：<s:textfield name = "yhm"  required = "true" key = "yhm.label"></s:textfield>
		   </p>
		   <p align = "center">
		    真实姓名：<s:textfield name = "registername"  required = "true" key = "yhm.label"></s:textfield>
		  </p>
		   <p align = "center">
		       登录密码：<s:password name = "dlpassword" required = "true" key = "dlpassword.label"></s:password>
		  </p>
		   <p align = "center">                        
		        确认密码：<s:password name = "qrpassword"  required = "true" key = "qrpassword.label"></s:password>
		  </p>
		  <p align = "center">                        
		        电子邮箱：<s:textfield name = "email" required = "true" key = "email.label"></s:textfield>
		  </p>
		  <p align = "center">                        
		       性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：<s:radio name = "sex" value = "'男'" label = "性别" list = "#{'男':'男','女':'女','保密':'保密'}"></s:radio>
		  </p>
		  <p align = "center">                        
		       年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：<s:textfield name = "age" key = ""></s:textfield>
		  </p>
		  <p align = "center">                        
		        学科领域：<s:textfield name = "science" key = ""></s:textfield>
		  </p>
		  <p align = "center">                        
		        身&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;份：<s:radio name = "identity" value = "0" label = "身份" list = "#{0:'教师',1:'学生'}"></s:radio>
		  </p>
		  <p align = "center">                        
		        发布时间:<s:textfield label="发布时间" name="reporttime" value = ""/>
		  </p>
		  <p align = "right"><s:submit value = "保存"></s:submit><s:reset value = "重置"></s:reset></p>
	  </s:form> 
	 </div>
	 </div>
      
     <%@ include file = "/common/down.inc"%>
