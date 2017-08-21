<%@ page language="java" import="java.util.*" pageEncoding ="utf-8" %>

 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'workinfoupdate.jsp' starting page</title>
    
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
  <%@ taglib uri = "/struts-tags" prefix = "s"  %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
       
       
       
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->

       <s:if test="%{#session.register.getIdentity()==1}">
	        <h2>作业编辑</h2>
	      </s:if>
	      <s:elseif test="%{#session.register.getIdentity()==0}">
	        <h2>作业批改</h2>
	      </s:elseif>
        
	     <s:set id="selectAllNew" value="#request.selectwork"/>  
	     <s:form action = "updateworkinfo.action" theme="simple">
	     <s:hidden name="zyid" value="%{#selectAllNew.zyid}"></s:hidden>
	      <s:if test="%{#session.register.getIdentity()==1}">
	      <p>
		      作业名称:<s:textarea label="作业名称" name="worktitle" value = "%{#selectAllNew.worktitle}" cols = "100" rows = "2"/>
		   </p>
		   <p>
		      作业内容:<s:textarea label="作业内容" name="worktext" value = "%{#selectAllNew.worktext}" cols="160" rows="10"/>
		   </p>
		  <p>
		       学生姓名:<s:textfield label="学生姓名" name="studentname" value = "%{#selectAllNew.studentname}"/>
		  </p>
		   <p>                         
		       附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件:<s:textarea label="附件" name="other" value = "%{#selectAllNew.other}" cols="160" rows="10"/>
		   </p>
		  <p>
		    教师评语:<s:textarea label="教师评语" name="reviewtext" value = "%{#selectAllNew.reviewtext}" cols="160" rows="10" readonly="true"/> 
		  </p>
		  <p>
		    分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数:<s:textfield label="分数" name="reviewgrand" value = "%{#selectAllNew.reviewgrand}" readonly="true"/> 
		   </p>
		   <p>
		    教师姓名:<s:textfield label="教师姓名" name="teachername" value = "%{#selectAllNew.teachername}" readonly="true"/> 
		   </p>
		  <p>
		    批改时间:<s:textfield label="批改时间" name="reviewtime" value = "%{#selectAllNew.reviewtime}" readonly="true"/> 
		  </p>
		  </s:if>
		   <s:elseif test="%{#session.register.getIdentity()==0}">
	      <p>
		      作业名称:<s:textarea label="作业名称" name="worktitle" value = "%{#selectAllNew.worktitle}" cols = "100" rows = "2"/>
		   </p>
		   <p>
		      作业内容:<s:textarea label="作业内容" name="worktext" value = "%{#selectAllNew.worktext}" cols="160" rows="10" readonly="true"/>
		  </p>
		   <p>
		       学生姓名:<s:textfield label="学生姓名" name="studentname" value = "%{#selectAllNew.studentname}" readonly="true"/>
		  </p>
		   <p>                       
		       附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件:<s:textarea label="附件" name="other" value = "%{#selectAllNew.other}" cols="160" rows="10" readonly="true"/>
		   </p>
		  <p>
		    教师评语:<s:textarea label="教师评语" name="reviewtext" value = "%{#selectAllNew.reviewtext}" cols="160" rows="10"/> 
		   </p>
		  <p>
		    分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数:<s:textfield label="分数" name="reviewgrand" value = "%{#selectAllNew.reviewgrand}" /> 
		   </p>
		   <p>
		    教师姓名:<s:textfield label="教师姓名" name="teachername" value = "%{#selectAllNew.teachername}"/> 
		   </p>
		   <p>
		    批改时间:<s:textfield label="批改时间" name="reviewtime" value = "%{#selectAllNew.reviewtime}"/> 
		   </p>
		  </s:elseif>
		 <p align = "right"><s:submit value = "保存"></s:submit></p>
	  </s:form> 
	 </div>
	 </div>
       
	  <%@ include file = "/common/down.inc"%>
</html>
