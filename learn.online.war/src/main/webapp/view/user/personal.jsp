<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personal.jsp' starting page</title>
    
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
       <%@ taglib uri = "/struts-tags" prefix = "s"  %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       <s:fielderror></s:fielderror>
       <!--<s:actionerror/>-->
      
       
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->
   
      <%@ include file = "/common/child.jsp"%>
      
      <div id="content">
      <h2></h2>
      <c:forEach items="${list}" var="list">
      <p><img src="image/new/book.jpg" alt="课程" width="200" height="259"></p>
      <ul>
        <li>课程名称：${list.classname}</li>
        <li>教学书籍：${list.classbook}</li>
        <li>课时安排：${list.classtime}</li>
        <li>教学计划：${list.classplan}</li>
        <li>考察方式：${list.classexam}</li>
        <li>知识基础：${list.classneedbase}</li>
      </ul>
      <p align = "left"><a href = "learnonlinesingle?cid=${list.cid}">马上学习 &raquo;</a></p>
    </c:forEach> <!--  p里面的样式 class="readmore" -->
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
           <a href="learnchooseclasses?page=1">第一页</a>
           <a href="learnchooseclasses?page=<s:property value="%{currentPage-1}"/>">上一页</a>
         </s:else>
    
         <s:if test="%{currentPage != totalPage}">
         <a href="learnchooseclasses?page=<s:property value="%{currentPage+1}"/>">下一页</a>
         <a href="learnchooseclasses?page=<s:property value="totalPage"/>">最后一页</a>
            </s:if>
    
         <s:else>
         下一页  最后一页
         </s:else>
         </p>
</s:iterator>
</div>
       
   
    
    
       
   </div>
  </div>
 

     <%@ include file = "/common/down.inc"%>
</html>
