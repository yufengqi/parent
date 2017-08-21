<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

 <%@ taglib uri = "/struts-tags" prefix = "s"  %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 <link rel="stylesheet" href="common/styles/layout.css" type="text/css" />
 
 <div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->
    <div id="homepage" class="clear">
 
  <s:set id="selectForum" value="#request.selectForum"/>  
       <h2><s:property value = "#selectForum.forumtitle"/></h2>
        <div align = "right">版主：<s:property value = "#selectForum.forumman"/>时间：<s:property value = "#selectForum.forumtime"/>
         <s:if test="%{#session.register.getIdentity()==0 || #session.register.getIdentity()==1}">&nbsp;&nbsp;&nbsp;<!--  <a href = "#">发帖</a>-->
       </s:if></div>
       <p>论坛简介：<s:property value = "#selectForum.forumtext"/></p>
       <br/>
     
    </div>
   </div>
  </div>