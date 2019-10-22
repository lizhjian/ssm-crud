package com.wuxin.service.Impl;

import com.wuxin.entity.Employee;
import com.wuxin.entity.TargetInfo;
import com.wuxin.mapper.EmployeeMapper;
import com.wuxin.mapper.TargetInfoMapper;
import com.wuxin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
//@Transactional
public class EmployeeServiceImpl  implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private TargetInfoMapper targetInfoMapper;

    public List<Employee> getAll(){
      //这不是分页查询
      return   employeeMapper.selectByExampleWithDept(null);

    }

    public void saveEmployee(Employee employee){
        employeeMapper.insertSelective(employee);
    }
    public Employee getEmp(Integer id){
      return   employeeMapper.selectByPrimaryKey(id);
    }

    public int updateEmp(Employee employee){
       return   employeeMapper.updateEmp(employee);
    }

    public int deleteById(Integer id){
        return employeeMapper.deleteById(id);
    }
    public int deleteByIds(Integer[] empIds){
         //用数组删除
        //return employeeMapper.deleteByIds(empIds);
       // 用list作为删除删除
        List<Integer> employeeList = new ArrayList<Integer>();
        for (Integer id:empIds){
            employeeList.add(id);
        }
        return  employeeMapper.deleteByIds(employeeList);
    }

    public void insertEntity() throws Exception {

        TargetInfo info1  = new TargetInfo();
        info1.setCode("1");
        info1.setName("1");
        info1.setRatio(1D);
        TargetInfo info2  = new TargetInfo();
        info2.setCode("2");
        info2.setName("2");
        info2.setRatio(2.123456777);
        int num = targetInfoMapper.insertSelective(info1);
        num += targetInfoMapper.insertSelective(info2);

        System.out.println("成功插入-->"+num+"条数据");

        throw new RuntimeException("异常");
    }
}
