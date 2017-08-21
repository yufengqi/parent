<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>


<html> 
   <%@ include file = "/common/head.inc"%>
     
  <body>
       <%@ taglib uri = "/struts-tags" prefix = "s"  %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
       
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->
        <div id="respond">
        <h2>留言版</h2>
          <s:form name="form1" method="post" action="addcontent.action" theme="simple">
            <div>
               内容：<s:textarea
            label="内容"
            name="leavewordtext"
            cols="110"
            rows="10"/>
              </div>
                <div align="right">
                  <s:submit value = "提交"></s:submit>
                </div>
        </s:form>
        
        </div>
       
 <div id="comments">
        <h2>相关留言</h2>
        <p> &nbsp;&nbsp;&nbsp;&nbsp;<a href = "Allcontent.action">刷新</a></p>
        <ul class="commentlist">
         <s:iterator var="ent1" value="#request.allleaveword">
          <li class="comment_odd">
            <div class="author"><img class="avatar" src="..\common/images/demo/avatar.gif" width="32" height="32" alt="" /><span class="name"><a href="#"><s:property value = "#ent1.leavewordman"/></a></span>&nbsp;&nbsp;<span class="wrote">wrote:</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href = "selectonlycontent.action?lwid=<s:property value = "#ent1.lwid"/>">回复</a> <s:if test="%{#session.register.getIdentity()==2}">
              &nbsp;&nbsp;&nbsp;<a href = "selectdeletereplyinfo.action?lwid=<s:property value = "#ent1.lwid"/>">删除</a>
              </s:if></div>
            <div class="submitdate"><s:property value = "#ent1.leavewordtime"/></div>
            <p><s:property value = "#ent1.leavewordtext"/></p>
          </li>
          
          
           <s:iterator var="ent" value="#request.passallreplyinfo" >
                <s:if test="#ent1.lwid ==  #ent.leavewordinfo.lwid">
           <li class="comment_even">
            <div class="author"><img class="avatar" src="..\common/images/demo/avatar.gif" width="32" height="32" alt="" /><span class="name"><a href="#"><s:property value = "#ent.replyman"/></a></span>&nbsp;&nbsp;<span class="wrote">wrote to <s:property value = "#ent1.leavewordman"/></span>
             </div>
            <div class="submitdate"><s:property value = "#ent.replytime"/></div>
            <p><s:property value = "#ent.replytext"/></p>
          </li>
          </s:if>
          </s:iterator>

          </s:iterator>
         </ul>
</div>
</div>
 </div>
     
  </body>
  <%@ include file = "/common/down.inc"%>
</html>