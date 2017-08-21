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
            <td><a href = "selectsigleforuminfo.action?fid=${list.fid}&first=1">${list.forumtitle}</a></td>
            <td>${list.forumman}</td>
            <td>${list.forumtime}</td>
             
            <td>
            <s:if test="%{#session.register.getIdentity()==0}">
            <a href = "selectsigleforuminfo.action?fid=${list.fid}&first=0">修改</a>&nbsp;&nbsp;
            <a href = "selectsigleforuminfo.action?fid=${list.fid}&first=3">帖子库</a>&nbsp;&nbsp;
            <a href = "selectsigleforuminfo.action?fid=${list.fid}&first=5">发帖</a>
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
        <div class="pagination">
        <s:if test="%{#session.register.getIdentity()==1}">
       <s:iterator value="pageBean">
       <p>
         共<s:property value="allRow"/>条记录    
         共<s:property value="totalPage"/>页    
         当前第<s:property value="currentPage"/>页
    
         <s:if test="%{currentPage == 1}">
           第一页  上一页
         </s:if>
         <!-- currentPage为当前页 -->
         <s:else>
           <a href="allpassforuminfo.action?tag=1&page=1">第一页</a>
           <a href="allpassforuminfo.action?tag=1&page=<s:property value="%{currentPage-1}"/>">上一页</a>
         </s:else>
    
         <s:if test="%{currentPage != totalPage}">
         <a href="allpassforuminfo.action?tag=1&page=<s:property value="%{currentPage+1}"/>">下一页</a>
         <a href="allpassforuminfo.action?tag=1&page=<s:property value="totalPage"/>">最后一页</a>
            </s:if>
    
         <s:else>
         下一页  最后一页
         </s:else>
         </p>
</s:iterator>
 </s:if>
    <s:if test="%{#session.register.getIdentity()==0}">
       <s:iterator value="pageBean">
       <p>
         共<s:property value="allRow"/>条记录    
         共<s:property value="totalPage"/>页    
         当前第<s:property value="currentPage"/>页
    
         <s:if test="%{currentPage == 1}">
           第一页  上一页
         </s:if>
         <!-- currentPage为当前页 -->
         <s:else>
           <a href="allpassforuminfo.action?tag=0&page=1">第一页</a>
           <a href="allpassforuminfo.action?tag=0&page=<s:property value="%{currentPage-1}"/>">上一页</a>
         </s:else>
    
         <s:if test="%{currentPage != totalPage}">
         <a href="allpassforuminfo.action?tag=0&page=<s:property value="%{currentPage+1}"/>">下一页</a>
         <a href="allpassforuminfo.action?tag=0&page=<s:property value="totalPage"/>">最后一页</a>
            </s:if>
    
         <s:else>
         下一页  最后一页
         </s:else>
         </p>
</s:iterator>
 </s:if>
       </div>
       </div>
       </div>
  </body>
   <%@ include file = "/common/down.inc"%>
</html>
