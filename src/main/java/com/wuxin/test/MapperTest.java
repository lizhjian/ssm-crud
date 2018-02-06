package com.wuxin.test;

import com.wuxin.entity.Department;
import com.wuxin.mapper.DepartmentMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    /**
     *测试Department 的Mapper
     */

    @Test
    public void testCRUD(){
        //创建ioc容器
        /* 原生
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取mapper
        DepartmentMapper bean =  ioc.getBean(DepartmentMapper.class);*/
        /*System.out.println(departmentMapper);*/

        //插入部门
        /*departmentMapper.insertSelective(new Department(null,"开发部"));
        departmentMapper.insertSelective(new Department(null,"测试部"));*/

        //员工插入
    }
}
