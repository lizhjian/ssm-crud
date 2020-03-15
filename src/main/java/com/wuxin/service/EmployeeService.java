package com.wuxin.service;

import com.wuxin.entity.Employee;
import com.wuxin.entity.OrderDtl;
import com.wuxin.entity.OrderPri;
import org.apache.ibatis.annotations.Param;

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


    List<OrderPri> selectByField(Integer id, String orderNum);
    List<OrderPri> selectByFieldV2(Integer id, String orderNum);


    int updateField(Integer id, String orderNum, Integer isDel);

    int updateFieldV2(Integer id, String orderNum, Integer isDel);

    List<OrderPri> selectBatch(int[] arr);

    List<OrderPri> selectBatchList(List<Integer> iidList);

    List<OrderPri> selectByCase(Integer id, String orderNum, Integer isDel);
}
