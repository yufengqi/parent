<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>
<%
  response.setCharacterEncoding("utf-8");
 %>

   <%@ include file = "/common/top1.jsp"%>
   
<%@ taglib uri = "/struts-tags" prefix = "s"  %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
       
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->

       <h2>添加个人简历</h2>
        
	     <s:form action = "insertinformation.action" method = "post" theme="simple">
	      <p>
	           以往教学:<s:textarea label="以往教学" name="oldteach" value = "" cols="160" rows="8"/>
		   </p>
		  <p>
		  科研成果:<s:textarea label="科研成果" name="result" value = "" cols="160" rows="8"/>
		  </p>
		  <p>
		  教学风格:<s:textarea label="教学风格" name="classstyle" value = "" cols="160" rows="8"/>
		  </p>
		  <p>
		  出版书籍:<s:textarea label="出版书籍" name="book" value = "" cols="160" rows="8"/>
		  </p>
		  <p>
		  所获荣誉:<s:textarea label="所获荣誉" name="honour" value = "" cols="160" rows="8"/> 
		  </p>
		  <p align = "right"><s:submit value = "保存"></s:submit><s:reset value = "重置"></s:reset></p>
		  </s:form>
		</div>
	</div>
 
	  <%@ include file = "/common/down.inc"%>