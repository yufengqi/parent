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
    
    <title>My JSP 'registermanage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
   <%@ include file = "/common/top2.jsp"%>
  <body>
   <%@ taglib uri = "/struts-tags" prefix = "s"  %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->

    
    <h2>用户管理</h2>
      <table summary="Summary Here" cellpadding="0" cellspacing="0" >
        <thead>
          <tr >
            <th width = "100">注册ID</th>
			<th  >用户名</th>
			<th>姓名</th>
			<th>登陆密码</th>
			<th>确认密码</th>
			<th>电子邮箱</th>
			<th>性别</th>
			<th>年龄</th>
			<th>身份</th>
			<th>学科领域</th>
			<th>操作</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${allcustomers1}" var="c1">
          <tr class="light">
            <td>${c1.zcid}</td>
			<td>${c1.yhm}</td>
			<td>${c1.registername}</td>
			<td>******</td>
			<td>******</td>
			<td>${c1.email}</td>
			<td>${c1.sex}</td>
			<td>${c1.age}</td>
			<td>${c1.identity}</td>
			<td>${c1.science}</td>
			<td>
			<a href = "delete.action?zcid=${c1.zcid}">删除</a></td>
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
           <a href="getAll?page=1">第一页</a>
           <a href="getAll?page=<s:property value="%{currentPage-1}"/>">上一页</a>
         </s:else>
    
         <s:if test="%{currentPage != totalPage}">
         <a href="getAll?page=<s:property value="%{currentPage+1}"/>">下一页</a>
         <a href="getAll?page=<s:property value="totalPage"/>">最后一页</a>
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
