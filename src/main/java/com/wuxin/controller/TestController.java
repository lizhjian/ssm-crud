package com.wuxin.controller;

import com.alibaba.fastjson.JSONObject;
import com.wuxin.entity.Msg;
import com.wuxin.entity.TestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    /**
     * json方式提交
     * @param name age
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/testParams")
    public Msg testParams(String name,Integer age){

        JSONObject jsonObject = new JSONObject();
        System.out.println(name);
        System.out.println(age);

        return  Msg.success();

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
}
