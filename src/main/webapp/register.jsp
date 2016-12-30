<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script type="text/javascript">
		 $(function(){
            	  $("#btn2").click(function(){
            		  var user={'username':$("#username").val(),
             				 'email':$("#email").val(),
             				 'post':$("#post").val(),
             				 'password':$("#password2").val()};
             		 var passwordagain=$("#passwordAgain").val();
             		var reg=/^[ \u4e00-\u9fa5a-zA-Z]{2,20}$/;
            			//最后提交时用于记录所有的输入是否合法的简单判断，如有一个不合法则不提交至后台
            			/*$("#useridError").hide();
          			$("#userPwdError").hide();*/
          			if((!reg.test(user.username))){
          				//$("#useridError").show();
          				alert("名字为中文或者字母,长度2-20个字符");
          				return;
          			}
          			var regEmail=/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
                    if(user.email=="" || user.email.length < 5 || user.email.length > 30||(!regEmail.test(user.email))){
                        // $("#userPwdError").show();
                        alert("邮箱错误");
                        return;
                     }
          			var regPwd=/[a-zA-Z0-9]*/;
                      if(user.password=="" || user.password.length < 4 || user.password.length > 30||(!regPwd.test(user.password ))){
                         // $("#userPwdError").show();
                         alert("密码为英文或数字，长度在4-30之间");
                         return;
                      }
                      if(user.password!=$("#passwordAgain").val())
         			  {
         			 	 alert("两次密码输入不一致，请重新输入");
         			 	 return;
         			  } 
            			 $.ajax({                           	  
                          url: '${ctx}/user/register',                  
                          type: 'POST',                  
                          data: user,                  
                          success: function (msg) {                      
                          if (msg > 0){ 
                        	  alert("你的暂时工号为"+msg+",请等待管理员审核");
                        	  location.href = "index.jsp";
                          }    
                          else{
                        	  alert("注册失败！请重新输入");
                        	  location.href = "register.jsp";
                          }
                         }        
            			 
                       });       
		 });
               	  /*if("${error}"!=""){  
               	  }
               	   var flag=true;
               	   $(".submit").click(function(){
               		  $("input").each(function(){
               			  var val=this.value;
               			  val=$.trim(val);
               			  this.value=val;
               			  var lable=$(this).attr("id");
               			  if(val==""){
               				  alert(lable+"不能为空！");
               				  flag=false;
               			  }
               		  });
               		 if(flag){
               			 var reg=;
               			 if(!reg.text($("#userNmae").val())){
               				 alert("");
               				 flag=false;
               			 }
               		 }  
               		   return flag;
               	   });*/
                  });   
</script>
<style>
.danxuan{
	width:30 !important;
	height:40 !important;
	line-height:42px;margin-top:25px;padding:0 15px;background:#2d2d2d;background:rgba(45,45,45,.15);-moz-border-radius:6px;-webkit-border-radius:6px;border-radius:6px;border:1px solid #3d3d3d;border:1px solid rgba(255,255,255,.15);-moz-box-shadow:0 2px 3px 0 rgba(0,0,0,.1) inset;-webkit-box-shadow:0 2px 3px 0 rgba(0,0,0,.1) inset;box-shadow:0 2px 3px 0 rgba(0,0,0,.1) inset;font-family:"Microsoft YaHei",Helvetica,Arial,sans-serif;font-size:14px;color: #fff;text-shadow:0 1px 2px rgba(0,0,0,.1);-o-transition:all .2s;-moz-transition:all .2s;-webkit-transition:all .2s;-ms-transition:all .2s}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="${ctx}/ui/css/style.css">

<title>欢迎</title>
<body style="font-family:'楷体';">

<div class="register-container">
	<h1>注册</h1>
	
	<form action="" method="post" id="registerForm">
		<div>
			<input type="text" id="username" name="username" placeholder="姓名" autocomplete="off"/>
		</div>
		<div>
			<select id="post" name="post">
				<option value="3">员工</option>
				<option value="2">部门经理</option>
				<option value="1">总经理</option>
			</select>
		</div>
		<div>
			<input type="email" id="email" name="email" placeholder="邮箱" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="password" id="password2" class="password" name="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="password" id="passwordAgain" class="confirm_password" name="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<button id="btn2" type="button">确定</button>
		</div>
		<div>
			</form>
				<a href="index.jsp">
				<button type="button" class="register-tis">已经有账号？</button>
				</a>
		</div>
</div>

</body>
<!-- <script src="ui/js/jquery.min.js"></script> -->
<script src="ui/js/common.js"></script>
<!--鑳屾櫙鍥剧墖鑷姩鏇存崲-->
<script src="ui/js/supersized.3.2.7.min.js"></script>
<script src="ui/js/supersized-init.js"></script>
<!--琛ㄥ崟楠岃瘉-->
<script src="ui/js/jquery.validate.min.js?var1.14.0"></script>
