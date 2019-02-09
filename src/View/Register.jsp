<%@ page language="java" contentType="text/html; charset=GBK"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<body>
<!-- 输出错误提示信息 -->
<span style="color:red; font-weight:bold">
<%
    if(request.getAttribute("err")!=null){
        System.out.println(request.getAttribute("err") + "<br/>");
    }
%>
</span>

Please enter username and password：
<form id="login" method="post" action="register">
    username：<input type="text" name="username" /><br/>
    password&nbsp;<input type="password" name="pass" /><br/>
    conpass<input type="password" name="conPass" /><br/>
    <input type="submit" value="register"/><br/>
</form>
</body>
</html>