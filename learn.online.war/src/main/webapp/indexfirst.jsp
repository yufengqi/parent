<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "/struts-tags" prefix = "s"  %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head profile="http://gmpg.org/xfn/11">
<title>易学网</title>
</head>
<body>
  <%@include file = "/common/head.inc" %>
  

  <div class="wrapper row3">
  <div id="container" class="clear">
<!-- ####################################################################################################### -->
     
      <div id="column">
     <div id="latestnews">
      <h2>最新公告</h2>
          <ul>
          <c:forEach items="${passallpublicnotice}" var="list">
            <li>
              <p><strong>${list.reporttitle}</strong> &nbsp;&nbsp;&nbsp;&nbsp;${list.reportman}·${list.reporttime}<br />
               </p>
              <p class="readmore"><a href = "selectpulicnotice.action?gid=${list.gid}">查看 &raquo;</a></p>
            </li>
            </c:forEach>
          </ul>
     </div>
     </div> 


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
      
      
  </body>
  
     <%@include file = "/common/down.inc" %>
</html>
