<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sapplyclass.jsp' starting page</title>
    
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
   
   <div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->
    <div id="content">
      <h1><s:property value = "#selectclass.classname" escape = "false"/></h1>
      <img class="imgr" src="<s:property value = "#selectclass.classimage"/>" alt="" width="300" height="120" />
      <p>课时安排：<s:property value = "#selectclass.classtime" escape = "false"/>。</p>
      <p>教学计划：<s:property value = "#selectclass.classplan" escape = "false"/>。</p>
      <p>使用教材：<s:property value = "#selectclass.classbook" escape = "false"/>。</p>
      <p>考核方式：<s:property value = "#selectclass.classexam" escape = "false"/>。</p>
      <p>知识基础：<s:property value = "#selectclass.classneedbase" escape = "false"/>。</p>
      <p>大作业：<s:property value = "#selectclass.classwork" escape = "false"/>。</p>
   
      <img class="imgl" src="<s:property value = "#session.intro.getRegistertableByJid().getImage()"/>" alt="" width="125" height="125" />
      <p><a href = "selectintroduceinformation.action?jid=<s:property value = "#session.intro.getRegistertableByJid().getZcid()"/>" title="教师简历">任课教师</a>:<s:property value = "#session.intro.getRegistertableByJid().getYhm()" escape = "false"/></p>
      <p>性别：<s:property value = "#session.intro.getRegistertableByJid().getSex()" escape = "false"/></p>
      <p>年龄：<s:property value = "#session.intro.getRegistertableByJid().getAge()" escape = "false"/></p>
      <p>学科领域：<s:property value = "#session.intro.getRegistertableByJid().getScience()" escape = "false"/></p>
      <s:if test="%{#session.register.getIdentity()==1}">
      <p class="readmore"><a href = "classralationupdate.action?cid=<s:property value = "#selectclass.cid"/>">申请</a></p>
      </s:if>
   
   </div>
   </div>
   </div>
       
  </body>
   <%@ include file = "/common/down.inc"%>
</html>
