<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tforumapplyed.jsp' starting page</title>
    
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
    
    <h2>已申请论坛</h2>
      <table summary="Summary Here" cellpadding="0" cellspacing="0">
        <thead>
          <tr>
            <th>论坛名称</th>
            <th>申请人</th>
            <th>申请时间</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${passallForum}" var="list">
          <tr class="light">
            <td><a href = "selectsigleforuminfo.action?fid=${list.fid}&first=1"">${list.forumtitle}</a></td>
            <td>${list.forumman}</td>
            <td>${list.forumtime}</td>
             
            <td>
            <s:if test="%{#session.register.getIdentity()==0}">
            <a href = "selectsigleforuminfo.action?fid=${list.fid}&first=0">修改</a>&nbsp;&nbsp;
            <a href = "selectsigleforuminfo.action?fid=${list.fid}&first=3">帖子库</a>&nbsp;&nbsp;
            <a href = "selectsigleforuminfo.action?fid=${list.fid}&first=5"">发帖</a>
            </s:if>
            <s:if test="%{#session.register.getIdentity()==1}">
            <a href = "selectsigleforuminfo.action?fid=${list.fid}&first=4">帖子库</a>&nbsp;&nbsp;
            <a href = "selectsigleforuminfo.action?fid=${list.fid}&first=5">发帖</a>
            </s:if>
            </td>
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
