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
    
    <title>My JSP 'addpublicnotice.jsp' starting page</title>
    
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

       <h2>添加公告</h2>
        
	    <s:form action = "insertpublicnotice.action" method = "post" theme="simple">
	      <p>
	         公告名称:<s:textarea label="公告名称" name="reporttitle" value = "" cols="80" />
		   </p>
		   <p>
		     公告内容:<s:textarea label="公告内容" name="reporttext" value = "" cols="80" rows="10"/>
		  </p>
		   <p>
		       发布人:&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield label="发布人" name = "reportman" value = ""/>
		  </p>
		   <p>                        
		        发布时间:<s:textfield label="发布时间" name="reporttime" value = ""/>
		  </p>
		  <p align = "right"><s:submit value = "保存"></s:submit><s:reset value = "重置"></s:reset></p>
	  </s:form> 
	 </div>
	 </div>
	 
	  <%@ include file = "/common/down.inc"%>
</html>
