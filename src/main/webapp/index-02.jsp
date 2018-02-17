<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/1/30
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String cssPath = request.getContextPath();
%>
<jsp:forward page="EmployeeController/emps"></jsp:forward>
<html>
<head>
    <title>Title</title>
    <script src="<%=cssPath%>/static/js/jquery.min.js"></script>
    <link href="<%=cssPath%>/static/css/bootstrap.min.css"/>
    <script src="<%=cssPath%>/static/js/bootstrap.js"></script>


</head>
<body>
   <button class="btn btn-success">按钮</button>
</body>
</html>
