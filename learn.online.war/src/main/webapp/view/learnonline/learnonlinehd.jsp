<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

 <%@ taglib uri = "/struts-tags" prefix = "s"  %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



   <h4>互动区</h4>
	
	   <s:form name="form1" method="post" action="addcontentnow.action">
            <div>
               <s:textarea
            label="发言"
            name="leavewordtext"
            cols="40"
            rows="2"/>
            </div>
             <div align="right">
                  <s:submit value = "提交"></s:submit>
                </div>
           <!-- <a href = "Allcontenthd.action">刷新</a> -->    
        </s:form>
   
       
       
       <!--  <p> &nbsp;&nbsp;&nbsp;&nbsp;<a href = "Allcontent.action">刷新</a></p> -->
        <ul class="commentlist">
         <s:iterator var="ent1" value="#request.allleaveword">
          <li class="comment_odd">
            <div class="author"><img class="avatar" src="common/images/demo/leaveword.png" width="32" height="32" alt="" /><span class="name"><a href="#">发言来自：<s:property value = "#ent1.leavewordman"/></a></span>&nbsp;&nbsp;<span class="wrote">wrote:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <s:if test="%{#session.register.getIdentity()==2}">
              &nbsp;&nbsp;&nbsp;<s:if test="%{#session.register.getIdentity()==2}">
              &nbsp;&nbsp;&nbsp;<a href = "selectdeletereplyinfo.action?lwid=<s:property value = "#ent1.lwid"/>">删除</a>
              </s:if>
              </s:if></div>
            <div class="submitdate">发言时间:<s:date name = "#ent1.leavewordtime" format="yyyy-MM-dd HH:mm:ss"/></div>
            <pre><s:property value = "#ent1.leavewordtext" escape = "false"/></pre>
          </li>
       
      </s:iterator>
      </ul>
 

