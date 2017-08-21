<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

<%
  response.setCharacterEncoding("utf-8");
 %>


   <%@ include file = "/common/top1.jsp"%>
     <%@ taglib uri = "/struts-tags" prefix = "s"  %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 
 
  <div class="wrapper row3">
  <div id="container" class="clear">
  
  <%@ include file = "/common/child.jsp"%>
    <!-- ####################################################################################################### -->
    <div id="content">
    
    <h2>个人简历</h2>
      <table summary="Summary Here" cellpadding="0" cellspacing="0">
        <thead>
          <tr>
            <th>以往教学</th>
            <th>科研成果</th>
            <th>教学风格</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${allnews}" var="passallclass">
          <tr class="light">
            <td>${passallclass.oldteach}</td>
            <td>${passallclass.result}</td>
            <td>${passallclass.classstyle}</td>
            <td><a href = "selectinformation.action?tid=${passallclass.tid}">查看/编辑</a>&nbsp;&nbsp;<a href = "deleteimformation.action?tid=${passallclass.tid}">删除简历</a></td>
          </tr>
        </c:forEach>
        <tr>
         <td><s:a href = "addinformation.action">添加个人简历</s:a></td>
         </tr>
          </tbody>
          </table>
          
       </div>
       </div>
       </div>
      
       <%@ include file = "/common/down.inc"%>