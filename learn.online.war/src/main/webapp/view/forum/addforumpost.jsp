<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ include file = "/common/head.inc"%>
  <%@ taglib uri = "/struts-tags" prefix = "s"  %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
       
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->

       <h2>帖子发布</h2>
       
	   <s:form action = "insertforumpost.action" method = "post" theme="simple" >
	    <p>
	          帖子名称:<s:textarea name="posttitle" value = "" cols = "100" />
		   </p>
		   <p>
		    帖子内容:<s:textarea  name="posttext" value = "" cols="160" rows="10"/>
		  </p>
		  <p align = "right"><s:submit value = "保存"></s:submit><s:reset value = "重置"></s:reset></p>
	  </s:form> 
	 </div>
	 </div>       
       
	  <%@ include file = "/common/down.inc"%>