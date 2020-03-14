package com.wuxin.service;

import com.wuxin.entity.Employee;
import com.wuxin.entity.OrderDtl;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();
    public void saveEmployee(Employee employee);
    Employee getEmp(Integer id);

    int updateEmp(Employee employee);
    int deleteById(Integer id);

    int deleteByIds(Integer[] empIds);

    List<OrderDtl> queryList();
}
