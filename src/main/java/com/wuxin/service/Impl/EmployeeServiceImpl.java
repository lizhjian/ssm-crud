package com.wuxin.service.Impl;

import com.wuxin.entity.Employee;
import com.wuxin.entity.OrderDtl;
import com.wuxin.entity.OrderPri;
import com.wuxin.mapper.EmployeeMapper;
import com.wuxin.mapper.OrderPriMapper;
import com.wuxin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional
public class EmployeeServiceImpl  implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private OrderPriMapper orderPriMapper;

    public List<OrderPri> queryList() {
        orderPriMapper.selectByParams(null);
        return orderPriMapper.selectByParams(null);
    }

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

    public List<OrderPri> queryListAll() {
        System.out.println("========");
        return orderPriMapper.selectByParamsAll(null);
    }

    public List<OrderPri> selectByField(Integer id, String orderNum) {
        System.out.println("========");
        return orderPriMapper.selectByField(id, orderNum);
    }

    public List<OrderPri> selectByFieldV2(Integer id, String orderNum) {
        return orderPriMapper.selectByFieldV2(id, orderNum);
    }

    public int updateField(Integer id, String orderNum, Integer isDel) {
        return orderPriMapper.updateField(id, orderNum, isDel);
    }
    public int updateFieldV2(Integer id, String orderNum, Integer isDel) {
        return orderPriMapper.updateFieldV2(id, orderNum, isDel);
    }

    public List<OrderPri> selectBatch(int[] arr) {
        return orderPriMapper.selectBatch(arr);
    }

    public List<OrderPri> selectBatchList(List<Integer> idList) {
        return orderPriMapper.selectBatchList(idList);
    }

    public List<OrderPri> selectByCase(Integer id, String orderNum, Integer isDel) {
        return orderPriMapper.selectByCase(id, orderNum, isDel);
    }
}
