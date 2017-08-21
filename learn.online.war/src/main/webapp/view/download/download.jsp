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
    
    <title>My JSP 'download.jsp' starting page</title>
    
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
  
  <%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
		<%--	<s:iterator value="uploadFileName" id="downloadFileName">--%>
		<%--				<a href="download.action?name=<s:property value='%{#downloadFileName}'/>"><s:property value="%{#%{#downloadFileName}}" /> </a>--%>
		<%--				<br>--%>
		<%--	</s:iterator>--%>
		
		
		
	<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->
   
    
    <h2>文件下载</h2>
      <table summary="Summary Here" cellpadding="0" cellspacing="0">
        <tbody>
           <c:forEach var="uploadFiles" items="${uploadFiles}">
				  <tr class="light">
					<td>
						<a
							href="download.action?name=${uploadFiles.upfrom}&realname=${uploadFiles.upttitle}">${uploadFiles.upttitle
							}</a>&nbsp;&nbsp;
							
							<s:if test="%{#session.register.getIdentity()==2}">
							<a href = "deleteupinfo.action?id=${uploadFiles.id}">删除</a>
							</s:if>
					</td>
				</tr>

			</c:forEach>
          </tbody>
          </table>
          
          
 <div class="pagination">
        <s:if test="%{#session.register.getIdentity()!=''}">
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
           <a href="loaddown.action?cid=${Session.cid}&page=1">第一页</a>
           <a href="loaddown.action?cid=${Session.cid}&page=<s:property value="%{currentPage-1}"/>">上一页</a>
         </s:else>
    
         <s:if test="%{currentPage != totalPage}">
         <a href="loaddown.action?cid=${Session.cid}&page=<s:property value="%{currentPage+1}"/>">下一页</a>
         <a href="loaddown.action?cid=${Session.cid}&page=<s:property value="totalPage"/>">最后一页</a>
            </s:if>
    
         <s:else>
         下一页  最后一页
         </s:else>
         </p>
</s:iterator>
 </s:if>

<s:else>
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
           <a href="loaddownall.action?page=1">第一页</a>
           <a href="loaddownall.action?page=<s:property value="%{currentPage-1}"/>">上一页</a>
         </s:else>
    
         <s:if test="%{currentPage != totalPage}">
         <a href="loaddownall.action?page=<s:property value="%{currentPage+1}"/>">下一页</a>
         <a href="loaddownall.action?page=<s:property value="totalPage"/>">最后一页</a>
            </s:if>
    
         <s:else>
         下一页  最后一页
         </s:else>
         </p>
</s:iterator>
</s:else>

       </div>
          
       </div>
       </div>
    	
		
  </body>
 
    <%@ include file = "/common/down.inc"%>
</html>
