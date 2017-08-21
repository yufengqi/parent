<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addworkinfo.jsp' starting page</title>
    
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
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
       
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->

       <h2>作业上传</h2>
        
	   <s:set name = "cidzy"  value = "#parameters.cid[0]" scope = "session"></s:set>
	   <s:form action = "insertworkinfo.action" method = "post" theme="simple">
	     <p>
	        作业名称:<s:textarea label="作业名称" name="worktitle" value = "" cols = "100" rows = "2"/>
		   </p>
		   <p>
		    作业内容:<s:textarea label="作业内容" name="worktext" value = "" cols="160" rows="10"/>
		  </p>
		   <p>
		      学生姓名:<s:textfield label="学生姓名" name="studentname" value = ""/>
		  </p>
		   <p>                        
		      附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件:<s:textarea label="附件" name="other" value = "" cols="160" rows="10"/>
		  </p>
		  <p align = "right"><s:submit value = "保存"></s:submit><s:reset value = "重置"></s:reset></p>
	  </s:form> 
	 </div>
	 </div>       
       
	  <%@ include file = "/common/down.inc"%>
</html>
