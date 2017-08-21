<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chooseclasses.jsp' starting page</title>
    
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
   
   
   
 <div class="wrapper row3">
  <div id="container" class="clear">
  
  <%@ include file = "/common/child.jsp"%>
    <!-- ####################################################################################################### -->
    <div id="content">
    
    <h2>已选课程</h2>
      <table summary="Summary Here" cellpadding="0" cellspacing="0">
        <thead>
          <tr>
            <th>课程名称</th>
            <th>课时安排</th>
            <th>使用教材</th>
            <th>考核方式</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="list">
          <tr class="light">
            <td>${list.classname}</td>
            <td>${list.classtime}</td>
            <td>${list.classbook}</td>
            <td>${list.classexam}</td>
            <td><a href = "deleteralation.action?cid=${list.cid}">退选</a>&nbsp;&nbsp;<a href = "allworks.action?cid=${list.cid}">
                   作业</a>&nbsp;&nbsp;<a href = "view/work/addworkinfo.jsp?cid=${list.cid}">上交作业</a>&nbsp;&nbsp;<a href = "loaddown.action?cid=${list.cid}">下载</a></td>
          </tr>
        </c:forEach>
          </tbody>
          </table>
          
       </div>
       </div>
       </div>
  </body>
   <%@ include file = "/common/down.inc"%>
</html>
