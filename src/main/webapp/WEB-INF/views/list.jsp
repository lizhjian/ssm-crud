<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/2/6
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String cssPath = request.getContextPath();
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<html>
<head>
    <title>员工列表</title>
    <script src="<%=cssPath%>/static/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=cssPath%>/static/css/bootstrap.min.css"/>
    <script src="<%=cssPath%>/static/js/bootstrap.js"></script>

</head>
<body>
<div class="container">
    <%--标题--%>
    <div class="row">
        <div class="col-md-12">
            员工增删改查
        </div>
    </div>
    <%--按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary">新增</button>
            <button class="btn btn-danger">删除</button>

        </div>

    </div>
    <%--表格数据--%>
    <div class="row">

        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>id<th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>邮件</th>
                    <th>部门</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="emp">
                    <tr>
                        <td>${emp.empId}<th>
                        <td>${emp.empName}</td>
                        <td>${emp.gender=="0"?"男":"女"}</td>
                        <td>${emp.email}</td>
                        <td>${emp.department.deptName}</td>
                        <td>
                            <button class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-pencil " aria-hidden="true"></span>
                                编辑</button>
                            <button class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                删除</button>

                        </td>
                    </tr>



                </c:forEach>



            </table>
        </div>

    </div>
    <%--分页信息--%>
    <div class="row">
        <div class="col-md-6">
            <div class="col-md-6">
                当前${pageInfo.pageNum}页,总共${pageInfo.pages}页，总${pageInfo.total}
            </div>
        </div>
        <div class="col-md-6">

            <nav aria-label="Page navigation">
                <ul class="pagination">



                    <li><a href="<%=cssPath%>/EmployeeController/emps?pn=1">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="<%=cssPath%>/EmployeeController/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                        <c:if test="${pageNum==pageInfo.pageNum}">
                            <li class="active"><a href="#">${pageNum}</a></li>
                        </c:if>
                        <c:if test="${pageNum != pageInfo.pageNum}">
                            <li><a href="<%=cssPath%>/EmployeeController/emps?pn=${pageNum}">${pageNum}</a></li>
                        </c:if>
                        


                    </c:forEach>

                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="<%=cssPath%>/EmployeeController/emps?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                        <%--<li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>--%>
                    </c:if>

                    <li><a href="<%=cssPath%>/EmployeeController/emps?pn=${pageInfo.pages}">尾页</a></li>
                </ul>
            </nav>
        </div>
    </div>

</div>

</body>
</html>
