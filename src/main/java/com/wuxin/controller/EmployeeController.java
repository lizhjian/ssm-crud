package com.wuxin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wuxin.entity.Employee;
import com.wuxin.entity.Msg;
import com.wuxin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @ResponseBody
    @RequestMapping("/emps")
    public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue = "1")Integer pn,Model model){
        PageHelper.startPage(pn,5);
        //startPage 后面紧跟的查询就是分页查询

        List<Employee> employeeList = employeeService.getAll();
        //使用pageInfo包装查询的结果，只需要将pageInfo交给页面
        //连续显示5页
        PageInfo pageInfo = new PageInfo(employeeList,5);
     //   model.addAttribute("pageInfo",pageInfo);
        return Msg.success().add("pageInfo",pageInfo);
    }

    /**
     * 分页查找
     * @param employee
     * @return
     */



    @ResponseBody
    @RequestMapping(value = "saveEmp",method = RequestMethod.POST)
    public Msg saveEmp(Employee employee) {

        employeeService.saveEmployee(employee);

        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public Msg getEmp(@PathVariable Integer id){
        Employee employee = employeeService.getEmp(id);
        return Msg.success().add("employee",employee);

    }
    @ResponseBody
    @RequestMapping(value = "/updateEmp",method = RequestMethod.POST)
    public Msg updateEmp(Employee employee){

        int num = employeeService.updateEmp(employee);
        if(num==1){
           return   Msg.success();
        }else {
          return    Msg.fail();

        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{empId}")
    public Msg deleteById(@PathVariable("empId") Integer empId){
       int num =  employeeService.deleteById(empId);
       if(num==1){
           return  Msg.success();
       }else{
           return  Msg.fail();
       }
    }

    /**
     * 表单接收数据方式
     * 前端传过来的data:{empIds:[1,2],dIds:[3,4]},  后台不管用String[] 或者Integer[]都能接收
     * @return
     */

   /* @ResponseBody
    @RequestMapping(value = "/deleteByIds")
    public Msg deleteByIds(@RequestParam(value = "empIds[]") Integer[] empIds,@RequestParam(value = "dIds[]") Integer[] dIds){

        System.out.println(empIds);
        System.out.println(dIds);
        return  Msg.success();

    }*/

    /**
     * json方式提交
     * @param empIds
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteByIds")
    public Msg deleteByIds(@RequestBody Integer[] empIds){

     //   System.out.println(empIds);

        System.out.println(employeeService.deleteByIds(empIds));

//        System.out.println(dIds);
        return  Msg.success();

    }


}
