<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

<%
  response.setCharacterEncoding("utf-8");
 %>

<html>
<head>
</head>
      <%@ include file = "/common/head.inc"%>
      
<%@ taglib uri = "/struts-tags" prefix = "s"  %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      
       
       
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->

       <h2>个人信息修改</h2>
       <s:set id="user" value="#request.register"/>  
     <s:form action = "update.action" theme="simple" validate="true">
	   <s:hidden name="zcid" value="%{#user.zcid}"></s:hidden>
	   <p>
	   用户名&nbsp;&nbsp;&nbsp;&nbsp;:<s:textfield name = "yhm" label = "用户名" value = "%{#user.yhm}" required = "true"></s:textfield>
	   </p>
	   <p>
	    真实姓名:<s:textfield name = "registername"  label = "真实姓名" value = "%{#user.registername}"></s:textfield>
	   </p>
	   <p>
	    登录密码:<s:password name = "dlpassword" label = "登录密码" value = "%{#user.dlpassword}" required = "true"></s:password> 
	   </p>
	   <p>
	    确认密码:<s:password name = "qrpassword" label = "确认密码" value = "%{#user.qrpassword}" required = "true"></s:password>
	   </p>
	   <p>
	    电子邮箱:<s:textfield name = "email" label = "电子邮箱"  value = "%{#user.email}" required = "true"></s:textfield>
	   </p>
	   <p>
	     性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:<s:textfield name = "sex" label = "性别"  value = "%{#user.sex}"></s:textfield>
	   </p>
	   <p>
	    年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:<s:textfield name = "age" label = "年龄" value = "%{#user.age}"></s:textfield>
	   </p>
	   <s:if test="%{#session.register.getIdentity()==0}">
	   <p>
	    学科领域:<s:textfield name = "science" label = "学科领域" value = "%{#user.science}"></s:textfield>
	   </p>
	   <p>
	    个人头像:<s:textfield name = "image" label = "头像" value = "%{#user.image}"></s:textfield>
	   </p>
	   </s:if>
	   <s:submit value = "修改"></s:submit>
	</s:form>
	</div>
</div>
	  
	     <%@ include file = "/common/down.inc"%>
</html>
	  