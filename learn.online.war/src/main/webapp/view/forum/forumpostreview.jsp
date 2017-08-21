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
        <h2><s:property value = "#session.Forumpost.posttitle" escape = "false"/></h2>
        <ul class="commentlist"> 
          <li class="comment_odd">
            <div class="author"><img class="avatar" src="common/images/demo/avatar.png" width="32" height="32" alt="" /><span class="name"><a href="#"><s:property value = "#session.Forumpost.postman" escape = "false"/></a></span>&nbsp;&nbsp;<span class="wrote">发帖：</span>
            </div>
            <div class="submitdate"><s:date name = "#session.Forumpost.posttime" format="yyyy-MM-dd HH:mm:ss"/></div>
            <p><s:property value = "#session.Forumpost.posttext" escape = "false"/><br/></p>
          </li>
          </ul>
     </div> 
      
      
       
     <div id="comments">
        <h2>相关回复：</h2>
        <ul class="commentlist">
         <s:iterator var="ent1" value="#request.allforumreview">
          <li class="comment_odd">
            <div class="author"><img class="avatar" src="common/images/demo/avatarx.png" width="32" height="32" alt="" /><span class="name"><a href="#"><s:property value = "#ent1.forumrman" escape = "false"/></a></span>&nbsp;&nbsp;<span class="wrote">wrote：</span>
            </div>
            <div class="submitdate"><s:date name = "#ent1.forumrtime" format="yyyy-MM-dd HH:mm:ss"/></div>
            <p><s:property value = "#ent1.forumrtext" escape = "false"/></p>
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


 <div class="pagination">
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
           <a href="getAllforumreviewes?page=1">第一页</a>
           <a href="getAllforumreviewes?page=<s:property value="%{currentPage-1}"/>">上一页</a>
         </s:else>
    
         <s:if test="%{currentPage != totalPage}">
         <a href="getAllforumreviewes?page=<s:property value="%{currentPage+1}"/>">下一页</a>
         <a href="allforuminfo.action?page=<s:property value="totalPage"/>">最后一页</a>
            </s:if>
    
         <s:else>
         下一页  最后一页
         </s:else>
         </p>
</s:iterator>
</div>


</div>
 </div>
  </body>
  <%@ include file = "/common/down.inc"%>
</html>