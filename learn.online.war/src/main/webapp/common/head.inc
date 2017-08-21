 <%@ taglib uri = "/struts-tags" prefix = "s"  %>
     <s:if test="%{#session.register.getIdentity()==0}">
       <%@ include file = "top1.jsp"%>
     </s:if>
     <s:elseif test="%{#session.register.getIdentity()==1}">
       <%@ include file = "top1.jsp"%>
     </s:elseif>
     <s:elseif test="%{#session.register.getIdentity()==2}">
       <%@ include file = "top2.jsp"%>
     </s:elseif>
     <s:else>
        <%@ include file = "top.jsp"%>
     </s:else>