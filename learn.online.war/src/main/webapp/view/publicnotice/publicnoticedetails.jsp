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
    
    <title>My JSP 'publicnoticedetails.jsp' starting page</title>
    
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
   
    <s:set id="selectpublicnotice" value="#request.selectpublicnotice"/> 
   
 <div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->
    <div id="content">
      <h1><s:property value = "%{#selectpublicnotice.reporttitle}" escape = "false"/></h1>
      <img class="imgr" src="common/images/demo/gonggao.png" alt="" width="125" height="125" />
      <p><s:property value = "%{#selectpublicnotice.reportman}" escape = "false"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:date name = "%{#selectpublicnotice.reporttime}" format="yyyy-MM-dd"/></p>
      <p><s:property value = "%{#selectpublicnotice.reporttext}" escape = "false"/></p>
     
   
   
   </div>
   </div>
   </div>
  
  </body>
   <%@ include file = "/common/down.inc"%>
</html>
