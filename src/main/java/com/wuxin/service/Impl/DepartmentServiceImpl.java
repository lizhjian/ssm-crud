package com.wuxin.service.Impl;

import com.wuxin.entity.Department;
import com.wuxin.entity.DepartmentDTO;
import com.wuxin.mapper.DepartmentMapper;
import com.wuxin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("DepartmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

   public List<Department> getAll(){

       return departmentMapper.selectByExample(null);

    }
    public DepartmentDTO findempByDept(Integer id){
       return  departmentMapper.findempByDept(id);
    }
}
