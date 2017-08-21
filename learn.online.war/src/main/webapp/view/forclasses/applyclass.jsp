<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'applyclass.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
   <%@ include file = "/common/top1.jsp"%>
  <body>
       <%@ taglib uri = "/struts-tags" prefix = "s"  %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
       
<div class="wrapper row3">
  <div id="container" class="clear" >
    <!-- ####################################################################################################### -->

       <h2>课程申请</h2>
        
	    <s:form action = "insertclassinfo.action" theme="simple" validate="true">
	      <p>
	         课程名称:<s:textarea label="课程名称" id ="desciption" name="classname" value = "" cols="160" rows="8" Onclick = "change()"/>
		   </p>
		   <p>
		     课时安排:<s:textarea label="课时安排" id ="desciption1" name="classtime" value = "" cols="160" rows="8"/>
		  </p>
		   <p>
		     教学计划:<s:textarea label="教学计划" id ="desciption2" name="classplan" value = "" cols="160" rows="10"/>
		  </p>
		   <p>                        
		      使用教材:<s:textarea label="使用教材" id ="desciption3" name="classbook" value = "" cols="160" rows="10"/>
		  </p>
		  <p>
		      考核方式:<s:textarea label="考核方式" id ="desciption4" name="classexam" value = "" cols="160" rows="10"/>
		  </p>
		  <p>
		     知识背景:<s:textarea label="知识背景" id ="desciption5" name="classneedbase" value = "" cols="160" rows="10"/>
		  </p>
		  <p>
		    大作业&nbsp;&nbsp;&nbsp;&nbsp;:<s:textarea label="大作业" id ="desciption" name="classwork" value = "" cols="160" rows="10"/>
		  </p>
		   <p>
		     课程图片:<s:textfield label="课程图片" name="classimage"  required = "true" value = ""/>
		  </p>
		   <p>
		      播放连接:<s:textfield label="播放连接" name="classlink"  required = "true" value = ""/>
		  </p>
		  <p align = "right"><s:submit value = "保存"></s:submit><s:reset value = "重置"></s:reset></p>
	  </s:form> 
	 </div>
	 </div>
	    
  </body>
  <%@ include file = "/common/down.inc"%>
</html>
