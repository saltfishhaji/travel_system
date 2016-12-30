//打开字滑入效果
window.onload = function(){
	$(".connect p").eq(0).animate({"left":"0%"}, 600);
	$(".connect p").eq(1).animate({"left":"0%"}, 400);
};
//jquery.validate表单验证
$(document).ready(function(){
	//登陆表单验证
	$("#loginForm").validate({
		rules:{
			username:{
				required:true,//必填
				minlength:3, //最少6个字符
				maxlength:32,//最多20个字符
			},
			password:{
				required:true,
				minlength:3, 
				maxlength:32,
			},
		},
		//错误信息提示
		messages:{
			username:{
				required:"必须填写姓名",
				minlength:"姓名至少为4个字符",
				maxlength:"姓名至多为20个字符",
			},
			password:{
				required:"必须填写密码",
				minlength:"密码至少为3个字符",
				maxlength:"密码至多为32个字符",
			},
		},

	});
	//注册表单验证
	$("#registerForm").validate({
		rules:{
			username:{
				required:true,//必填
				minlength:2,
				maxlength: 20,
                username:true,
			},
			password:{
				required:true,
				minlength: 4,
				maxlength: 30,
				password: true,
			},
			email:{
			    required: true,
			    minlength: 5,
			    maxlength: 30,
				email: true,
				myemail:true,
			},
			confirm_password:{
				required:true,
				minlength: 4,
				maxlength: 30,
				equalTo: '.password',
				password:true,
			},
			phone_number:{
				required:true,
				phone_number:true,//自定义的规则
				digits:true,//整数
			}
		},
		//错误信息提示
		messages:{
			username:{
				required:"必须填写姓名",
				minlength:"姓名至少为4个字符",
				maxlength:"姓名至多为20个字符",
			},
			password:{
				required:"必须填写密码",
				minlength:"密码至少为4个字符",
				maxlength:"密码至多为30个字符",
			},
			email:{
				required:"请输入邮箱地址",
				email: "请输入正确的email地址",
			    minlength:"邮箱至少为5个字符",
                maxlength:"邮箱至多为30个字符",
			},
			confirm_password:{
				required: "请再次输入密码",
				minlength: "确认密码不能少于4个字符",
				maxlength: "确认密码不能多于30个字符",
				equalTo: "两次输入密码不一致",//与另一个元素相同
			},
			phone_number:{
				required:"请输入手机号码",
				digits:"请输入正确的手机号码",
			},
		
		},
	});
	//添加自定义验证规则
	jQuery.validator.addMethod("phone_number", function(value, element) { 
		var length = value.length; 
		var phone_number = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
		return this.optional(element) || (length == 11 && phone_number.test(value)); 
	}, "手机号码格式错误");

	jQuery.validator.addMethod("username", function (value, element) {
	    var reg = /^[ \u4e00-\u9fa5a-zA-Z]{2,20}$/;
	    return this.optional(element) || reg.test(value);
	}, "姓名为中文或者英文");

	jQuery.validator.addMethod("myemail", function (value, element) {
	    var length = value.length;
	    var regEmail = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	    return this.optional(element) || regEmail.test(value);
	}, "邮箱格式错误");

	jQuery.validator.addMethod("password", function (value, element) {
	    var regPwd = /[a-zA-Z0-9]*/;
	    return this.optional(element) || regPwd.test(value);
	}, "密码为英文或数字");

	

});
