<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <form class="col-md-12" name="form1" action="${pageContext.request.contextPath}/sendemail/receive" method="post">
                <div class="form-group">
                    <label for="address" class="col-md-2">收件人</label>
                    <input type="email" name="Address" class="form-control" id="address" placeholder="Email">
                </div>
                <div class="form-group">
                    <label for="title" class="col-md-2">主题</label>
                    <input type="text" name="Title" class="form-control" id="title" placeholder="Title">
                </div>
                <div class="form-group">
                    <label for="content" class="col-md-2">邮件内容</label>
                    <input type="text" name="Content" class="form-control" id="content" placeholder="Content">
                </div>
                <div class="form-group">
                    <label for="file">File input</label>
                    <input type="file" id="file">
                    <p class="help-block">Example block-level help text here.</p>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Check me out
                    </label>
                </div>
                <button type="submit" class="btn btn-default">发送</button>
            </form>
        </div>
    </div>
</body>
</html>
