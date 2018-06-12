<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<head>

<title>bookStore注册页面</title>
<%--导入css --%>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript">
	function sb(a) {
        console.log(1);
        //获取传入的值
		var value = a.value;
        console.log(value);
        //判断邮箱是否符合邮箱格式/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
		//正则对象
		var checked=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		//比较判断
		var a =  checked.test(value);
		if(a){
			//如果符合邮箱格式将此发送到服务器检查是否存在
			$.ajax({
				url:"${pageContext.request.contextPath}/checkEmailSL?email="+value,
				type:"get",
                dataType:"text",
                success:function (b) {
                    console.log(b);
                    if(b==0){
                        $("#word3").text("此邮箱可以使用");
                        $("#word3").css("color","green");
                        $("#submit").prop("disabled",false)
                        console.log($("#submit").prop("disabled"));
                    }else{
                        console.log(2);
                        $("#word3").text("sorry！此邮箱以注册过");
                        $("#word3").css("color","red");
                        $("#submit").prop("disabled",true)
					}
                }
				
			})
		}else {
		    //如果不符合提示正确输入
            console.log(2);
            $("#word3").text("请输入格式正确的邮箱");
            $("#word3").css("color","red")
		}
    }
	function changeImage() {
		document.getElementById("imgcode").src="${pageContext.request.contextPath}/CheckCodeServlet?date="+new Date();
    }
    function submt() {
        console.log(1);
        //获取表达内容将表达内容转为字符串
			$word=$("#myForm").serialize();
		//通过ajax发送到数据库
		$.ajax({
			url:"${pageContext.request.contextPath}/registSL",
			data:$word,
			type:"post",
			dataType:"json",
			success:function (date) {
			if(date==0){
			    $("#end").text("验证码输入错误")
                $("#word3").css("color","red")
			}else if(date==1){
                $("#end").text("输入的密码不一致")
                $("#word3").css("color","red")
			}else if(date==2){
                confirm("注意接收服务器发送的激活邮件哦! 点击邮件激活后才可以登陆哦");
                location.href="${pageContext.request.contextPath}/registersuccess.jsp"
			}
            }
		})
    }
</script>
</head>


<body class="main">
	<%@include file="head.jsp"%>
	<%--导入头 --%>
	<%@include file="menu_search.jsp"%><%--导入导航条与搜索 --%>
	<div id="divcontent">
		<form id="myForm" action="##" method="post" onsubmit="return false">
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px">
						<h1>新会员注册</h1>
						<table width="70%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">会员邮箱：</td>
								<td style="width:40%">
								<input type="text" id="email" class="textinput"
									name="email" onchange="sb(this)" />
								<span id="s1"></span>
								</td>
								<td><font id="word3" color="#999999">请输入有效的邮箱地址</font></td>
							</tr>
							<tr>
								<td style="text-align:right">会员名：</td>
								<td>
									<input type="text" class="textinput" name="username" />
								</td>
								<td><font color="#999999">用户名设置至少6位</font></td>
							</tr>
							<tr>
								<td style="text-align:right">密码：</td>
								<td><input type="password" class="textinput"
									name="password" /></td>
								<td><font color="#999999">密码设置至少6位</font></td>
							</tr>
							<tr>
								<td style="text-align:right">重复密码：</td>
								<td><input type="password" class="textinput"
									name="repassword" /></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align:right">性别：</td>
								<td colspan="2">&nbsp;&nbsp;<input type="radio"
									name="gender" value="男" checked="checked" /> 男
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
									name="gender" value="女" /> 女</td>
							</tr>
							<tr>
								<td style="text-align:right">联系电话：</td>
								<td colspan="2"><input type="text" class="textinput"
									style="width:350px" name="telephone" /></td>
							</tr>
							<tr>
								<td style="text-align:right">个人介绍：</td>
								<td colspan="2"><textarea class="textarea" name="introduce"></textarea>
								</td>
							</tr>

						</table>



						<h1>注册校验</h1>
						<table width="80%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">输入校验码：</td>
								<td style="width:50%"><input type="text" class="textinput" name="checkcode"/>
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align:right;width:20%;">&nbsp;</td>
								<td colspan="2" style="width:50%"><img
									src="${pageContext.request.contextPath}/CheckCodeServlet" width="180"
									height="30" class="textinput" style="height:30px;" id="imgcode" />&nbsp;&nbsp;
									<a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a>
								</td>
							</tr>
						</table>



						<table width="70%" border="0" cellspacing="0">
							<tr>
								<td style="padding-top:20px; text-align:center"><input
									type="image" id="submit" src="images/signup.gif"   border="0" onclick="submt()"><span id="end"></span>
								</td>
							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</div>



	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="images/bottomlogo.gif" width="195" height="50"
					style="margin-left:175px" /></td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a></td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2008 &copy; eShop All Rights RESERVED.</b> </font></td>
			</tr>
		</table>
	</div>


</body>
</html>
