<%@ page pageEncoding = "utf-8" %>
 <%@ taglib uri = "/struts-tags" prefix = "s"  %>
 <style type="text/css">
<!-- 	
	#title  
     {  
      text-align:center;  
     }  
     #title.ul li  
     {  
       list-style-type:none;  
       display:inline;  
     }  
    -->
</style>
<!-- <div id="left_column">
      <div class="holder">
       <div class = "title"> --> 
       
       <div id="column">
      <div class="subnav">
        <h2 class="title"><s:property value = "#session.register.getYhm()"/>，欢迎你！</h2>
        <ul>
        <s:if test="%{#session.register.getIdentity()==2}">
          <li> <s:a href = "publicnotice.action">公告</s:a></li>
         </s:if>
          <s:if test="%{#session.register.getIdentity()==0}">
          <li><s:a href = "publicnotice.action">公告</s:a></li>
          <li><s:a href = "selectupdate.action">个人信息</s:a></li>
          <li><s:a href = "allinformation.action">个人简历</s:a></li>
          <li><s:a href = "view/forclasses/applyclass.jsp">课程申请</s:a></li>
          <li><s:a href = "allapplyclasses.action">已申请课程</s:a></li>
          <li><s:a href = "applyforum.action">论坛申请</s:a></li>
          <li><s:a href = "allpassforuminfo.action?tag=0">已申请论坛</s:a></li>
          <li><s:a href = "allapplyclasses.action">作业审阅</s:a></li>
          </s:if>
          <s:elseif test="%{#session.register.getIdentity()==1}">
          <li><s:a href = "selectupdate.action">个人信息</s:a></li>
          <li><s:a href = "allclasses.action">课程申请</s:a></li>
          <li><s:a href = "allchooseclasses.action">已选课程</s:a></li>
          <li><s:a href = "allpassforuminfo.action?tag=3">论坛申请</s:a></li>
          <li><s:a href = "allpassforuminfo.action?tag=1">已申请论坛</s:a></li>
          <li><s:a href = "allchooseclasses.action">作业提交</s:a></li>
          <li><s:a href = "learnchooseclasses.action">在线学习</s:a></li>
         </s:elseif>
        </ul>
      </div>
      </div>
       
       
       
       <!--   <h2 class="title"><s:property value = "#session.register.getYhm()"/>，欢迎你！</h2>
        <ul>
        <s:if test="%{#session.register.getIdentity()==2}">
          <li> <s:a href = "publicnotice.action">公告</s:a></li>
         </s:if>
          <s:if test="%{#session.register.getIdentity()==0}">
          <li><s:a href = "publicnotice.action">公告</s:a></li>
          <li><s:a href = "selectupdate.action">个人信息</s:a></li>
          <li><s:a href = "allinformation.action">个人简历</s:a></li>
          <li><s:a href = "view/forclasses/applyclass.jsp">课程申请</s:a></li>
          <li><s:a href = "allapplyclasses.action">已申请课程</s:a></li>
          <li><s:a href = "view/user/personal.jsp">论坛申请</s:a></li>
          <li><s:a href = "allapplyclasses.action">作业审阅</s:a></li>
          </s:if>
          <s:elseif test="%{#session.register.getIdentity()==1}">
          <li><s:a href = "selectupdate.action">个人信息</s:a></li>
          <li><s:a href = "allclasses.action">课程申请</s:a></li>
          <li><s:a href = "allchooseclasses.action">已选课程</s:a></li>
          <li><s:a href = "view/user/personal.jsp">论坛申请</s:a></li>
          <li><s:a href = "allchooseclasses.action">作业提交</s:a></li>
          <li><s:a href = "learnchooseclasses.action">在线学习</s:a></li>
         </s:elseif>
        </ul>
       </div>
      </div>
      </div> -->