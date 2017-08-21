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
<script type="text/JavaScript">
	
	function MM_CheckFlashVersion(reqVerStr,msg){
  with(navigator){
    var isIE  = (appVersion.indexOf("MSIE") != -1 && userAgent.indexOf("Opera") == -1);
    var isWin = (appVersion.toLowerCase().indexOf("win") != -1);
    if (!isIE || !isWin){  
      var flashVer = -1;
      if (plugins && plugins.length > 0){
        var desc = plugins["Shockwave Flash"] ? plugins["Shockwave Flash"].description : "";
        desc = plugins["Shockwave Flash 2.0"] ? plugins["Shockwave Flash 2.0"].description : desc;
        if (desc == "") flashVer = -1;
        else{
          var descArr = desc.split(" ");
          var tempArrMajor = descArr[2].split(".");
          var verMajor = tempArrMajor[0];
          var tempArrMinor = (descArr[3] != "") ? descArr[3].split("r") : descArr[4].split("r");
          var verMinor = (tempArrMinor[1] > 0) ? tempArrMinor[1] : 0;
          flashVer =  parseFloat(verMajor + "." + verMinor);
        }
      }
      // WebTV has Flash Player 4 or lower -- too low for video
      else if (userAgent.toLowerCase().indexOf("webtv") != -1) flashVer = 4.0;

      var verArr = reqVerStr.split(",");
      var reqVer = parseFloat(verArr[0] + "." + verArr[2]);
  
      if (flashVer < reqVer){
        if (confirm(msg))
          window.location = "http://www.macromedia.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash";
      }
    }
  } 
}
</script>
 
  




   </head>
   
    <%@ taglib uri = "/struts-tags" prefix = "s"  %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
   <body onLoad="MM_CheckFlashVersion('7,0,0,0','本页内容需要使用较新的 Macromedia Flash Player 版本。是否现在下载它？');">
  
  <div class="wrapper row3">
  <div id="container" class="clear">
    <!-- ####################################################################################################### -->
  
  
   <OBJECT id=WMP width="450" height="380" standby=Loading... classid=clsid:6BF52A52-394A-11D3-B153-00C04F79FAA6>
<PARAM NAME="URL" VALUE="http://class.qq.com/class/13013/p57813.html">
<PARAM NAME="rate" VALUE="1">
<PARAM NAME="balance" VALUE="0">
<PARAM NAME="currentPosition" VALUE="0"><PARAM NAME="playCount" VALUE="1">
<PARAM NAME="autoStart" VALUE="0">
<PARAM NAME="currentMarker" VALUE="0">
<PARAM NAME="invokeURLs" VALUE="-1">
<PARAM NAME="baseURL" VALUE="">
<PARAM NAME="volume" VALUE="50">
<PARAM NAME="defaultFrame" VALUE="">
<PARAM NAME="mute" VALUE="0">
<PARAM NAME="uiMode" VALUE="full">
<PARAM NAME="stretchToFit" VALUE="0">
<PARAM NAME="windowlessVideo" VALUE="0">
<PARAM NAME="enabled" VALUE="-1">
<PARAM NAME="enableContextMenu" VALUE="-1">
<PARAM NAME="fullScreen" VALUE="0">
<PARAM NAME="SAMIStyle" VALUE="">
<PARAM NAME="SAMILang" VALUE="">
<PARAM NAME="SAMIFilename" VALUE="">
<PARAM NAME="captioningID" VALUE="">
</OBJECT>
  
 
   <table width="905" height="800" border = "1" >
      <tr>
      <td width = "516" align="center" valign="top"><p>
        <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" width="448" height="336" id="FLVPlayer">
          <param name="movie" value="FLVPlayer_Progressive.swf" />
          <param name="salign" value="lt" />
          <param name="quality" value="high" />
          <param name="scale" value="noscale" />
          <param name="FlashVars" value="&MM_ComponentVersion=1&skinName=Clear_Skin_1&streamName=image/new/flv/%E3%80%8A%E5%88%9D%E8%A7%81%E3%80%8B------%E6%9D%91%E9%95%BF%E5%8E%9F%E5%88%9B%E6%AD%8C%E6%9B%B2&autoPlay=false&autoRewind=false" />
          <embed src="FLVPlayer_Progressive.swf" flashvars="&MM_ComponentVersion=1&skinName=Clear_Skin_1&streamName=image/new/flv/%E3%80%8A%E5%88%9D%E8%A7%81%E3%80%8B------%E6%9D%91%E9%95%BF%E5%8E%9F%E5%88%9B%E6%AD%8C%E6%9B%B2&autoPlay=false&autoRewind=false" quality="high" scale="noscale" width="448" height="336" name="FLVPlayer" salign="LT" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />              
        </object>
      </p>
      
    
        <table width="395" border="0" align = "left">
          <tr>
            <th width="492" scope="row" align = "left">课程名称:<s:property value = "#selectclass.classname"/></th>
          </tr>
          <tr>
            <th scope="row" align = "left">课时安排:<s:property value = "#selectclass.classtime"/></th>
          </tr>
          <tr>
            <th scope="row"  align = "left">使用教材:<s:property value = "#selectclass.classbook"/></th>
          </tr>
          <tr>
            <th scope="row" align = "left">知识基础:<s:property value = "#selectclass.classneedbase"/></th>
          </tr>
          <tr>
            <th scope="row" align = "left">大作业:<s:property value = "#selectclass.classwork"/></th>
          </tr>
        </table>    
       <br/>
       <br/>
      
         <table width="395" border="0" >
         <tr>
            <td align="left"><br/> <br/>
                相关连接:<br/> <br/> </td>
          </tr>
         <tr>
            <td align="left">
                &nbsp; &nbsp;<s:a href = "allclasses.action">课程介绍</s:a><br/> <br/>              </td>
          </tr>
          <s:if test="%{#session.register.getIdentity()==1}">
          <tr>
            <td align="left">
                &nbsp; &nbsp;<s:a href = "learnchooseclasses.action">课程选择</s:a> <br/> <br/>             </td>
          </tr>
         <tr>
            <td align="left">
                &nbsp; &nbsp;<s:a href = "allchooseclasses.action">已选课程</s:a> <br/> <br/>             </td>
          </tr>
          <tr>
             <td align="left">
               &nbsp; &nbsp;<s:a href = "allchooseclasses.action">作业提交</s:a> <br/> <br/>            </td>
          </tr>
          </s:if>
       </table>
        </td>
	   <td width="373" align="center" valign="top">
	   

  <div style=" width:430; height:auto; overflow:auto ">
    <div style=" margin-top:0">
       <iframe src="Allcontenthd.action" width="430"; height="880" frameborder="0" scrolling="auto" >
       </iframe>
     </div>
</div>  


	   
	  <!--  <s:action  name="Allcontenthd.action" executeResult="true"></s:action>   -->
	 
	   
	   </td>
	   </tr>
	   </table>
	   </div>
	   </div>


</body>
    <%@ include file = "/common/down.inc"%>
</html>
