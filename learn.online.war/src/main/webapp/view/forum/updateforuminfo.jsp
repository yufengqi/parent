<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateforuminfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

   <%@ include file = "/common/head.inc"%>
  <%@ taglib uri = "/struts-tags" prefix = "s"  %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
       
</head>      
       
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->

       <h2>编辑论坛</h2>
        
	    <s:set id="selectForum" value="#request.selectForum"/>  
	   <s:form action = "updateforuminfo.action" theme="simple" validate="true">
	      <s:hidden name="fid" value="%{#selectForum.fid}"></s:hidden>
	      <p>
	           论坛名称:<s:textarea  name="forumtitle" value = "%{#selectForum.forumtitle}" cols="80" />
		   </p>
		   <p>
		     论坛简介:<s:textarea  name="forumtext" value = "%{#selectForum.forumtext}" cols="80" rows="10"/>
		  </p>
		   <p>
		       申请人:&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield  name = "forumman" value = "%{#selectForum.forumman}" readonly = "true"/>
		  </p>
		   <p>                        
		        申请时间:<s:textfield  name="forumtime" value = "%{#selectForum.forumtime}"  required = "true" readonly = "true"  onClick="WdatePicker()"/>
		  </p>
		 <p align = "right"><s:submit value = "保存"></s:submit></p>
	  </s:form> 
	 </div>
	 </div>

	 
	  <%@ include file = "/common/down.inc"%>
</html>
