<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'learnonline.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
$(document).ready(function () {
    $("#portfolio").tabs({
        event: "click"
    });
});
</script>
<!-- End Portfolio Specific Elements -->
</head>


<%@ include file = "/common/head.inc"%>
   </head>
   
    <%@ taglib uri = "/struts-tags" prefix = "s"  %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<body id="top">
<div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->
   
    <s:if test="%{#session.register.getIdentity()!=''}">
   
    <div id="portfolio">
      <div class="fl_left">
        <!-- ########### -->
        <div id="tabs-1">
          <div class="media">

            <h2>在线学习互动</h2>
            <!-- Begin Flash Here - This is the correct method for W3C validation -->
          <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" width="448" height="336" id="FLVPlayer">
          <param name="movie" value="<s:property value = "#selectclass.classlink"/>" />
          <param name="salign" value="lt" />
          <param name="quality" value="high" />
          <param name="scale" value="noscale" />
          <param name="FlashVars" value="&MM_ComponentVersion=1&skinName=Clear_Skin_1&streamName=image/new/flv/%E3%80%8A%E5%88%9D%E8%A7%81%E3%80%8B------%E6%9D%91%E9%95%BF%E5%8E%9F%E5%88%9B%E6%AD%8C%E6%9B%B2&autoPlay=false&autoRewind=false" />
          <embed src="<s:property value = "#selectclass.classlink"/>" flashvars="&MM_ComponentVersion=1&skinName=Clear_Skin_1&streamName=image/new/flv/%E3%80%8A%E5%88%9D%E8%A7%81%E3%80%8B------%E6%9D%91%E9%95%BF%E5%8E%9F%E5%88%9B%E6%AD%8C%E6%9B%B2&autoPlay=false&autoRewind=false" quality="high" scale="noscale" width="448" height="336" name="FLVPlayer" salign="LT" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />              
        </object>
         
        <%--  <video id="my_video_1"controls
preload="auto"width="450"height="380"poster="my_video_poster.png"
data-setup="{}">
 <source src="http://swf.ws.126.net/openplayer/v02/-0-2_M704DL00G_M704EAUC4-vimg1_ws_126_net//image/snapshot_movie/2011/8/8/C/M79KNCB8C-1421720937445.swf" type='video/swf'>
 <source src="my_video.webm" type='video/webm'>
</video> --%>
            <!-- End Flash Here -->
          </div>
          <div class="mediadetails">
            <p>课程名称:<s:property value = "#selectclass.classname"/></p>
            <p>课时安排:<s:property value = "#selectclass.classtime"/></p>
            <p>使用教材:<s:property value = "#selectclass.classbook"/></p>
            <p>知识基础:<s:property value = "#selectclass.classneedbase"/></p>
            <p>大作业:<s:property value = "#selectclass.classwork"/></p>
          </div>
        </div>
        <!-- ########### -->
        <br>
        <div id="tabs-2">
          <h2>教学计划</h2>
          <div class="media"><img src="images/demo/450x380.gif" alt="" /></div>
          <div class="mediadetails">
            <p> <s:property value = "#selectclass.classplan"/></p>
          </div>
        </div>
        <!-- ########### -->
        <br>
        <div id="tabs-3">
          <h2>相关连接:</h2>
          <div class="media"><img src="images/demo/450x380.gif" alt="" /></div>
          <div class="mediadetails">
          <p><s:a href = "allclasses.action">课程介绍</s:a><s:if test="%{#session.register.getIdentity()==1}">&nbsp; &nbsp;<s:a href = "learnchooseclasses.action">课程选择</s:a> </p> 
           <p><s:a href = "allchooseclasses.action">已选课程</s:a>&nbsp; &nbsp;<s:a href = "allchooseclasses.action">作业提交</s:a></s:if></p>
          </div>
        </div>
        <!-- ########### -->
      </div>

<div style=" width:430; height:auto; overflow:auto " id="featured">
    <div style=" margin-top:0">
       <iframe src="Allcontenthd.action" width="430"; height="880" frameborder="0" scrolling="auto" >
       </iframe>
     </div>
</div>  

    </div>
    
    </s:if>
    <s:else >
     
      <div id="portfolio">
      <div class="fl_left">
        <!-- ########### -->
        <div id="tabs-1">
          <div class="media">

            <h2>在线学习互动</h2>
            <!-- Begin Flash Here - This is the correct method for W3C validation -->
          <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" width="448" height="336" id="FLVPlayer">
          <param name="movie" value="http://swf.ws.126.net/openplayer/v02/-0-2_M704DL00G_M704EAUC4-vimg1_ws_126_net//image/snapshot_movie/2011/8/8/C/M79KNCB8C-1421720937445.swf" />
          <param name="salign" value="lt" />
          <param name="quality" value="high" />
          <param name="scale" value="noscale" />
          <param name="FlashVars" value="&MM_ComponentVersion=1&skinName=Clear_Skin_1&streamName=image/new/flv/%E3%80%8A%E5%88%9D%E8%A7%81%E3%80%8B------%E6%9D%91%E9%95%BF%E5%8E%9F%E5%88%9B%E6%AD%8C%E6%9B%B2&autoPlay=false&autoRewind=false" />
          <embed src="http://swf.ws.126.net/openplayer/v02/-0-2_M704DL00G_M704EAUC4-vimg1_ws_126_net//image/snapshot_movie/2011/8/8/C/M79KNCB8C-1421720937445.swf" flashvars="&MM_ComponentVersion=1&skinName=Clear_Skin_1&streamName=image/new/flv/%E3%80%8A%E5%88%9D%E8%A7%81%E3%80%8B------%E6%9D%91%E9%95%BF%E5%8E%9F%E5%88%9B%E6%AD%8C%E6%9B%B2&autoPlay=false&autoRewind=false" quality="high" scale="noscale" width="448" height="336" name="FLVPlayer" salign="LT" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />              
        </object>
         
        <%--  <video id="my_video_1"controls
preload="auto"width="450"height="380"poster="my_video_poster.png"
data-setup="{}">
 <source src="http://swf.ws.126.net/openplayer/v02/-0-2_M704DL00G_M704EAUC4-vimg1_ws_126_net//image/snapshot_movie/2011/8/8/C/M79KNCB8C-1421720937445.swf" type='video/swf'>
 <source src="my_video.webm" type='video/webm'>
</video> --%>
            <!-- End Flash Here -->
          </div>
          <div class="mediadetails">
            <p>课程名称:杜波依斯与大萧条时期 </p>
            <p>课时安排:长期有效</p>
            <p>使用教材:杜波依斯与大萧条时期 </p>
            <p>知识基础:一般历史</p>
            <p>大作业:无</p>
          </div>
        </div>
        <!-- ########### -->
        <br>
        <div id="tabs-2">
          <h2>教学计划</h2>
          <div class="media"><img src="images/demo/450x380.gif" alt="" /></div>
          <div class="mediadetails">
            <p> 一般都是自己安排的哦~，自主性很大，空间很大的自主学习平台。
                   本课程聚焦为了非裔美国人的自由和正义而斗争的代表人物，包括Martin Luther King，Barack Obama等，介绍非裔美国人的历史，尤其是1930年后的政治思潮和抗争运动。
            </p>
          </div>
        </div>
        <!-- ########### -->
        <br>
        <div id="tabs-3">
          <h2>相关连接:</h2>
          <div class="media"><img src="images/demo/450x380.gif" alt="" /></div>
          <div class="mediadetails">
          <p><s:a href = "allclasses.action">课程介绍</s:a><s:if test="%{#session.register.getIdentity()==1}">&nbsp; &nbsp;<s:a href = "learnchooseclasses.action">课程选择</s:a> </p> 
           <p><s:a href = "allchooseclasses.action">已选课程</s:a>&nbsp; &nbsp;<s:a href = "allchooseclasses.action">作业提交</s:a></s:if></p>
          </div>
        </div>
        <!-- ########### -->
      </div>
      </div>
   
    
    </s:else>
    
    <!-- ####################################################################################################### -->
  </div>
</div>

</body>
    <%@ include file = "/common/down.inc"%>
</html>
