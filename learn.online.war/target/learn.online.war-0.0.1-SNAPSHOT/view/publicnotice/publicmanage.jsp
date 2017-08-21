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
    
    <title>My JSP 'pubicmanage.jsp' starting page</title>
    
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
    <!-- ####################################################################################################### -->
    <div id="content">
    
    <h2>公告管理</h2>
      <table summary="Summary Here" cellpadding="0" cellspacing="0">
        <thead>
          <tr>
            <th>公告名称</th>
            <th>发布人</th>
            <th>发布时间</th>
            <th>审核</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${allpublicnotice}" var="list">
          <tr class="light">
            <td>${list.reporttitle}</td>
            <td>${list.reportman}</td>
            <td>${list.reporttime}</td>
            <td>${list.right}</td>
             <td><a href = "selectpulicnotice.action?gid=${list.gid}">查看</a>&nbsp;&nbsp;
                    <s:if test="%{#session.register.getIdentity()==2}">
                   <a href = "passpublicnotice.action?gid=${list.gid}">通过</a>&nbsp;&nbsp;<a href = "deletepulicnoticeM.action?gid=${list.gid}">删除</a>
                   </s:if></td>
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
