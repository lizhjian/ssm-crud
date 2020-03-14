package com.wuxin.service;

import com.wuxin.entity.Employee;
import com.wuxin.entity.OrderDtl;
import com.wuxin.entity.OrderPri;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();
    public void saveEmployee(Employee employee);
    Employee getEmp(Integer id);

    int updateEmp(Employee employee);
    int deleteById(Integer id);

    int deleteByIds(Integer[] empIds);

    List<OrderPri> queryList();

    List<OrderPri> queryListAll();
}
