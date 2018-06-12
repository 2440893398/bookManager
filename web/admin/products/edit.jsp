<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/check.js"></script>

</HEAD>
<script type="text/javascript">
	//设置类别的默认值
	function setProductCategory(a) {
	 	var d= document.getElementById("category").options;
	 	var c = document.getElementsByClassName("a");
	 	for (var i =0; i<c.length;i++){
	 	    if(c[i].value===a){
	 	        c[i].selected=true;
			}else{
                c[i].selected=false;
			}
		}
	};

    function onChange(event) {
        var file = event.target.files[0];
        var img = document.getElementById("img")
        var reader = new FileReader();
        console.log(1);
        reader.onload = function(event) {
            console.log(2);
            // 文件里的文本会在这里被打印出来
            img.src=reader.result;
        };

        reader.readAsDataURL(file);
    }



</script>
<body onload="setProductCategory('${books.category}')">
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/loadupdata" enctype="multipart/form-data" method="post">
		<input type="hidden" name="id" value="${books.id}">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑商品</STRONG> </strong></td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品名称：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="name" class="bg"  value="${books.name}"/></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品价格：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="price" class="bg" value="${books.price}" /></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品数量：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="pnum" class="bg"  value="${books.pnum}"/></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品类别：</td>
				<td class="ta_01" bgColor="#ffffff"><select name="category"
					id="category">
						<option class="a" value="">--选择商品类加--</option>
						<option class="a" value="文学">文学</option>
						<option class="a" value="生活">生活</option>
						<option class="a" value="计算机">计算机</option>
						<option class="a" value="外语">外语</option>
						<option class="a" value="经营">经营</option>
						<option class="a" value="励志">励志</option>
						<option class="a" value="社科">社科</option>
						<option class="a" value="学术">学术</option>
						<option class="a" value="少儿">少儿</option>
						<option class="a" value="艺术">艺术</option>
						<option class="a" value="原版">原版</option>
						<option class="a" value="科技">科技</option>
						<option class="a" value="考试">考试</option>
						<option class="a" value="生活百科">生活百科</option>
				</select></td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品图片：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3"><input
					type="file" id="upload" name="img_url" size="30" value=""  onchange="onChange(event)" /><img src=${pageContext.request.contextPath}/img/${books.img_url} id="img" alt="无参考图">
					</td>
			</tr>
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">商品描述：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3"><textarea
						name="description" cols="30" rows="3" style="WIDTH: 96%">
					${books.description}
				</textarea>
				</TD>
			</TR>
			<TR>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</TR>


			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4"><input type="submit"
					class="button_ok" value="确定"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>



					<input type="reset" value="重置" class="button_cancel"> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span></td>
			</tr>
		</table>
	</form>




</body>
<script>
</script>
</HTML>
