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
           <a href="allinformation.action?page=1">第一页</a>
           <a href="allinformation.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>
         </s:else>
    
         <s:if test="%{currentPage != totalPage}">
         <a href="allinformation.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>
         <a href="allinformation.action?page=<s:property value="totalPage"/>">最后一页</a>
            </s:if>
    
         <s:else>
         下一页  最后一页
         </s:else>
         </p>
</s:iterator>
</div>
       
       </div>
       </div>
      
       <%@ include file = "/common/down.inc"%>