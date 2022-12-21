<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>ChrosWine红酒有限公司管理系统</title>
    <meta http-equiv="Content-Type" content="text/jsp; charset=utf-8"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/page_common.js"></script>
    <link href="${pageContext.request.contextPath }/sys/style/css/common_style_blue.css" rel="stylesheet"
          type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/sys/style/css/index_1.css"/>
    <style type="text/css">.TableDetail1 td {
        text-align: center
    }</style>
    <script>"undefined" == typeof CODE_LIVE && (!function (e) {
        var t = {nonSecure: "60601", secure: "60610"}, c = {nonSecure: "http://", secure: "https://"},
            r = {nonSecure: "127.0.0.1", secure: "gapdebug.local.genuitec.com"},
            n = "https:" === window.location.protocol ? "secure" : "nonSecure";
        script = e.createElement("script"), script.type = "text/javascript", script.async = !0, script.src = c[n] + r[n] + ":" + t[n] + "/codelive-assets/bundle.js", e.getElementsByTagName("head")[0].appendChild(script)
    }(document), CODE_LIVE = !0);</script>
</head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc8-25"
      data-genuitec-path="/red_wine/WebRoot/sys/information/information.jsp">
<!-- 页面标题 -->
<div id="TitleArea" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc8-25"
     data-genuitec-path="/red_wine/WebRoot/sys/information/information.jsp">
    <div id="TitleArea_Head"></div>
    <div id="TitleArea_Title">
        <div id="TitleArea_Title_Content">
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath }/sys/style/images/title_arrow.gif"/> 公司资讯
        </div>
    </div>
    <div id="TitleArea_End"></div>
</div>
<!-- 过滤条件 -->
<div id="QueryArea">
    <form action="${pageContext.request.contextPath }/servlet/InformationServlet?id=${result.id}&method=search"
          method="post">
        <input type="text" name="title" title="请输入公司资讯标题"> <input type="submit" value="搜索">
    </form>
</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
        <tr align="center" valign="middle" id="TableTitle">
            <td>编号</td>
            <td>标题</td>
            <td>作者</td>
            <td>发布时间</td>
            <td>操作</td>
        </tr>
        </thead>
        <!--显示数据列表，首先判断数据集是否为空，不为空则循环输出公司资讯信息，为空则给出相应提示 -->
        <tbody id="TableData">
        <c:choose>
            <c:when test="${not empty result.list}">
                <c:forEach var="result" items="${result.list}">
                    <tr class="TableDetail1">
                        <td>${result.id}</td>
                        <td>${result.title}</td>
                        <td>${result.author}</td>
                        <td>${result.date}</td>
                        <td>
                            <a href="${pageContext.request.contextPath }/servlet/InformationServlet?id=${result.id}&method=Jumpup"
                               class="FunctionButton">更新</a>
                            <a href="${pageContext.request.contextPath }/servlet/InformationServlet?id=${result.id}&method=delete"
                               class="FunctionButton">删除</a></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr class="TableDetail1">
                    <td colspan="5" style="text-align:center">没有你要找的数据，请先添加记录再查看！</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
    <!-- 其他功能超链接 -->
    <div id="TableTail" align="center">
        <div class="FunctionButton"><a href="${pageContext.request.contextPath }/sys/information/add.jsp">添加</a></div>
        <div class="page_box">
            <a href="${pageContext.request.contextPath }/servlet/InformationServlet?currentPage=1&method=list">首页</a>
            <a href="${pageContext.request.contextPath }/servlet/InformationServlet?currentPage=${result.PageDate.currentPage-1}&method=list">上一页</a>
            <a>${result.PageDate.currentPage}/${result.PageDate.totalPage}</a>
            <a href="${pageContext.request.contextPath }/servlet/InformationServlet?currentPage=${result.PageDate.currentPage+1}&method=list">下一页</a>
            <a href="${pageContext.request.contextPath }/servlet/InformationServlet?currentPage=${result.PageDate.totalPage}&method=list">末页</a>
        </div>
    </div>
</div>
</body>
</html>