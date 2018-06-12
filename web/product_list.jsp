<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


    <title>bookStore列表</title>
    <%--导入css --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>

</head>

<script>
    $(function () {

        $("#up").click(function () {
            //判断是否是第一页
            if("${pageinf.endelecode}"=="0"){
                console.log(1);
                return false;
            }else {
                console.log(2);
                return true;
            }
        })
        $("#next").click(function () {
            //判断是否是第一页
            if("${pageinf.endelecode}"=="${pageinf.allpage}"){
                console.log(3);
                return false;
            }else{
                console.log(4);
                return true;
            }
        })
    })
</script>

<body class="main">

<jsp:include page="head.jsp"/>
<jsp:include page="menu_search.jsp"/>

<div id="divpagecontent">
    <table width="100%" border="0" cellspacing="0">
        <tr>
            <td>
                <div style="text-align:right; margin:5px 10px 5px 0px">
                    <a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;计算机&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
                </div>
                <table cellspacing="0" class="booklist">
                    <tr>
                        <c:forEach items="${list}" var="book">
                        <td>
                            <div class="divbookpic">
                                <p>
                                    <%--点击图片跳转跳转商品详细页面--%>
                                    <a href="${pageContext.request.contextPath}/Showbook?id=${book.id}"><img src="${pageContext.request.contextPath}/img/${book.img_url}" width="115" height="129" border="0"/> </a>
                                </p>
                            </div>
                            <div class="divlisttitle">
                                <%--点击图片跳转商品详细页面--%>
                                <a href="${pageContext.request.contextPath}/Showbook?id=${book.id}">书名:${book.name}<br/>售价:${book.price} </a>
                            </div>
                        </td>
                        </c:forEach>
                    </tr>

                </table>

                <div class="pagination">
                    <ul>
                        <li class="disablepage">
                            <a href="${pageContext.request.contextPath}/fenPageUp" id="up">
                            &lt;&lt;上一页</a></li>
                        <li>第${pageinf.endelecode}页/共${pageinf.allpage}页</li>
                        <li class="nextPage">
                            <a href="${pageContext.request.contextPath}/fenPageNext" id="next">
                                &lt;&lt;下一页</a></li>
                    </ul>
                </div>
            </td>
        </tr>
    </table>
    </td>
    </tr>
    </table>
</div>


<jsp:include page="foot.jsp"/>


</body>
</html>
