<%@ page pageEncoding = "utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head profile="http://gmpg.org/xfn/11">
<title>易学网</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="common/styles/layout.css" type="text/css" />
<!-- Homepage Specific Elements -->

<script type="text/javascript" src="common/scripts/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="common/scripts/jquery.timers.1.2.js"></script>
<script type="text/javascript" src="common/scripts/jquery.galleryview.2.1.1.min.js"></script>
<script type="text/javascript" src="common/scripts/jquery.galleryview.setup.js"></script>

<script type="text/javascript" src="common/scripts/jquery-1.4.1.min.js"></script>
<script type="text/javascript" src="common/scripts/jquery.slidepanel.setup.js"></script>
<script type="text/javascript" src="common/scripts/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript" src="common/scripts/jquery.tabs.setup.js"></script>


<!-- End Homepage Specific Elements -->



</head>

<%@ taglib uri = "/struts-tags" prefix = "s"  %>

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
        <li class="active"><a href="allpublicnotice.action">首页</a></li>
        <li><a href="allclasses.action">介绍</a></li>
        <li><a href="view/learnonline/learnonline.jsp">在线教学</a></li>
        <li><a href="loaddownall.action">下载区</a></li>
        <li><a href="Allcontent.action">留言版</a></li>
        <li><a href="allpassforuminfo.action?tag=4">论坛</a></li>
        <li><a href="view/user/personal.jsp">个人中心</a></li>
        <li class="last"><a href="#">网站向导</a></li>
      </ul>
    </div>
  </div>
</div>
</div>