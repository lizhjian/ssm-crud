package com.wuxin.entity;

import java.util.List;

public class DepartmentDTO extends Department {
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    private List<Employee> employeeList;
}
