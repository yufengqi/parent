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
        <c:forEach items="${list}" var="list" >
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
           <a href="allchooseclasses.action?page=1">第一页</a>
           <a href="allchooseclasses.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>
         </s:else>
    
         <s:if test="%{currentPage != totalPage}">
         <a href="allchooseclasses.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>
         <a href="allchooseclasses.action?page=<s:property value="totalPage"/>">最后一页</a>
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
