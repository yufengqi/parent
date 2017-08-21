<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
    <%@include file = "/common/head.inc" %>
  <body>
    
    <div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->
    <div id="homepage" class="clear">
      <!-- ###### -->
      <div id="content">
        <div id="top_featured" class="clear">
          <ul class="clear">
            
            
        
          <s:set name="test" value="1" /> 
      <s:iterator var="ent" value="#session.teacher" >
         
         
           <s:if test="%{#test ==1}">
            <li>
              <h2><s:property value = "#ent.classname"/></h2>
              <img src="<c:out value = "#ent.classimage"/>" alt="" />
              <p class="readmore"><a href = "selectintroduceclass.action?cid=<s:property value = "#ent.cid"/>&i=1">查看详细信息&raquo;</a></p>
            </li>
            <s:set name="test" value="2" /> 
            </s:if>
            
            
            <s:elseif test="%{#test1 ==2}">
             <li class="last">
             <h2><s:property value = "#ent.classname"/></h2>
              <img src="<c:out value = "#ent.classimage"/>" alt="" />
              <p class="readmore"><a href = "selectintroduceclass.action?cid=<s:property value = "#ent.cid"/>&i=1">查看详细信息&raquo;</a></p>
            </li>
            <s:set name="test" value="1" />  
            </s:elseif>
            
            
          </s:iterator>
           
           
           <s:set name="test1" value="1" /> 
      <s:iterator var="ent1" value="#session.student" >
         
         
           <s:if test="%{#test1 ==1}">
            <li>
              <h2><s:property value = "#ent1.yhm"/></h2>
              <img src="<c:out value = "#ent1.image"/>" alt="" />
              <p class="readmore"><a href = "selectintroduceclass.action?cid=<s:property value = "#ent1.cid"/>&i=1">查看详细信息&raquo;</a></p>
            </li>
            <s:set name="test1" value="2" /> 
            </s:if>
            
            
            <s:elseif test="%{#test1 ==2}">
             <li class="last">
             <h2><s:property value = "#ent1.yhm"/></h2>
              <img src="<c:out value = "#ent1.image"/>" alt="" />
              <p class="readmore"><a href = "selectintroduceclass.action?cid=<s:property value = "#ent1.cid"/>&i=1">查看详细信息&raquo;</a></p>
            </li>
            <s:set name="test1" value="1" />  
            </s:elseif>
            
            
          </s:iterator>
           
           
         
         </ul> 
        </div>
       </div>
      </div>
      </div>
      </div>
    
    
  
  </body>
  <%@include file = "/common/down.inc" %>
</html>
