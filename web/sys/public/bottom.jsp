<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Frame bottom</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/jquery.js"></script>
    <link href="${pageContext.request.contextPath }/sys/style/css/common_style_blue.css" rel="stylesheet"
          type="text/css"/>
    <style type="text/css">
        body {
            margin: 0;
        }

        img {
            vertical-align: inherit;
            border: 0;
        }

        a:link, a:hover, a:visited {
            color: #A9DCFF;
            text-decoration: none;
        }

        #StatusBar {
            background-color: #4386B7;
            border-top: 1px solid #FFFFFF;
            height: 19px;
            width: 100%;
        }

        #StatusBar #StatusBar_Links {
            color: #A9DCFF;
            float: left;
            font-family: "宋体";
            font-size: 12px;
            padding-left: 20px;
            padding-top: 3px;
        }

        #StatusBar #StatusBar_Right {
            color: #A9DCFF;
            float: right;
            font-family: "宋体";
            font-size: 12px;
            padding-right: 20px;
            padding-top: 4px;
        }
    </style>
    <script>"undefined" == typeof CODE_LIVE && (!function (e) {
        var t = {nonSecure: "60601", secure: "60610"}, c = {nonSecure: "http://", secure: "https://"},
            r = {nonSecure: "127.0.0.1", secure: "gapdebug.local.genuitec.com"},
            n = "https:" === window.location.protocol ? "secure" : "nonSecure";
        script = e.createElement("script"), script.type = "text/javascript", script.async = !0, script.src = c[n] + r[n] + ":" + t[n] + "/codelive-assets/bundle.js", e.getElementsByTagName("head")[0].appendChild(script)
    }(document), CODE_LIVE = !0);</script>
</head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc8-35"
      data-genuitec-path="/red_wine/WebRoot/sys/public/bottom.jsp">

<div id="StatusBar" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc8-35"
     data-genuitec-path="/red_wine/WebRoot/sys/public/bottom.jsp">
    <!-- 链接 -->
    <div id="StatusBar_Links">
        <a href="http://www.bjjqe.com" target="_blank">金企鹅联合出版社</a>，专业的出版社！
    </div>
    <!-- 右侧功能按钮 -->
    <div id="StatusBar_Right">
        <!-- 版本 -->
        <a href="javascript:void(0)">
            <img border="0" width="11" height="11" src="${pageContext.request.contextPath }/sys/style/images/info.gif"/>
            <img border="0" width="40" height="11"
                 src="${pageContext.request.contextPath }/sys/style/images/version.gif"/>
        </a>
    </div>
</div>

</body>
</html>