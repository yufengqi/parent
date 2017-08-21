<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

  <%@ include file = "/common/head.inc"%>
  <%@ taglib uri = "/struts-tags" prefix = "s"  %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
       
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->

       <h2>论坛申请</h2>
       
	   <s:form action = "insertforuminfo.action" method = "post" theme="simple" validate="true">
	    <p>
	           论坛名称:<s:textarea name="forumtitle" value = "" cols = "100" rows = "2"/>
		   </p>
		   <p>
		    论坛简介:<s:textarea  name="forumtext" value = "" cols="160" rows="10"/>
		  </p>
		   <p>
		      申请人&nbsp;&nbsp;&nbsp;&nbsp;:<s:textfield name="forumman" required = "true" value = ""/>
		  </p>
		  <p align = "right"><s:submit value = "保存"></s:submit><s:reset value = "重置"></s:reset></p>
	  </s:form> 
	 </div>
	 </div>       
       
	  <%@ include file = "/common/down.inc"%>