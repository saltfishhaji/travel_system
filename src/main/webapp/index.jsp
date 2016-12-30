<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript">
		 $(function(){
			/* $("#fail").hide();
   		  	 $("#unchecked").hide();
   		     $("#rejected").hide();
   		  	 $("#useridError").hide();
   		  	 $("#userPwdError").hide();*/
             $("#btn").click(function(){
            		var user={'userid':document.getElementById('userid').value,'password':document.getElementById('password').value};
            		//获取输入的用户名和密码将其赋值给temp进行判断和传值
          			//最后提交时用于记录所有的输入是否合法的简单判断，如有一个不合法则不提交至后台
          			/*$("#useridError").hide();
        			$("#userPwdError").hide();*/
        			var re=/^[0-9]*/;
        			if(user.userid==""||(isNaN(user.userid))||(!re.test(user.userid))){
        				//$("#useridError").show();
        				alert("非法工号");
        				return;
        			}
        			var regPwd=/[a-zA-Z0-9]*/;
                    if(user.password=="" || user.password.length < 3 || user.password.length > 50||(!regPwd.test(user.password ))){
                       // $("#userPwdError").show();
                       alert("非法密码");
                       return;
                    }
                      $.ajax({                           	  
                          url: '${ctx}/user/login',                  
                          type: 'POST',                  
                          data: user,                  
                          success: function (msg) {                      
                          if (msg == "login"){ 
                        	  //alert("hehe");
                        	  location.href = "${ctx}/user/jumphome";
                          }
                          else if(msg=="mdzz")
                        {
                        	  alert("你被管理员拒绝了 请重新注册");
                        	  /*$("#rejected").dialog({
                       		      modal: true
                       		    });*/
                        }
                          else if(msg=="fail")
                        {
                        	  alert("还未通过管理员审核，请等待");
                        	  /*$("#unchecked").dialog({
                       		      modal: true
                       		    });*/
                        }
                          else{
                        	  alert("用户名或密码错误 请重新登录");
                        	  /*$("#fail").dialog({
                       		      modal: true
                       		    });*/
                          }
                           }              
                       });          
            	  });
		 });
</script>

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="${ctx}/ui/css/style.css">

<title>欢迎</title>
<body style="font-family:'楷体';">

<div class="login-container">
	<h1>公司差旅系统</h1>
	
	<form action="" method="post" id="loginForm">
		<div>
			<input type="text" id="userid" name="userid" class="userid" placeholder="工号" autocomplete="off" />
		</div>
		<div>
			<input type="password" id="password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<button id="btn" type="button">登录</button>

	<a href="register.jsp">
		<button type="button" class="register-tis">还有没有账号？</button>
	</a>
	</form>

</div>

<script src="${ctx}/ui/js/jquery.min.js"></script>
<script src="${ctx}/ui/js/common.js"></script>
<!--背景图片自动更换-->
<script src="${ctx}/ui/js/supersized.3.2.7.min.js"></script>
<script src="${ctx}/ui/js/supersized-init.js"></script>
<!--表单验证-->
<script src="${ctx}/ui/js/jquery.validate.min.js?var1.14.0"></script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>来源：<a href="http://www.huiyi8.com/" target="_blank">绘艺素材</a></p>
</div>
</body>
</html>