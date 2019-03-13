<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>发送状态</title>
</head>
<body>
    <c:if test="${msg == '1'}">
        <button class="btn btn-success">发送成功
            <span class="glyphicon glyphicon-ok"  aria-hidden="true"></span>
        </button>
    </c:if>
    <c:if test="${msg == '0'}">
        <button class="btn btn-success">发送失败
            <span class="glyphicon glyphicon-remove"  aria-hidden="true"></span>
        </button>
    </c:if>
</body>
</html>
