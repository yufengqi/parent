<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'classmanage.jsp' starting page</title>
    
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
   
   
   
   <div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->
    <div id="content">
    
    <h2>课程管理</h2>
      <table summary="Summary Here" cellpadding="0" cellspacing="0">
        <thead>
          <tr>
            <th>课程名称</th>
            <th>课时安排</th>
            <th>使用教材</th>
            <th>审核</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
       <c:forEach items="${allclass}" var="allclass">
          <tr class="light">
            <td>${allclass.classname}</td>
            <td>${allclass.classtime}</td>
            <td>${allclass.classbook}</td>
            <td>${allclass.right}</td>
             <td><a href = "passclass.action?cid=${allclass.cid}">通过</a>&nbsp;<a href = "selectglyupdateclass.action?cid=${allclass.cid}">编辑</a>&nbsp;<a href = "deleteclass.action?cid=${allclass.cid}">删除</a></td>
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
