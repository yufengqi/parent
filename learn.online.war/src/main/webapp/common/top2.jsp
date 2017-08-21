<%@ page pageEncoding = "utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head profile="http://gmpg.org/xfn/11">
<title>易学网</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="common/styles/layout.css" type="text/css" />
<!-- Homepage Specific Elements -->
   <link href="http://vjs.zencdn.net/4.6/video-js.css"rel="stylesheet"/>
    <script src="http://vjs.zencdn.net/4.6/video.js"></script>
<script type="text/javascript" src="common/scripts/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="common/scripts/jquery.timers.1.2.js"></script>
<script type="text/javascript" src="common/scripts/jquery.galleryview.2.1.1.min.js"></script>
<script type="text/javascript" src="common/scripts/jquery.galleryview.setup.js"></script>
<script type="text/javascript" src="common/scripts/jquery-ui-1.8.12.custom.min.js"></script>
<script type="text/javascript" src="common/scripts/jquery-1.4.1.min.js"></script>
<script type="text/javascript" src="common/scripts/jquery.slidepanel.setup.js"></script>
<script type="text/javascript" src="common/scripts/jquery-ui-1.7.2.custom.min.js"></script>
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

<div class="wrapper row1">
  <div id="header" class="clear">
    <div class="fl_left">
      <h1><a href="index.html">易学网</a></h1>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;————开启学霸模式</p>
    </div>
    <div class="fl_right">
      <p> <a href="view/user/logout.jsp">注销</a>| <a href="#">帮助</a></p>
      <form action="#" method="post" id="sitesearch">
        <fieldset>
          <legend>Site Search</legend>
          <input type="text" value="输入搜索关键字..." onfocus="this.value=(this.value=='Search Our Website&hellip;')? '' : this.value ;" />
          <input type="image" src="common/images/search.gif" id="search" alt="Search" />
        </fieldset>
      </form>
    </div>
    <div id="topnav">
      <ul>
        <li><a href="publicnoticemanage.action">公告管理</a></li>
        <li><a href="classmanage.action">课程管理</a></li>
        <li><a href="loaddownall.action">文件管理</a></li>
        <li><a href="allforuminfo.action">论坛管理</a></li>
        <li><a href="Allcontent.action">留言管理</a></li>
        <li><a href="getAll.action">用户管理</a></li>
        <li><a href="view/user/personal.jsp">个人中心</a></li>
        <li class="last"><a href="#">网站向导</a></li>
      </ul>
    </div>
  </div>
</div>