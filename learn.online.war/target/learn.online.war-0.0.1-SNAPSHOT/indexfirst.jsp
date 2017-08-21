<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "/struts-tags" prefix = "s"  %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head profile="http://gmpg.org/xfn/11">
<title>易学网</title>
</head>
<body>
  <%@include file = "/common/head.inc" %>
  

  <div class="wrapper row3">
  <div id="container" class="clear">
<!-- ####################################################################################################### -->
     
      <div id="column">
     <div id="latestnews">
      <h2>最新公告</h2>
          <ul>
          <c:forEach items="${passallpublicnotice}" var="list">
            <li>
              <p><strong>${list.reporttitle}</strong> &nbsp;&nbsp;&nbsp;&nbsp;${list.reportman}·${list.reporttime}<br />
               </p>
              <p class="readmore"><a href = "selectpulicnotice.action?gid=${list.gid}">查看 &raquo;</a></p>
            </li>
            </c:forEach>
          </ul>
     </div>
     </div> 


      <div id="content">
        <div id="top_featured" class="clear">
          <ul class="clear">
            <li>
              <h2>Sentumquisque Morbi</h2>
              <img src="..\common/images/6.jpg" alt="" />
              <p>Morbit incidunt maurisque eros molest nunc anteget sed vel lacus mus semper. Anter dumnullam interdum eros dui urna consequam ac nisl nullam ligula vestassa.</p>
              <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
            </li>
            <li class="last">
              <h2>Sentumquisque Morbi</h2>
              <img src="..\common/images/7.jpg" alt="" />
              <p>Morbit incidunt maurisque eros molest nunc anteget sed vel lacus mus semper. Anter dumnullam interdum eros dui urna consequam ac nisl nullam ligula vestassa.</p>
              <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
            </li>
          </ul>
        </div>
        
        </div>
        
        
        </div>
        </div>
      
      
  </body>
  
     <%@include file = "/common/down.inc" %>
</html>
