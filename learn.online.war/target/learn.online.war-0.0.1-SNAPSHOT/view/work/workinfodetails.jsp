<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'workinfodetails.jsp' starting page</title>
    
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
  
  <body>
   <%@ taglib uri = "/struts-tags" prefix = "s"  %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
   
   
<div class="wrapper row3">
  <div id="container" class="clear">

    <!-- ####################################################################################################### -->
   <div id="content">
   <s:set id="selectclass" value="#request.selectwork"/> 
      <h1 class="title"><s:property value = "%{#selectclass.worktitle}"/></h1>
      <p>作业内容:<s:property value = "%{#selectclass.worktext}"/></p>
      <p>学生姓名:<s:property value = "%{#selectclass.studentname}"/></p>
      <p>附件:<s:property value = "%{#selectclass.other}"/></p>
      <p>教师评语:<s:property value = "%{#selectclass.reviewtext}"/></p>
      <p>分数:<s:property value = "%{#selectclass.reviewgrand}"/></p>
      <p>教师姓名:<s:property value = "%{#selectclass.teachername}"/></p>
      <p>批改时间:<s:property value = "%{#selectclass.reviewtime}"/></p>
      
      </div>
     </div>
    </div>
  </body>
   <%@ include file = "/common/down.inc"%>
</html>
