<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'introduce.jsp' starting page</title>
    
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
       <c:forEach items="${passallclass}" var="passallclass">
         
         
           <s:if test="%{#test ==1}">
            <li>
              <h2> <a id = "${passallclass.classname}"></a>${passallclass.classname}</h2>
              <img src="<c:out value = "${passallclass.classimage}"/>" alt="" />
              <p>教学计划：${passallclass.classplan}</p>
              <p class="readmore"><a href = "selectintroduceclass.action?cid=${passallclass.cid}&i=1">查看详细信息&raquo;</a></p>
            </li>
            <s:set name="test" value="2" /> 
            </s:if>
            
            
            <s:elseif test="%{#test ==2}">
             <li class="last">
              <h2><a id = "${passallclass.classname}"></a>${passallclass.classname}</h2>
              <img src="<c:out value = "${passallclass.classimage}"/>" alt="" />
              <p>教学计划：${passallclass.classplan}</p>
              <p class="readmore"><a href = "selectintroduceclass.action?cid=${passallclass.cid}">查看详细信息&raquo;</a></p>
            </li>
            <s:set name="test" value="1" />  
            </s:elseif>
            
            
           </c:forEach>
           
           
         
         </ul> 
        </div>
       </div>
   
    <div id="column">
      <div class="subnav">
        <h2>课程快速链接</h2>
        <ul>
        <c:forEach items="${passallclass}" var="passallclass">
          <li><a href="allclasses.action#${passallclass.classname}">${passallclass.classname}</a></li>
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
