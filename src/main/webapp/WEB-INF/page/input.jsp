<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String currentusername = (String)session.getAttribute("username");
	Integer currentuserid = (Integer)session.getAttribute("userid");
	Integer currentpost = (Integer)session.getAttribute("post");
%>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript">
		 $(function(){
            	  $("#btn4").click(function(){
            		  var account={
            				  'applyid':$("#applyid").val(),
            				  'userid':$("#userid").val(),
            				  'post':$("#applypost").val(),
            				  'username':$("#applyname").val(),
            				  'days':$("#days").val(),
            				  'extrapay':$("#extrapay").val(),
            				  'startdate':$("#startdate").val(),
            				  'budget':$("#budget").val(),
            				  'hotelpay':$("#hotelpay").val(),
            				  'ticketpay':$("#ticketpay").val(),
            				  'mealpay':$("#mealpay").val(),
            				  'adminmsg':$("#adminmsg").val()
            		  };
            		  //alert(apply.startdate);
            		  var re=/^[0-9]$/;
            		  if(account.days==""||(isNaN(account.days))||(!re.test(account.days)))
            		  {
            				alert("出差天数输入错误");
            				return;
            		  }
            		  if(account.extrapay==""||(isNaN(account.extrapay))||account.extrapay<0)
            		  {
            				alert("额外费用输入错误");
            				return;
            		  }
            		  if(account.startdate=="")
            		  {
          				alert("还未输入出发日期");
          				return;
          		      }
            		  if(account.hotelpay==""||(isNaN(account.hotelpay))||account.hotelpay<0)
            		  {
            				alert("旅馆费用输入错误");
            				return;
            		  }
            		  if(account.mealpay==""||(isNaN(account.mealpay))||account.mealpay<=0)
            		  {
            				alert("餐饮费用输入错误");
            				return;
            		  }
            		  if(account.ticketpay==""||(isNaN(account.ticketpay))||account.ticketpay<=0)
            		  {
            				alert("交通费用输入错误");
            				return;
            		  }
            		  if(account.adminmsg.length>140)
            		  {
            				alert("管理员备注应该在140个字符以内");
            				return;
            		  }
                      $.ajax({                           	  
                          url: '${ctx}/account/add',
                          data: account,                  
                          success: function (msg) {                      
                          if (msg == "mdzz"){ 
                        	  alert("提交成功");
                        	  location.href = "${ctx}/apply/findunAccount";
                          }    
                          else{
                        	  alert("输入错误！请重新输入");
                          }
                           }              
                       });          
            	  });
            	  $("#logo").click(function(){
    		 		  var current="<%=(Integer)session.getAttribute("userid")%>";
    		 		  if (current != "null") 
    		 		  {
    		 		  	if(confirm("确定要退出登录吗"))
    		 		     {
    		 		  		alert("退出成功"); 
    						window.location.href = "${ctx}/user/logout";
    		 		     }
    		 		  }
    		 		  else{
    		 		  window.location.href = "${ctx}/index.jsp";
    		 		  }
    		 	  }); 
            	  
            	  $("#shit").click(function(){
            		  var current="<%=(Integer)session.getAttribute("userid")%>";
            		  if (current != "null") 
            		  {
            		  	if(confirm("确定要退出登录吗"))
            		     {
            			 //< session.invalidate();%>
            		  		alert("退出成功"); 
          				  window.location.href = "${ctx}/user/logout";
            		     }
            		  }
            		  else
            			  {
            			  window.location.href = "${ctx}/index.jsp";
            			  }
            	  });     
    		 });
</script>	
<html>
<head>
  <title>公司差旅系统</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="keywords" content="admin, dashboard, bootstrap, template, flat, modern, theme, responsive, fluid, retina, backend, html5, css, css3">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="image/png">

  <!--icheck-->
  <link href="${ctx}/AdminEx/js/iCheck/skins/minimal/minimal.css" rel="stylesheet">
  <link href="${ctx}/AdminEx/js/iCheck/skins/square/square.css" rel="stylesheet">
  <link href="${ctx}/AdminEx/js/iCheck/skins/square/red.css" rel="stylesheet">
  <link href="${ctx}/AdminEx/js/iCheck/skins/square/blue.css" rel="stylesheet">

  <!--dashboard calendar-->
  <link href="${ctx}/AdminEx/css/clndr.css" rel="stylesheet">

  <!--Morris Chart CSS -->
  <link rel="stylesheet" href="${ctx}/AdminEx/js/morris-chart/morris.css">

  <!--common-->
  <link href="${ctx}/AdminEx/css/style.css" rel="stylesheet">
  <link href="${ctx}/AdminEx/css/style-responsive.css" rel="stylesheet">




  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="sticky-header" style="font-family:'楷体';">

<section>
    <!-- left side start-->
    <div class="left-side sticky-left-side">
	<div class="logo">
            <img src="${ctx}/AdminEx/images/temp10.png" alt="">
        </div>
            <!--sidebar nav start-->
            <ul class="nav nav-pills nav-stacked custom-nav">
                <li><a href="${ctx}/user/editLoad?userid=<%out.print(currentuserid);%>"><i class="fa fa-cogs"></i> <span>个人中心</span></a></li>
                <li class="menu-list"><a href="#"><i class="fa fa-file-text"></i> <span>申请单</span></a>
                    <ul class="sub-menu-list">
                    	<c:if test="${sessionScope.post>1}">
                        	<li><a href="${ctx}/city/jumpapply">填写申请表</a></li>
                        </c:if>
                        <c:if test="${sessionScope.post==1}">
						<li><a href="${ctx}/apply/findBuncheck">审核申请表</a></li>
                        </c:if>
                        <c:if test="${sessionScope.post==2}">
						<li><a href="${ctx}/apply/findEuncheck">审核申请表</a></li>
                        </c:if>
                        <c:if test="${sessionScope.post>1}">
						<li><a href="${ctx}/apply/findbyid">查看我的申请</a></li>
						</c:if>
						<c:if test="${sessionScope.post<3}">
						<li><a href="${ctx}/apply/findAll">查看员工申请</a></li>
						</c:if>
                    </ul>
                </li>
                <c:if test="${sessionScope.post==2||sessionScope.post==3}">
                	<li class="menu-list"><a href="#"><i class="fa fa-bar-chart-o"></i> <span>我的报表</span></a>
                    	<ul class="sub-menu-list">
							<li><a href="${ctx}/account/findbyid">查看详细表单</a></li>
							<li><a href="${ctx}/account/findMymonth">查看图表</a></li>
				  		</ul>
				 	</li>
                 </c:if>
                <c:if test="${sessionScope.post<3}">
                	<li class="menu-list"><a href="#"><i class="fa fa-bar-chart-o"></i> <span>员工报表</span></a>
                    	<ul class="sub-menu-list">
							<li><a href="${ctx}/account/findAll">查看详细表单</a></li>
							<li><a href="${ctx}/account/findAllmonth">查看图表</a></li>
				  	</ul>
				  	</li>
                </c:if>
                <c:if test="${sessionScope.post==0}">
                	<li class="menu-list"><a href="#"><i class="fa fa-tasks"></i> <span>审核注册</span></a>
                    	<ul class="sub-menu-list">
                        	<li><a href="${ctx}/user/checklist">注册审核</a></li>
                        	<li><a href="${ctx}/apply/findunAccount">出差录入</a></li>
                    </ul>
                </li>
				</c:if>
                <li id="logo"><a href="#"><i class="fa fa-sign-in"></i> <span>退出</span></a></li>

            </ul>
            <!--sidebar nav end-->

        </div>
    </div>
    <div class="main-content" >

        <!-- header section start-->
        <div class="header-section">

            <!--toggle button start-->
            <a class="toggle-btn"><i class="fa fa-bars"></i></a>
            <!--toggle button end-->

            <!--search start-->
            <!--  <form class="searchform" action="index.html" method="post">
                <input type="text" class="form-control" name="keyword" placeholder="Search here..." />
            </form> -->
            <!--search end-->

            <!--notification menu start -->
            <div class="menu-right">
                <ul class="notification-menu">
                    <li>
                        <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <!-- <img src="images/photos/user-avatar.png" alt="" /> -->
                             <%
							if (currentusername != null) {
								out.print(currentusername);
							}else{
								out.print("未登录,返回主页");
							}
							%>
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                            <li><a href="${ctx}/user/editLoad?userid=<%out.print(currentuserid);%>"><i class="fa fa-user"></i>个人中心</a></li>
                            <li id="shit"><a href="#"><i class="fa fa-sign-out"></i>退出</a></li>
                        </ul>
                    </li>

                </ul>
            </div>
            <!--notification menu end -->

        </div>
    <div class="wrapper">
        	<div class="row">
            <div class="col-md-12">

                <div class="panel" data-collapsed="0">

                    <div class="panel-heading">
                        <div class="panel-title">
                           	<strong>录入出差详细信息</strong>
                        </div>
                    </div>

                    <div class="panel-body">

                        <div class="row">
                        	<input type="hidden" id="applypost" value="${applypost}" name="applypost"/>
                            <div class="col-md-4 form-group">姓名：
                            	<input type="text" id="applyname" name="applyname" value="${applyname}" class="form-control input-lg m-bot15" readOnly=true />
                           	</div>
							<div class="col-md-4 form-group">工号：
                            	<input type="text" id="userid" name="userid" value="${userid}" class="form-control input-lg m-bot15" readOnly=true />
                           	</div>
                           	<div class="col-md-4 form-group">申请单号：
                            	<input type="text" id="applyid" name="applyid" value="${applyid}" class="form-control input-lg m-bot15" readOnly=true />
                           	</div>

                            <div class="col-md-4 form-group">申请费用：
                            	<input type="text" id="budget" name="budget" value="${budget}" class="form-control input-lg m-bot15" readOnly=true />
                           	</div>
                           	<div class="col-md-4 form-group">出发日期：
                            	<input id="startdate" class="form-control input-lg m-bot15" type="text" placeholder="起始日" onfocus="WdatePicker()"/>
                           	</div>
                           	<div class="col-md-4 form-group">出发天数：
                            	<input type="text" id="days" placeholder="出差天数" class="form-control input-lg m-bot15"/>
                           	</div>
                           	
                           	<div class="col-md-3 form-group">餐饮费用：
                            	<input type="text" id="mealpay" placeholder="餐饮费用" class="form-control input-lg m-bot15"/>
                           	</div>
                           	<div class="col-md-3 form-group">旅店费用：
                            	<input type="text" id="hotelpay" placeholder="旅店费用" class="form-control input-lg m-bot15"/>
                           	</div>
                           	<div class="col-md-3 form-group">交通费用：
                            	<input type="text" id="ticketpay" placeholder="交通费用" class="form-control input-lg m-bot15"/>
                           	</div>
                           	<div class="col-md-3 form-group">额外费用：
                            	<input type="text" id="extrapay" placeholder="额外费用" class="form-control input-lg m-bot15"/>
                           	</div>
                           	
                           	<div class="col-md-12 form-group">管理员备注：
                           	<div class="form-group">
                                 <div class="col-md-12 col-md-12">
                                     <textarea id="adminmsg" name="message" rows="5" cols="80" class="form-control input-lg m-bot25" placeholder="140字以内"></textarea>
                                 </div>
                            </div></div></div>
						<div class=" ">
                             <p>
                                 <button id="btn4" class="btn btn-primary btn-lg" type="button">    提交             </button>
                             </p>
                         </div>
                    

                </div>

            </div>
        </div>
            
        </div>
        <!--body wrapper end-->

        <!--footer section start-->
        <footer style="position:fixed;bottom:0;">
            2014 &copy; AdminEx by <a href="#" target="_blank">源码之家</a>
        </footer>
        <!--footer section end-->


    </div>
    <!-- main content end-->
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="${ctx}/AdminEx/js/jquery-1.10.2.min.js"></script>
<script src="${ctx}/AdminEx/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${ctx}/AdminEx/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/AdminEx/js/bootstrap.min.js"></script>
<script src="${ctx}/AdminEx/js/modernizr.min.js"></script>
<script src="${ctx}/AdminEx/js/jquery.nicescroll.js"></script>

<!--easy pie chart-->
<script src="${ctx}/AdminEx/js/easypiechart/jquery.easypiechart.js"></script>
<script src="${ctx}/AdminEx/js/easypiechart/easypiechart-init.js"></script>

<!--Sparkline Chart-->
<script src="${ctx}/AdminEx/js/sparkline/jquery.sparkline.js"></script>
<script src="${ctx}/AdminEx/js/sparkline/sparkline-init.js"></script>

<!--icheck -->
<script src="${ctx}/AdminEx/js/iCheck/jquery.icheck.js"></script>
<script src="${ctx}/AdminEx/js/icheck-init.js"></script>

<!-- jQuery Flot Chart-->
<script src="${ctx}/AdminEx/js/flot-chart/jquery.flot.js"></script>
<script src="${ctx}/AdminEx/js/flot-chart/jquery.flot.tooltip.js"></script>
<script src="${ctx}/AdminEx/js/flot-chart/jquery.flot.resize.js"></script>


<!--Morris Chart-->
<script src="${ctx}/AdminEx/js/morris-chart/morris.js"></script>
<script src="${ctx}/AdminEx/js/morris-chart/raphael-min.js"></script>

<!--Calendar-->
<script src="${ctx}/AdminEx/js/calendar/clndr.js"></script>
<script src="${ctx}/AdminEx/js/calendar/evnt.calendar.init.js"></script>
<script src="${ctx}/AdminEx/js/calendar/moment-2.2.1.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js"></script>

<!--common scripts for all pages-->
<script src="${ctx}/AdminEx/js/scripts.js"></script>

<!--Dashboard Charts-->
<script src="${ctx}/AdminEx/js/dashboard-chart-init.js"></script>
</body>
</html>