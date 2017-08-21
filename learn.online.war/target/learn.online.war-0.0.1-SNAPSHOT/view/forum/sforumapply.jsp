<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sforumapply.jsp' starting page</title>
    
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
    <div id="homepage" class="clear">
      <!-- ###### -->
      <div id="content">
        <div id="top_featured" class="clear">
          <ul class="clear">
            
            
        
          <s:set name="test" value="1" /> 
       <c:forEach items="${passallForum}" var="list">
         
         
           <s:if test="%{#test ==1}">
            <li>
               <h2 id = "${list.forumtitle}">${list.forumtitle}</h2>
              <p>论坛简介：${list.forumtext}</p>
              <p>版主：${list.forumman}</p>
              <p>开版时间：${list.forumtime}</p>
              <p class="readmore"><a href = "updateforumrelation.action?fid=${list.fid}">申请&raquo;</a></p>
            </li>
            <s:set name="test" value="2" /> 
            </s:if>
            
            
            <s:elseif test="%{#test ==2}">
            <li class = "last">
              <h2 id = "${list.forumtitle}">${list.forumtitle}</h2>
              <p>论坛简介：${list.forumtext}</p>
              <p>版主：${list.forumman}</p>
              <p>开版时间：${list.forumtime}</p>
              <p class="readmore"><a href = "updateforumrelation.action?fid=${list.fid}">申请&raquo;</a></p>
            </li>
            <s:set name="test" value="1" />  
            </s:elseif>
            
            
           </c:forEach>
           
           
         
         </ul> 
        </div>
       </div>
       
       <div id="column">
      <div class="subnav">
        <h2>快速链接</h2>
        <ul>
        <c:forEach items="${passallForum}" var="list">
          <li><a href="allpassforuminfo.action?tag=3#${list.forumtitle}">${list.forumtitle}</a></li>
          </c:forEach>
        </ul>
      </div>
       
       </div>
      </div>
     </div>
     </div>
  </body>
   <%@ include file = "/common/down.inc"%>
</html>
