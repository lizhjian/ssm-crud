package com.wuxin.service;

import com.wuxin.entity.Department;
import com.wuxin.entity.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll();
    DepartmentDTO findempByDept(Integer id);
}
