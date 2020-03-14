package com.wuxin.test;

import com.wuxin.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * <pre>
 * desc ：TODO
 * author ：lizj
 * date ：2020-03-14 09:18
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class EmployeeTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testQuery(){
        employeeService.queryList();
    }

}
