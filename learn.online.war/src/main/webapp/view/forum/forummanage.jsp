<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'forummanage.jsp' starting page</title>
    
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
   
    
    <h2>论坛管理</h2>
      <table summary="Summary Here" cellpadding="0" cellspacing="0">
        <thead>
          <tr>
          <th>论坛名称</th>
            <th>申请人</th>
            <th>申请时间</th>
            <th>审核</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
       <c:forEach items="${allForum}" var="list">
          <tr class="light">
            <td>${list.forumtitle}</td>
            <td>${list.forumman}</td>
            <td>${list.forumtime}</td>
             <td>${list.right}</td>
            <td><a href = "passforum.action?fid=${list.fid}">通过</a>&nbsp;<a href = "deleteforuminfo.action?fid=${list.fid}">删除</a>&nbsp;<a href = "selectsigleforuminfo.action?fid=${list.fid}&first=2">帖子管理</a></td>
          </tr>
        </c:forEach>
          </tbody>
          </table>
          
     
       
       <div class="pagination">
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
           <a href="allforuminfo.action?page=1">第一页</a>
           <a href="allforuminfo.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>
         </s:else>
    
         <s:if test="%{currentPage != totalPage}">
         <a href="allforuminfo.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>
         <a href="allforuminfo.action?page=<s:property value="totalPage"/>">最后一页</a>
            </s:if>
    
         <s:else>
         下一页  最后一页
         </s:else>
         </p>
</s:iterator>
</div>
       </div>
       </div>     
      
  </body>
   <%@ include file = "/common/down.inc"%>
</html>
