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
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->
    <div id="content">
    
    <h2>用户管理</h2>
      <table summary="Summary Here" cellpadding="0" cellspacing="0">
        <thead>
          <tr>
            <th>注册ID</th>
			<th>用户名</th>
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
			<td>${c1.dlpassword}</td>
			<td>${c1.qrpassword}</td>
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
          
       </div>
       </div>
       </div>
 

  </body>
  <%@ include file = "/common/down.inc"%>
</html>
