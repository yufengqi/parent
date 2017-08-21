<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'forumfisrtdetails.jsp' starting page</title>
    
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
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri = "/struts-tags" prefix = "s"  %>
   

 <div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->
    <div id="homepage" class="clear">
      <!-- ###### -->
      
       <s:set name="test" value="1" /> 
          
     <c:forEach items="${passallforumpost}" var="list">   
        <s:if test="%{#test ==1}">
    <div style=" width:950; height:auto; overflow:auto ">
    <div style=" margin-top:-10">
       <iframe src="selectsigleforuminfo.action?fid=${list.foruminfo.fid}&first=6" width="950"; height="200" frameborder="0" scrolling="no" >
       </iframe>
     </div>
     </div>
      <s:set name="test" value="2" /> 
     </s:if>
   </c:forEach>
       
     <c:forEach items="${passallforumpost}" var="list">  
       <b><a href = "selectforumpost.action?fpid=${list.fpid}&review=1">${list.posttitle}</a></b><div align = "right" >&nbsp;&nbsp;贴主：${list.postman}时间：${list.posttime}</div>
       <br/>
       </c:forEach>
      </div>
    </div>
   </div>

 
     </body>
   <%@ include file = "/common/down.inc"%>
</html>
