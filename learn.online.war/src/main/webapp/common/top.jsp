<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head profile="http://gmpg.org/xfn/11">
<title>易学网</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="common/styles/layout.css" type="text/css" />
<!-- Homepage Specific Elements -->
    <link href="common/video-js/video-js.css"rel="stylesheet"/>
    <script src="common/video-js/video.js"></script>
<script type="text/javascript" src="common/scripts/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="common/scripts/jquery.timers.1.2.js"></script>
<script type="text/javascript"
	src="common/scripts/jquery.galleryview.2.1.1.min.js"></script>
<script type="text/javascript"
	src="common/scripts/jquery.galleryview.setup.js"></script>
	
<script type="text/javascript" src="common/scripts/jquery-ui-1.8.12.custom.min.js"></script>

<script type="text/javascript" src="common/scripts/jquery-1.4.1.min.js"></script>
<script type="text/javascript"
	src="common/scripts/jquery.slidepanel.setup.js"></script>
<script type="text/javascript"
	src="common/scripts/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript" src="common/scripts/jquery.tabs.setup.js"></script>

<link rel="stylesheet" href="editor/themes/default/default.css" />
<link rel="stylesheet" href="editor/plugins/code/prettify.css" />
<script charset="utf-8" src="editor/kindeditor.js"></script>
<script charset="utf-8" src="editor/lang/zh_CN.js"></script>
<script charset="utf-8" src="editor/plugins/code/prettify.js"></script>
<script type="text/javascript" src="common/My97DatePicker/WdatePicker.js"></script> 
<script type ="text/javascript" src="common/artDialog-5.0.3/source/artDialog.js?skin=default"></script>
<script type ="text/javascript" src="common/myself.js"></script>
<script>
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[id="desciption"||id="desciption1"||id="desciption2"||id="desciption3"||id="desciption4"||id="desciption5"]', {
			cssPath : '../plugins/code/prettify.css',
			uploadJson : '../jsp/upload_json.jsp',
			fileManagerJson : '../jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterBlur : function() {
				//判断是否输入了内容
				 this.sync();  
				var count = this.html(); //获取编辑器输入内容总数
				if(count == 0)
				{
				alert("您尚未输入内容!");
				this.focus();
				return false;
				}
				//判断输入个数
				if(count > 1000)
				{
				alert("输入字符不能够超过1000个!")
				this.focus();
				return false;
				}
			},
			//afterBlur: function(){this.sync();},
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
			}
		});
		prettyPrint();
	});
		
	  function chack()
	  {
	      if(form2.yhm.value.length==0)
		  {
		      alert("用户名不能为空！");
			  form2.yhm.focus();
			  return false;
		  }
		  if(form2.yhm.value.length<3 || form2.yhm.value.length>20)
		  {
			 /*  art.dialog({   
				    content: '用户名不能小于3位大于20位！'  
				});  */
		     alert("用户名不能小于3位大于20位！");
			  form2.yhm.focus();
			  return false;
		  }
		  if(form2.dlpassword.value.length==0)
		  {
		      alert("登陆密码不能为空！");
			  form2.dlpassword.focus();
			  return false;
		  }
		  if(form2.dlpassword.value.length<6 || form2.dlpassword.value.length>20)
		  {
		      alert("登陆密码不能低于6位大于20位！");
			  form2.dlpassword.value="";
			  return false;
		  }
		  if(form2.qrpassword.value.length==0)
		  {
		      alert("确认密码不能为空！");
			  form2.psw2.focus();
			  return false;
		  }
		  if(form2.qrpassword.value.length<6 || form2.qrpassword.value.length>20)
		  {
		      alert("确认密码不能低于6位大于20位！");
			  form2.qrpassword.value="";
			  return false;
		  }
		  if(form2.email.value.length==0)
		  {
		      alert("电子邮箱不能为空！");
			  form2.email.focus();
			  return false;
		  }
		  var yz = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w)*/;
		  if(!yz.test(form2.email.value))
		  {
		      alert("电子邮箱不正确！");
			  form2.email.value="";
			  return false;
		  }
		  if(form2.dlpassword.value.length != form2.qrpassword.value.length)
		  {
		      alert("登陆密码和确认密码不一致！");
			  form2.qrpassword.value="";
			  return false;
		  }
		
		   return true;
	  }
	  
	  function chackLogin()
	  {
		  if(form1.yhm.value.length<3 || form1.yhm.value.length>20)
		  {
			 /*  art.dialog({   
				    content: '用户名不能小于3位大于20位！'  
				});  */
		     alert("用户名不能小于3位大于20位！");
			  form1.yhm.focus();
			  return false;
		  }
		  if(form1.dlpassword.value.length<6 || form1.dlpassword.value.length>20)
		  {
		      alert("登陆密码不能低于6位大于20位！");
			  form1.dlpassword.value="";
			  return false;
		  }
		   return true;
	  }
	  
	  function chackLogin1()
	  {
	     
		  if(form.yhm.value.length<3 || form.yhm.value.length>20)
		  {
			 /*  art.dialog({   
				    content: '用户名不能小于3位大于20位！'  
				});  */
		     alert("用户名不能小于3位大于20位！");
			  form.yhm.focus();
			  return false;
		  }
		  if(form.dlpassword.value.length<6 || form.dlpassword.value.length>20)
		  {
		      alert("登陆密码不能低于6位大于20位！");
			  form.dlpassword.value="";
			  return false;
		  }
		   return true;
	  }
   </script>
   
   <script>
    videojs.options.flash.swf = "video-js.swf";
</script>

 <script type="text/javascript">
        $(function(){
            $("li").each(function(index){
                $(this).click(function(){ 
                    $("#topnav ul li a").removeClass("active");
                    $(this).addClass("active");
                });
            });                
        });
    </script>

<!-- End Homepage Specific Elements -->
</head>

<body id="top">
	<div class="wrapper col0">
		<div id="topbar">
			<div id="slidepanel">
				<div class="topbox">
					<h2>
						<font color="#FFFFFF">注册须知</font>
					</h2>
					<p>
1、上载、张贴、发布或传送任何非法、有害、胁迫、骚扰、侵害、中伤、粗俗、猥亵、诽谤 淫秽、侵害他人隐私、种族歧视的资讯、资料、文字、软件、音乐、照片、图形、信息或其他资料。
2、冒充任何人或机构，或以虚伪不实的方式谎称或使人误认为与任何人或任何机构有关。
3、将无权传送的内容（例如内部资料、机密资料）进行上载、张贴、发布、发送电子邮件以其他方式传送。
</p>
					<!-- <p class="readmore">
						<a href="javascript:window.open('common/portfolio.html')">阅读更多 &raquo;</a>
					</p> -->
				</div>
				<div class="topbox">
					<h2>
						<font color="#FFFFFF">管理员登录</font>
					</h2>
					<%@ taglib uri="/struts-tags" prefix="s"%>
					<s:form action="Customerlogin" theme="simple" name = "form1" onSubmit = "return chackLogin();">
						<fieldset>
							<legend></legend>
							<label for="teachername">用户名: <s:textfield name="yhm"
									label="请输入用户名" required="true" key="yhm.label"></s:textfield>
							</label> <label for="teacherpass">密码: <s:password
									name="dlpassword" label="请输入登录密码" required="true"
									key="dlpassword.label"></s:password> </label> <label
								for="teacherremember"> <input class="checkbox"
								type="checkbox" name="teacherremember" id="teacherremember"
								checked="checked" /> 记住密码</label> 默认： <input type="radio"
								name="login_in" value="2" checked />管理员 <br /> <br />
							<p>
								<s:submit value="登录"></s:submit>
								&nbsp;
								<s:reset value="重置"></s:reset>
							</p>
						</fieldset>
					</s:form>
				</div>
				<div class="topbox last">
					<h2>
						<font color="#FFFFFF">用户登录</font>
					</h2>
					<s:form action="Customerlogin" theme="simple" name = "form" onSubmit = "return chackLogin1();">
						<fieldset>
							<legend></legend>
							<label for="teachername">用户名: <s:textfield name="yhm"
									label="请输入用户名" required="true" key="yhm.label"></s:textfield>
							</label> <label for="teacherpass">密码: <s:password
									name="dlpassword" label="请输入登录密码" required="true"
									key="dlpassword.label"></s:password> </label> <label
								for="teacherremember"> <input class="checkbox"
								type="checkbox" name="teacherremember" id="teacherremember"
								checked="checked" /> 记住密码</label> 选择： <input type="radio"
								name="login_in" value="0" checked />教师 <input type="radio"
								name="login_in" value="1" />学生 <br /> <br />
							<p>
								<s:submit value="登录"></s:submit>
								&nbsp;
								<s:reset value="重置"></s:reset>
							</p>
						</fieldset>
					</s:form>
				</div>
				<br class="clear1" />
			</div>
			<div id="loginpanel">
				<ul>
					<li class="left">点击登录 &raquo;</li>
					<li class="right" id="toggle"><a id="slideit"
						href="#slidepanel">用户登录</a><a id="closeit" style="display: none;"
						href="#slidepanel">关闭面板</a>
					</li>
				</ul>
			</div>
			<br class="clear1" />
		</div>
	</div>



	<div class="wrapper row1">
		<div id="header" class="clear">
			<div class="fl_left">
				<h1>
					<a href="index.jsp">易学网</a>
				</h1>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;————开启学霸模式</p>
			</div>
			<div class="fl_right">
				<p>
					<a href="view/user/register.jsp">注册</a> | 
						 <a href="#">帮助</a>
				</p>
				<form action="#" method="post" id="sitesearch">
					<fieldset>
						<legend>Site Search</legend>
						<input type="text" value="输入搜索关键字..."
							onfocus="this.value=(this.value=='Search Our Website&hellip;')? '' : this.value ;" />
						<input type="image" src="common/images/search.gif" id="search"
							alt="Search" />
					</fieldset>
				</form>
			</div>
			<div id="topnav">
				<ul>
					<li class = "active"><a href="allpublicnotice.action">首页</a>
					</li>
					<li><a href="allclasses.action">介绍</a>
					</li>
					<li><a href="view/learnonline/learnonline.jsp">在线教学</a>
					</li>
					<li><a href="loaddownall.action">下载区</a>
					</li>
					<li><a href="Allcontent.action">留言版</a>
					</li>
					<li><a href="allpassforuminfo.action?tag=4">论坛</a>
					</li>
					<li class="last"><a href="#">网站向导</a>
					</li>
				</ul>
			</div>
			</div>
	</div>
	
	<div class="wrapper row2">
  <div id="hpage_featured" class="clear">
   <div id="left_column">
  <div class="holder">
        <h2 class="title">网络·分享·学习</h2>
       <p><img src="common/images/demo/dh.jpg" alt="" />
        <img src="common/images/demo/dh1.jpg" alt="" />
         <img src="common/images/demo/dh3.jpg" alt="" /></p>
      </div>
    </div>
   </div>
   </div>
    <!-- ############ -->
			
  <div class="wrapper row2">
  <div id="hpage_featured" class="clear">
			 <div class="intro clear" >
      <div class="welcome clear"><img class="imgl" src="common/images/5.jpg" alt="" />
        <div class="fl_right">
          <h2>Welcome to Our 易学网</h2>
          <p>在这里，可以找你的知音；在这里，可以遇见你的伯乐；在这里，可以畅游知识的海洋；在这里，可以分享属于你的精彩！</p>
        </div>
      </div>
 
    </div>
    </div>
    </div>
			
			
		
	
	
	