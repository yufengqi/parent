<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>


<html> 
   <%@ include file = "/common/head.inc"%>
     
  <body>
       <%@ taglib uri = "/struts-tags" prefix = "s"  %>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       
       
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->
      
      
      
      
      <div id="comments">
        <h2><s:property value = "#session.Forumpost.posttitle"/></h2>
        <ul class="commentlist"> 
          <li class="comment_odd">
            <div class="author"><img class="avatar" src="..\common/images/demo/avatar.gif" width="32" height="32" alt="" /><span class="name"><a href="#"><s:property value = "#session.Forumpost.postman"/></a></span>&nbsp;&nbsp;<span class="wrote">发帖：</span>
            </div>
            <div class="submitdate"><s:property value = "#session.Forumpost.posttime"/></div>
            <p><s:property value = "#session.Forumpost.posttext"/><br/></p>
          </li>
          </ul>
     </div> 
      
      
       
     <div id="comments">
        <h2>相关回复：</h2>
        <ul class="commentlist">
         <s:iterator var="ent1" value="#request.allforumreview">
          <li class="comment_odd">
            <div class="author"><img class="avatar" src="..\common/images/demo/avatar.gif" width="32" height="32" alt="" /><span class="name"><a href="#"><s:property value = "#ent1.forumrman"/></a></span>&nbsp;&nbsp;<span class="wrote">wrote：</span>
            </div>
            <div class="submitdate"><s:property value = "#ent1.forumrtime"/></div>
            <p><s:property value = "#ent1.forumrtext"/></p>
          </li>
          </s:iterator>
         </ul>

   <s:if test="%{#session.register==null}">
   <div id="comments">
   <p align = "center">登录即可回复！</p>
   </div>
   </s:if>
   <s:else>

 <div id="respond">
        <h2>回复</h2>
          <s:form name="form1" method="post" action="insertforumreview.action" theme="simple">
            <div>
               内容：<s:textarea
            label="内容"
            name="forumrtext"
            cols="110"
            rows="10"/>
              </div>
                <div align="right">
                  <s:submit value = "提交"></s:submit>
                </div>
        </s:form>
        
        </div>
        </s:else>

</div>
</div>
 </div>
  </body>
  <%@ include file = "/common/down.inc"%>
</html>