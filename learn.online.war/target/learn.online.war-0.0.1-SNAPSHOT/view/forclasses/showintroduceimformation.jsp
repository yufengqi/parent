<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showintroduceimformation.jsp' starting page</title>
    
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
    <div id="content">
     <s:set id="selectAllNew" value="#request.selectshow"/> 
      <h1><s:property value = "#session.intro.getRegistertableByJid().getYhm()"/>老师个人简历</h1>
      <p>以往教学：<s:property value = "#selectAllNew.oldteach"/>。</p>
      <p>科研成果：<s:property value = "#selectAllNew.result"/>。</p>
      <p>教学风格：<s:property value = "#selectAllNew.classstyle"/>。</p>
      <p>出版书籍：<s:property value = "#selectAllNew.book"/>。</p>
      <p>所获荣誉：<s:property value = "#selectAllNew.honour"/>。</p>
      
     </div>
    </div>
   </div>     

	  <%@ include file = "/common/down.inc"%>
</html>
