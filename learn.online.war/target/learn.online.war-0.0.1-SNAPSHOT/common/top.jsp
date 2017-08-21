<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

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

<body id="top">
<div class="wrapper col0">
  <div id="topbar">
    <div id="slidepanel">
      <div class="topbox">
        <h2><font color = "#FFFFFF">注册须知</font></h2>
        <p>Nullamlacus dui ipsum conseque loborttis non euisque morbi penas dapibulum orna. Urnaultrices quis curabitur phasellentesque congue magnis vestibulum quismodo nulla et feugiat. Adipisciniapellentum leo ut consequam ris felit elit id nibh sociis malesuada.</p>
        <p class="readmore"><a href="#">Continue Reading &raquo;</a></p>
      </div>
      <div class="topbox">
        <h2><font color = "#FFFFFF">管理员登录</font></h2>
        <%@ taglib uri = "/struts-tags" prefix = "s"  %>
         <s:form action = "Customerlogin" theme="simple" >
          <fieldset>
            <legend></legend>
            <label for="teachername">用户名:
             <s:textfield name = "yhm" label = "请输入用户名"  required = "true" key = "yhm.label" ></s:textfield>
            </label>
            <label for="teacherpass">密码:
              <s:password name = "dlpassword" label = "请输入登录密码"    required = "true" key = "dlpassword.label"></s:password>
            </label>
            <label for="teacherremember">
              <input class="checkbox" type="checkbox" name="teacherremember" id="teacherremember" checked="checked" />
              记住密码</label>
             默认： <input type = "radio" name = "login_in" value = "2" checked/>管理员
             <br/>
            <br/>
            <p>
              <s:submit value = "登录" ></s:submit>&nbsp;<s:reset value = "重置" ></s:reset>
            </p>
          </fieldset>
        </s:form>
      </div>
      <div class="topbox last">
        <h2><font color = "#FFFFFF">用户登录</font></h2>
        <s:form action = "Customerlogin" theme="simple" >
          <fieldset>
            <legend></legend>
            <label for="teachername">用户名:
             <s:textfield name = "yhm" label = "请输入用户名"  required = "true" key = "yhm.label" ></s:textfield>
            </label>
            <label for="teacherpass">密码:
              <s:password name = "dlpassword" label = "请输入登录密码"    required = "true" key = "dlpassword.label"></s:password>
            </label>
            <label for="teacherremember">
              <input class="checkbox" type="checkbox" name="teacherremember" id="teacherremember" checked="checked" />
              记住密码</label>
              选择：  <input type = "radio" name = "login_in" value = "0" checked/>教师
              <input type = "radio" name = "login_in" value = "1" />学生
               <br/>
            <br/>
            <p>
              <s:submit value = "登录" ></s:submit>&nbsp;<s:reset value = "重置" ></s:reset>
            </p>
          </fieldset>
        </s:form>
      </div>
      <br class="clear1" />
    </div>
    <div id="loginpanel">
      <ul>
        <li class="left">点击登录 &raquo;</li>
        <li class="right" id="toggle"><a id="slideit" href="#slidepanel">用户登录</a><a id="closeit" style="display: none;" href="#slidepanel">关闭面板</a></li>
      </ul>
    </div>
    <br class="clear1" />
  </div>
</div>



<div class="wrapper row1">
  <div id="header" class="clear">
    <div class="fl_left">
      <h1><a href="index.jsp">易学网</a></h1>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;————开启学霸模式</p>
    </div>
    <div class="fl_right">
      <p><a href="view/user/register.jsp">注册</a> | <a href="view/user/logout.jsp">注销</a>| <a href="#">帮助</a></p>
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
        <li class="last"><a href="#">网站向导</a></li>
      </ul>
    </div>
  </div>
</div>