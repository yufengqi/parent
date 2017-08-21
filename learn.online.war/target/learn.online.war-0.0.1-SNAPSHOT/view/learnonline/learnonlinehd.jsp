<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

 <%@ taglib uri = "/struts-tags" prefix = "s"  %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1><font face = "楷体" color = "blue">互动区</font></h1>
	   <table width="370" border="0" align="center" bordercolor="#FFCC66">
	   <s:form name="form1" method="post" action="addcontentnow.action">
      
            <tr>
              <th scope="row">&nbsp;&nbsp;
              <div align="left">发言：</div></th>
            </tr>
            <tr>
              <th scope="row"><div align="center">
               <s:textarea
            label="内容"
            name="leavewordtext"
            cols="50"
            rows="5"/>
              </div></th>
            </tr>
            <tr>
              <th height="10" scope="row">
                <div align="right">
                  <s:submit value = "提交"></s:submit>&nbsp;&nbsp;<a href = "Allcontenthd.action">刷新</a>
                </div>
	      </th>
            </tr>
      
        </s:form>
       
        <s:iterator var="ent1" value="#request.allleaveword">
 
          <table width="370" height="93" border="0" align="center" bordercolor="#FFCC66">
            <tr>
             <!-- s:set id="allcontent" value="#request.allcontent"/> -->
              <th width="264" height="17" align="left" valign="top" scope="row">发言时间:<s:property value = "#ent1.leavewordtime"/>&nbsp;&nbsp;&nbsp;发言来自：<s:property value = "#ent1.leavewordman"/>
              <s:if test="%{#session.register.getIdentity()==2}">
              &nbsp;&nbsp;&nbsp;<a href = "selectdeletereplyinfo.action?lwid=<s:property value = "#ent1.lwid"/>">删除</a>
              </s:if>
              </th>
            </tr>
            <tr>
              <th align="left" valign="top" scope="row"><div align="left"><s:property value = "#ent1.leavewordtext"/></div></th>
            </tr>
        </table>
 </s:iterator>
  </table>
     