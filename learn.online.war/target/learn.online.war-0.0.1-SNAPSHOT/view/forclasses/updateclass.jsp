<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateclass.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
   <%@ include file = "/common/top2.jsp"%>
  <body>
       <%@ taglib uri = "/struts-tags" prefix = "s"  %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
       
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->

       <h2>课程信息修改</h2>
        
	     <s:set id="selectclass" value="#request.selectclass"/>  
	   <s:form action = "glyupdateclass.action"  theme="simple">
	       <s:hidden name = "cid" value = "%{#selectclass.cid}"></s:hidden>
	      <p>
	         课程名称:<s:textarea label="课程名称" name="classname" value = "%{#selectclass.classname}" cols="100" rows="8"/>
		   </p>
		   <p>
		  课时安排:<s:textarea label="课时安排" name="classtime" value = "%{#selectclass.classtime}" cols="100" rows="8"/>
		  </p>
		   <p>
		    教学计划:<s:textarea label="教学计划" name="classplan" value = "%{#selectclass.classplan}" cols="100" rows="10"/>
		  </p>
		   <p>                        
		       使用教材:<s:textarea label="使用教材" name="classbook" value = "%{#selectclass.classbook}" cols="100" rows="10"/>
		  </p>
		   <p>                        
		       考核方式:<s:textarea label="考核方式" name="classexam" value = "%{#selectclass.classexam}" cols="100" rows="10"/>
		  </p>
		   <p>                        
		       知识背景:<s:textarea label="知识背景" name="classneedbase" value = "%{#selectclass.classneedbase}" cols="100" rows="10"/>
		  </p>
		   <p>                        
		       大作业&nbsp;&nbsp;&nbsp;&nbsp;:<s:textarea label="大作业" name="classwork" value = "%{#selectclass.classwork}" cols="100" rows="10"/>
		  </p>
		   <p>                        
		       使用教材:<s:textarea label="使用教材" name="classbook" value = "%{#selectclass.classbook}" cols="100" rows="10"/>
		  </p>
		   <s:hidden name = "right" value = "%{#selectclass.right}"></s:hidden>
		 <p align = "right"><s:submit value = "修改"></s:submit></p>
	  </s:form> 
	 </div>
	 </div>
  </body>
  <%@ include file = "/common/down.inc"%>
</html>
