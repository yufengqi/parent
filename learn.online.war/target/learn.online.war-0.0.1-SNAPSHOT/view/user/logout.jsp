<%@ page language = "java" contentType="text/html;charset=GBK" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
   session.invalidate();
   response.sendRedirect(path+"/index.jsp");
%>