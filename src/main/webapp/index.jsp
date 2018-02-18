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


<%--员工添加--%>
<!-- Modal -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <div class="modal-body">



                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName_add_input" class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="empName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_add_input" placeholder="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_add_input" value="sex0" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_add_input" value="sex1"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="dId">
                                <option></option>
                            </select>
                        </div>
                    </div>

                </form>



            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <div class="modal-body">



                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName_add_input" class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <p  class="form-control-static" id="empName_update_static" placeholder="empName"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_update_input" placeholder="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_update_input" value="sex0" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_update_input" value="sex1"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="dId">
                                <option></option>
                            </select>
                        </div>
                    </div>

                </form>



            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>



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
            <button class="btn btn-primary" id="emp_aaa_btn">新增</button>
            <button class="btn btn-danger" id="emp_delete_all">删除</button>

        </div>

    </div>
    <%--表格数据--%>
    <div class="row">

        <div class="col-md-12">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" id="check_all"/>
                    </th>
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
        <div class="col-md-6" id="page_info_area">

        </div>
        <div class="col-md-6" id="page_nav_area">


        </div>
    </div>

</div>



</body>

</html>
<script type="text/javascript">

    var totalRecord,currentPage;

    $(function () {
        to_page(1);
        $("#emp_aaa_btn").click(function () {

            $("#empAddModal form")[0].reset();

            getDepts("#empAddModal select");

            $("#empAddModal").modal(function () {
                backdrop:"static"
            })
        })
        
        $("#emp_save_btn").click(function () {


           // console.log($("empAddModal form").serialize());

            $.ajax({
                url:"${APP_PATH}/EmployeeController/saveEmp",
                type:"post",
                data:$("#empAddModal form").serialize(),
                success:function (result) {
                    $("#empAddModal").modal('hide');
                   to_page(totalRecord);
//                    console.log(result);
                }


            })


        })
        
        
    })
    //查询所有部门信息
    function  getDepts(ele) {

        $(ele).empty();
        $.ajax({
            url:"${APP_PATH}/DepartmentController/depts",
            type:"get",
            success:function (result) {
                $.each(result.extend.depts,function () {
                    var optionEld = $("<option></option>").append(this.deptName).attr("value",this.deptId);
                    optionEld.appendTo(ele);
                })
            }


        })
    }



    function to_page(pn) {
        $.ajax({
            url:"${APP_PATH}/EmployeeController/emps",
            data:"pn="+pn,
            type:"get",
            success:function (result) {
                buildEmployeeTable(result);
                buildPageInfo(result);
                buildPageNav(result);
            }

        })
    }

    function buildEmployeeTable(result) {

        $("#emp_table_body").empty();
       var  emps = result.extend.pageInfo.list;
       $.each(emps,function (index,item) {
            //console.log(item);
             var checkBoxTd = $("<td><input type='checkbox' class='check_item'></td>");
             var empIdTd = $("<td></td>").append(item.empId);
             var empNameTd = $("<td></td>").append(item.empName);
             var genderNameTd = $("<td></td>").append(item.gender=="sex0"?"男":"女");
             var emailTd = $("<td></td>").append(item.email);
             var deptNameTd = $("<td></td>").append(item.department.deptName);
             var editBtn  =$("<button></button>").addClass("btn btn-primary btn-sm edit_btn").
             append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑").attr("edit-id",item.empId);
             var delBtn  =$("<button></button>").addClass("btn btn-danger btn-sm delete_btn").
             append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("删除").attr("delete-id",item.empId);

             var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);

           $("<tr></tr>").append(checkBoxTd).
           append(empIdTd).
           append(empNameTd).
           append(genderNameTd).
           append(emailTd).
           append(deptNameTd).
                   append(btnTd).
           appendTo("#emp_table_body");
           

       })


    }
    function buildPageInfo(result) {
        $("#page_info_area").empty();
        $("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页，总页"+result.extend.pageInfo.pages+"总"+result.extend.pageInfo.total);
        totalRecord  = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }
    function buildPageNav(result){
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));

        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        firstPageLi.click(function () {
            to_page(1);
        })
        prePageLi.click(function () {
            to_page(result.extend.pageInfo.pageNum-1);
        })
        //如果没有前一页
        if(result.extend.pageInfo.hasPreviousPage==false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));

        var lastPageLi = $("<li></li>").append($("<a></a>").append("尾页").attr("href","#"));

        if(result.extend.pageInfo.hasNextPage==false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }


        nextPageLi.click(function () {
            to_page(result.extend.pageInfo.pageNum+1);
        })

        lastPageLi.click(function () {
            to_page(result.extend.pageInfo.pages);
        })


        ul.append(firstPageLi).append(prePageLi);
        $.each(result.extend.pageInfo.navigatepageNums,function(index,item){
             var numLi = $("<li ></li>").append($("<a></a>").append(item));
             if(result.extend.pageInfo.pageNum ==item){
                 numLi.addClass("active");
             }
             numLi.click(function () {
                 to_page(item);
             })
             ul.append(numLi);
        })

        ul.append(nextPageLi).append(lastPageLi);

        var navEle = $("<nav></nav>").html(ul);
        navEle.appendTo("#page_nav_area");

    }

    $(document).on("click",".edit_btn",function () {

        getDepts("#empUpdateModal select");
        getEmp($(this).attr("edit-id"));
        $("#emp_update_btn").attr("edit-id",$(this).attr("edit-id"));
        $("#empUpdateModal").modal(function () {
            backdrop:"static"
        })
    })
    $(document).on("click",".delete_btn",function () {

        if(!confirm("确认删除？")){
             return;
        }
        var id = $(this).attr("delete-id");

    //    console.log(id);
    //    return;
        $.ajax({
            url:"${APP_PATH}/EmployeeController/delete/"+id,
            type:'get',
            success:function (result) {
               to_page(currentPage);
                //console.log(result);
            }
        })
    })

    function  getEmp(id) {
        $.ajax({
            url:"${APP_PATH}/EmployeeController/emp/"+id,
          //  data:"pn="+pn,
            type:"get",
            success:function (result) {
               // console.log(result);
              $("#empName_update_static").text(result.extend.employee.empName);
              $("#email_update_input").val(result.extend.employee.email);
              $("#empUpdateModal input[name=gender]").val([result.extend.employee.gender]);
              $("#empUpdateModal select").val([result.extend.employee.dId]);

            }

        })
    }

    $("#emp_update_btn").click(function () {

        $.ajax({
            url:"${APP_PATH}/EmployeeController/updateEmp",
            type:"post",
            data:{
                empId:$("#emp_update_btn").attr("edit-id"),
                email:$("#email_update_input").val(),
                gender:$("#empUpdateModal input[name='gender']:checked").val(),
                dId:$("#empUpdateModal select[name='dId']").val()
            },
            success:function (result) {
                if(result.code*1==100){
                     $("#empUpdateModal").modal("hide");
                     to_page(currentPage);
                }
             //  console.log(result);
            }
        })
    })
    //完成全选
    $("#check_all").click(function () {
     //   alert($(this).prop("checked"));
        $(".check_item").prop("checked",$(this).prop("checked"));
//        alert("");
    })

    $(document).on("click",".check_item",function () {
       // alert($(".check_item:checked").length);
         if($(".check_item:checked").length ==$(".check_item").length){
             $("#check_all").prop("checked",true);
         }else{
             $("#check_all").prop("checked",false);
         }

        ///  $("check_all").prop()
    });

    $("#emp_delete_all").click(function () {
         var  empNames="";
         var  empIds = [];
         $.each($(".check_item:checked"),function () {
            empNames += $(this).parents("tr").find("td:eq(2)").text();
            empIds.push($(this).parents("tr").find("td:eq(1)").text())
        })
        if(empNames=="" || empNames==null){
             alert("请选择后删除");
             return;
        }
        if(confirm("确认删除"+empNames)){
            /*表单方式*/
             /*$.ajax({
                url:"${APP_PATH}/EmployeeController/deleteByIds",
                type:"POST",
                data:{empIds:[1,2],dIds:[3,4]},
                success:function () {
                    
                }
                
            })*/

            $.ajax({
                url:"${APP_PATH}/EmployeeController/deleteByIds",
                type:"POST",
                data:JSON.stringify(empIds),
                contentType: "application/json", //必须这样写
                success:function (result) {
                  to_page(currentPage);
                  $("#check_all").prop("checked",false);
                }

            })
        }
//        $(".check_item:checked")


    })




</script>