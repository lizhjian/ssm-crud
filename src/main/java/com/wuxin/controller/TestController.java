package com.wuxin.controller;

import com.alibaba.fastjson.JSONObject;
import com.wuxin.entity.Msg;
import com.wuxin.entity.TestEntity;
import com.wuxin.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * <pre>
 * desc ：测试入参
 * author ：lizj
 * date ：2019-04-23 09:46
 * </pre>
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private EmployeeService employeeService;


    private static final Logger log = LoggerFactory.getLogger(TestController.class);


    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    /**
     * json方式提交
     * @param name age
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/testParams")
    public Msg testParams(String name,Integer age) throws Exception{
       // try{
            //
//        JSONObject jsonObject = new JSONObject();
//        System.out.println(name);
//        System.out.println(age);


         //   employeeService.insertEntity();
//            return  Msg.success();
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
        FutureTask futureTask = new FutureTask(new Callable() {
            public Object call() throws Exception {
                Thread.sleep(10000);
                return null;
            }
        });

        taskExecutor.submit(futureTask);
        futureTask.get();

        return null;

    }

    /**
     * json方式提交
     * @param entity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/testEntity")
    public Msg testEntity(TestEntity entity){

        JSONObject jsonObject = new JSONObject();
        System.out.println(entity.getAge());
        System.out.println(entity.getName());

        return  Msg.success();

    }

    /**
     * json方式提交
     * @param entity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/testBean")
    public Msg testBean(@RequestBody  TestEntity entity){

        JSONObject jsonObject = new JSONObject();
        System.out.println(entity.getAge());
        System.out.println(entity.getName());

        return  Msg.success();
    }

    /**
     * json方式提交
     * @param entity
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryList")
    public Msg queryList(@RequestBody  TestEntity entity){

        employeeService.queryList();

        return  Msg.success();
    }




}
