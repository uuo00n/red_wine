<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>后台登录</title>
    <link href="${pageContext.request.contextPath }/sys/style/css/login.css" type="text/css" rel="stylesheet">
    <script>"undefined" == typeof CODE_LIVE && (!function (e) {
        var t = {nonSecure: "60601", secure: "60610"}, c = {nonSecure: "http://", secure: "https://"},
            r = {nonSecure: "127.0.0.1", secure: "gapdebug.local.genuitec.com"},
            n = "https:" === window.location.protocol ? "secure" : "nonSecure";
        script = e.createElement("script"), script.type = "text/javascript", script.async = !0, script.src = c[n] + r[n] + ":" + t[n] + "/codelive-assets/bundle.js", e.getElementsByTagName("head")[0].appendChild(script)
    }(document), CODE_LIVE = !0);</script>
</head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc8-30"
      data-genuitec-path="/red_wine/WebRoot/sys/login.jsp">
<div class="login" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc8-30"
     data-genuitec-path="/red_wine/WebRoot/sys/login.jsp">
    <div class="message">ChrosWine红酒有限公司-管理登录</div>
    <div id="darkbannerwrap"></div>
    <form action="${pageContext.request.contextPath }/sys/action.jsp" method="post">
        <input name="name" placeholder="用户名" required="" type="text">
        <hr class="hr15">
        <input name="password" placeholder="密码" required="" type="password">
        <hr class="hr15">
        <input value="登录" style="width:100%;" type="submit">
    </form>
</div>
<div class="copyright">© 2018红酒有限公司 <a href="http://www.bjjqe.com/" target="_blank">金企鹅联合出版社</a></div>
</body>
</html>