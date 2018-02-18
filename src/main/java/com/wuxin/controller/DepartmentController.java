package com.wuxin.controller;

import com.wuxin.entity.Department;
import com.wuxin.entity.Msg;
import com.wuxin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "DepartmentController")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 返回所有部门信息
     */

    @ResponseBody
    @RequestMapping(value = "/depts")
    public Msg getDepts(){

        List<Department> departmentList =  departmentService.getAll();
        return Msg.success().add("depts",departmentList);
//        departmentService.getAll();
        // Msg msg = new Msg();
       // return Msg.success().add()
        //return  null;

     //   return  Msg.success();
    }
}
