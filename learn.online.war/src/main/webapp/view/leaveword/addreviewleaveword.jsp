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
    
    <title>My JSP 'reviewleaveword.jsp' starting page</title>
    
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
        <div id="respond">
        <h2>留言回复</h2>
          <s:form name="form1" method="post" action="addreplyinfo.action" theme="simple">
            <div>
               内容：<s:textarea
            label="内容"
            name="replytext"
            cols="110"
            rows="10"
            />
            </div>
                <div align="right">
                  <s:submit value = "提交"></s:submit>
                </div>
        </s:form>
        </div>
        </div>
        </div> 
        
     <%@ include file = "/common/down.inc"%>
</html>
