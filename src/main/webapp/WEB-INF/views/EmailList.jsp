<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
</head>
<body>
<button id="btn" value="获取" onclick="getAll()">获取</button>
</body>
<script>
    function getAll(){
        window.location.href = "${pageContext.request.contextPath}/receive/getAll";
    }
</script>
</html>
