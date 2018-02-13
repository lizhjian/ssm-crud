<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/1/30
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String cssPath = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
    <link href="<%=cssPath%>/static/css/bootstrap.min.css"></link>
    <script src="<%=cssPath%>/static/js/bootstrap.js"></script>
    <script src="<%=cssPath%>/static/js/jquery.min.js"></script>

</head>
<body>
   <button class="btn btn-success">按钮</button>
</body>
</html>
