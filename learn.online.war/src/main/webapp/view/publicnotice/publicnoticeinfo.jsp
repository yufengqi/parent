<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>


 
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'publicnoticeinfo.jsp' starting page</title>
    
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
    
    <h2>公告信息</h2>
      <table summary="Summary Here" cellpadding="0" cellspacing="0">
        <thead>
          <tr>
            <th>公告名称</th>
            <th>发布人</th>
            <th>发布时间</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
       <c:forEach items="${publicnoticees}" var="list">
          <tr class="light">
            <td>${list.reporttitle}</td>
            <td>${list.reportman}</td>
            <td>${list.reporttime}</td>
           <s:if test="%{#session.register.getIdentity()==0}">
                   <td><a href = "selectpulicnotice.action?gid=${list.gid}">查看</a>&nbsp;&nbsp;<a href = "selectupdatepulicnotice.action?gid=${list.gid}">编辑</a></td>
                   </s:if>
                   <s:elseif test="%{#session.register.getIdentity()==2}">
                   <td><a href = "selectpulicnotice.action?gid=${list.gid}">查看</a>&nbsp;&nbsp;<a href = "selectupdatepulicnotice.action?gid=${list.gid}">编辑</a>&nbsp;&nbsp;<a href = "deletepulicnotice.action?gid=${list.gid}">删除</a></td>
                   </s:elseif>
          </tr>
        </c:forEach>
        <tr>
         <td><a href = "view/publicnotice/addpublicnotice.jsp">发布新公告</a></td>
         </tr>
          </tbody>
          </table>
          
       </div>
       
        <div class="pagination">
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
           <a href="publicnotice.action?page=1">第一页</a>
           <a href="publicnotice.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>
         </s:else>
    
         <s:if test="%{currentPage != totalPage}">
         <a href="publicnotice.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>
         <a href="publicnotice.action?page=<s:property value="totalPage"/>">最后一页</a>
            </s:if>
    
         <s:else>
         下一页  最后一页
         </s:else>
         </p>
</s:iterator>
 </s:if>
    <s:if test="%{#session.register.getIdentity()==2}">
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
           <a href="allpassforumpost?manage=0&page=1">第一页</a>
           <a href="allpassforumpost?manage=0&page=<s:property value="%{currentPage-1}"/>">上一页</a>
         </s:else>
    
         <s:if test="%{currentPage != totalPage}">
         <a href="allpassforumpost?manage=0&page=<s:property value="%{currentPage+1}"/>">下一页</a>
         <a href="allpassforumpost?manage=0&page=<s:property value="totalPage"/>">最后一页</a>
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
