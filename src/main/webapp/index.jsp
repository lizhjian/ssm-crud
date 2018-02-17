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
                <thead>
                <tr>
                    <th>id</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>邮件</th>
                    <th>部门</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody  id="emp_table_body">


                </tbody>


            </table>
        </div>

    </div>
    <%--分页信息--%>
    <div class="row">
        <div class="col-md-6">
            <div class="col-md-6">
                当前 页,总共 页，总
            </div>
        </div>
        <div class="col-md-6">


        </div>
    </div>

</div>



</body>

</html>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url:"${APP_PATH}/EmployeeController/emps",
            data:"pn=1",
            type:"get",
            success:function (result) {
                buildEmployeeTable(result);
            }

        })
    })

    function buildEmployeeTable(result) {
       var  emps = result.extend.pageInfo.list;
       $.each(emps,function (index,item) {
            //console.log(item);
             var empIdTd = $("<td></td>").append(item.empId);
             var empNameTd = $("<td></td>").append(item.empName);
             var genderNameTd = $("<td></td>").append(item.gender=="sex0"?"男":"女");
             var emailTd = $("<td></td>").append(item.email);
             var deptNameTd = $("<td></td>").append(item.department.deptName);
             var editBtn  =$("<button></button>").addClass("btn btn-primary btn-sm").
             append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
             var delBtn  =$("<button></button>").addClass("btn btn-danger btn-sm").
             append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("删除");

             var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);

           $("<tr></tr>").append(empIdTd).
           append(empNameTd).
           append(genderNameTd).
           append(emailTd).
           append(deptNameTd).
                   append(btnTd).
           appendTo("#emp_table_body");
       })


    }
    function buildPageNav(result){

    }

</script>