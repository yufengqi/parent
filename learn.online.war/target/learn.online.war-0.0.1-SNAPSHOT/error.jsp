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
    
    <title>My JSP 'error.jsp' starting page</title>
    
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
  <div class="wrapper row3">
  <div id="container" class="clear">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	       <h1 align = "center"><font face = "楷体">操作失败！</font></h1><br>
	 </div>
	 </div>
  </body>
    <%@ include file = "/common/down.inc"%>
</html>
