package com.wuxin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuxin.entity.Employee;
import com.wuxin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Externalizable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping(value = "EmployeeController")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 分页查找
     * @param pn
     * @return
     */

    @RequestMapping("emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model) {
       //引入PageHelper
       //在查询之前调用,传入页码 和每页的大 小
        PageHelper.startPage(pn,5);
        //startPage 后面紧跟的查询就是分页查询

        List<Employee> employeeList = employeeService.getAll();
        //使用pageInfo包装查询的结果，只需要将pageInfo交给页面
        //连续显示5页
        PageInfo pageInfo = new PageInfo(employeeList,5);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }
}
