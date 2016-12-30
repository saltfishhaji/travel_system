<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String currentusername = (String)session.getAttribute("username");
	Integer currentuserid = (Integer)session.getAttribute("userid");
	Integer currentpost = (Integer)session.getAttribute("post");
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#logo").click(function(){
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
    <!-- left side end-->
    
    <!-- main content start-->
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
                           	<strong>员工详细报表单</strong>
                        </div>
                    </div>
                    <div class="panel-body">
                    <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline" role="grid">
                    <div class="adv-table">
                    		<table  class="display table table-bordered table-striped dataTable" aria-describedby="dynamic-table_info" style="table-layout:fixed;">
  								<thead>
  									<tr>
  										<th align=center style="vertical-align: middle;">表单号</th>
  										<th align=center style="vertical-align: middle;">工号</th>
  										<th align=center style="vertical-align: middle;">姓名</th>
  										<th align=center style="vertical-align: middle;">出发地</th>
  										<th align=center style="vertical-align: middle;">目的地</th>
  										<th align=center style="vertical-align: middle;">出发工具</th>
  										<th align=center style="vertical-align: middle;">返程工具</th>
  										<th align=center style="width:85px;vertical-align: middle;">出发日期</th>
  										<th align=center style="vertical-align: middle;">天数</th>
		  								<th align=center style="vertical-align: middle;">额外费用</th>
		  								<!-- <th align=center>住宿费</th>
		  								<th align=center>交通费</th>
		  								<th align=center>餐费</th>-->
		  								<th align=center style="vertical-align: middle;">总费用</th>
		  								<th align=center style="vertical-align: middle;">申报费用</th>
		  								<th align=center style="vertical-align: middle;">节约费用</th>
		  								<th align=center style="width:250px;vertical-align: middle;">备注</th>
  									</tr>
  								</thead>
  								<tbody>
  									<c:forEach items="${showaccountList}"  var="account">
     									<tr>
     										<td align=center style="vertical-align: middle;">${account.applyid}</td>
  											<td align=center style="vertical-align: middle;">${account.userid}</td>
  											<td align=center style="vertical-align: middle;">${account.username}</td>
  											<td align=center style="vertical-align: middle;">${account.start}</td>
  											<td align=center style="vertical-align: middle;">${account.destiny}</td>
  											<td align=center style="vertical-align: middle;">${account.tovehicle}</td>
  											<td align=center style="vertical-align: middle;">${account.backvehicle}</td>
  											<td align=center style="white-space: nowrap;vertical-align: middle;">
				  								<fmt:formatDate
													type="date"
													value="${account.startdate}"
													dateStyle="default"
												/> 
											</td>
				  							<td align=center style="vertical-align: middle;">${account.days}</td>
				  							<td align=center style="vertical-align: middle;">${account.extrapay}</td>
				  							<td align=center style="vertical-align: middle;">${account.totalbudget}</td>
				  							<td align=center style="vertical-align: middle;">${account.budget}</td>
				  							<td align=center style="vertical-align: middle;">${account.savings}</td>
				  							<td align=center style="word-wrap:break-word;vertical-align: middle;">${account.adminmsg}</td>
				  						</tr>
				    				</c:forEach>
				    			</tbody>
  							</table>
  							</div>
  							</div>
                    	</div>
                    </div>
         			<div align="center">
               			<a href="${pageContext.request.contextPath}/account/findbyid">首页</a>
               			<c:if test="${pageModel.pageNo>1}"><a href="${pageContext.request.contextPath}/account/findbyid?pageNo=${pageModel.pageNo-1}">上一页</a></c:if>
           				<c:if test="${pageModel.pageNo<pageModel.totalpage}"><a href="${pageContext.request.contextPath}/account/findbyid?pageNo=${pageModel.pageNo+1}">下一页</a></c:if>
       					<c:if test="${pageModel.totalpage!=0}"><a href="${pageContext.request.contextPath}/account/findbyid?pageNo=${pageModel.totalpage}">尾页</a></c:if>
                                           	 总页数:${pageModel.totalpage}
                                          	  总数量:${pageModel.totalrecode}
                                          	  当前页:${pageModel.pageNo}
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

<script type="text/javascript" language="javascript" src="${ctx}/AdminEx/js/advanced-datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="${ctx}/AdminEx/js/data-tables/DT_bootstrap.js"></script>
		<!--dynamic table initialization -->
<script src="${ctx}/AdminEx/js/dynamic_table_init.js"></script>
<!-- Placed js at the end of the document so the pages load faster -->
<script src="${ctx}/AdminEx/js/jquery-1.10.2.min.js"></script>
<script src="${ctx}/AdminEx/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="${ctx}/AdminEx/js/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctx}/AdminEx/js/bootstrap.min.js"></script>
<script src="${ctx}/AdminEx/js/modernizr.min.js"></script>
<script src="${ctx}/AdminEx/js/jquery.nicescroll.js"></script>

<script src="${ctx}/AdminEx/js/ios-switch/switchery.js" ></script>
<script src="${ctx}/AdminEx/js/ios-switch/ios-init.js" ></script>
<script type="text/javascript" src="${ctx}/AdminEx/js/jquery-multi-select/js/jquery.multi-select.js"></script>
<script type="text/javascript" src="${ctx}/AdminEx/js/jquery-multi-select/js/jquery.quicksearch.js"></script>
<script src="${ctx}/AdminEx/js/multi-select-init.js"></script>
<!--Sparkline Chart-->
<script src="${ctx}/AdminEx/js/sparkline/jquery.sparkline.js"></script>
<script src="${ctx}/AdminEx/js/sparkline/sparkline-init.js"></script>

<!--icheck -->
<script src="${ctx}/AdminEx/js/iCheck/jquery.icheck.js"></script>
<script src="${ctx}/AdminEx/js/icheck-init.js"></script>

<script type="text/javascript" src="${ctx}/AdminEx/js/fuelux/js/spinner.min.js"></script>
<script src="${ctx}/AdminEx/js/spinner-init.js"></script>
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