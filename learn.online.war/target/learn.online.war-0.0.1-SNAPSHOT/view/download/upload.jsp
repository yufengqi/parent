<%@ page language="java" import="java.util.*" pageEncoding = "utf-8"%>

<%
  response.setCharacterEncoding("utf-8");
 %>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>upload</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 
</head>
       <%@ include file = "/common/head.inc"%>
<body>

		<script type="text/javascript">

<!--addMore函数可以提供上传多个文件上传-->

function addMore()
{

	var td = document.getElementById("more");
	
	var br = document.createElement("br");
	var input = document.createElement("input");
	var button = document.createElement("input");
	
	input.type = "file";
	input.name = "upload";
	
	button.type = "button";
	button.value = "   删除    ";
	
	button.onclick = function()
	{
		td.removeChild(br);
		td.removeChild(input);
		td.removeChild(button);
	}
	
	td.appendChild(br);
	td.appendChild(input);
	td.appendChild(button);
}

</script>

		<!--<h3><font color="red">上传文件类型后缀为doc,ppt,xls,pdf,txt,java，每个文件大小不能大于50M</font></h3>-->

		<table align="center" width="50%">
			<tr>
				<td>

					<!--		<s:actionerror cssStyle="color:red"/>-->
					<s:fielderror cssStyle="color:red" />

				</td>
			</tr>
		</table>
		
		
			
			
			
			 <table align = "center" id = "tablehead">
	     <tr>
		   <td align = "center">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
	       <h1><font face = "楷体">上传文件</font></h1><br></td>
		 </tr>
        </table>
       <!-- form method = "post" name = "pageform" action = "#"-->
       <s:form action="upload.action" theme="simple" method="post"
			enctype="multipart/form-data">
            <table border = "1" id = "tables" align = "center">
				<tr>
                   <td><s:file name="upload"></s:file>
						<input type="button" value="上传更多..." onclick="addMore()"></td>
                </tr>
                <tr>
                   <td><s:submit value=" 确认 "></s:submit></td>
                </tr>
      </table>
      </s:form>
  </body>
<%@ include file = "/common/down.inc"%>
</html>
