<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

<%
  response.setCharacterEncoding("utf-8");
 %>

   <%@ include file = "/common/head.inc"%>
  <%@ taglib uri = "/struts-tags" prefix = "s"  %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
       
       
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->

       <h2>个人简历修改</h2>
        
	     <s:set id="selectAllNew" value="#request.selectshow"/>  
	   <s:form action = "updateinformation.action" method = "post" theme="simple">
	      <s:hidden name="tid" value="%{#selectAllNew.tid}"></s:hidden>
	      <p>
	           以往教学:<s:textarea label="以往教学" name="oldteach" value = "%{#selectAllNew.oldteach}" cols="160" rows="8"/>
		   </p>
		   <p>
		     科研成果:<s:textarea label="科研成果" name="result" value = "%{#selectAllNew.result}" cols="160" rows="8"/>
		  </p>
		   <p>
		     教学风格:<s:textarea label="教学风格" name="classstyle" value = "%{#selectAllNew.classstyle}" cols="160" rows="8"/>
		  </p>
		   <p>                        
		      出版书籍:<s:textarea label="出版书籍" name="book" value = "%{#selectAllNew.book}" cols="160" rows="8"/>
		  </p>
		  <p>
		  所获荣誉:<s:textarea label="所获荣誉" name="honour" value = "%{#selectAllNew.honour}" cols="160" rows="8"/> 
		  </p>
		 <p align = "right"><s:submit value = "保存"></s:submit></p>
	  </s:form> 
	 </div>
	 </div>
       
	  <%@ include file = "/common/down.inc"%>