package com.wuxin.test;

import com.alibaba.fastjson.JSON;
import com.wuxin.entity.CycleTypeEnums;
import com.wuxin.entity.CycleTypeUtils;
import com.wuxin.entity.OrderDtl;
import com.wuxin.entity.OrderPri;
import com.wuxin.mapper.OrderPriMapper;
import com.wuxin.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.*;

/**
 * <pre>
 * desc ：子类
 * author ：lizj
 * date ：2020-03-14 09:18
 * </pre>
 */
public class EmployeeTest extends CommonTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OrderPriMapper orderPriMapper;

    @Test
    public void testQuery(){
        // 在同一个会话中 执行相同的sql时 第二次查询直接从缓存中获取数据
        System.out.println(JSON.toJSONString(employeeService.queryList()));
    }
    @Test
    public void testQueryAll(){
        System.out.println(JSON.toJSONString(employeeService.queryListAll()));
    }
    @Test
    public void testselectByField(){
        Integer id = null;
        String orderNum = null;
        System.out.println(JSON.toJSONString(employeeService.selectByField(id, orderNum)));
    }
    @Test
    public void selectByFieldV2(){
        Integer id = null;
        String orderNum = "001";
        System.out.println(JSON.toJSONString(orderPriMapper.selectByFieldV2(id, orderNum)));
    }
    @Test
    public void selectByFieldV3(){
        Integer id = null;
        String orderNum = "01";
        System.out.println(JSON.toJSONString(orderPriMapper.selectByFieldV3(id, orderNum)));
    }
    @Test
    public void testUpdateField(){
        Integer id = 1;
        String orderNum = "122";
        Integer isDel = null;
        System.out.println(JSON.toJSONString(employeeService.updateField(id, orderNum, isDel)));
    }
    @Test
    public void testUpdateFieldV2(){
        Integer id = 1;
        String orderNum = "122";
        Integer isDel = 1;
        System.out.println("成功更新==>"+JSON.toJSONString(employeeService.updateFieldV2(id, orderNum, isDel)));
    }
    @Test
    public void testQueryBatch(){
//        Integer id = 1;
//        String orderNum = "122";
//        Integer isDel = 1;
        int arr[] = {1,2,3,4};
        System.out.println("成功查询==>"+JSON.toJSONString(employeeService.selectBatch(arr)));
    }

    @Test
    public void testQueryBatchList(){
//        Integer id = 1;
//        String orderNum = "122";
//        Integer isDel = 1;
        // int arr[] = {1,2,3,4};
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(5);
        System.out.println("成功查询==>"+JSON.toJSONString(employeeService.selectBatchList(list)));
    }
    @Test
    public void testQueryBatchListV2(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(5);

        List<String> orders = new ArrayList<String>();
        orders.add("001");
        System.out.println("成功查询==>"+JSON.toJSONString(orderPriMapper.selectBatchListV2(list, orders)));
    }
    @Test
    public void testSelectByCase(){
        System.out.println("selectByCase======>");
        Integer id = null;
        String orderNum = null;
        Integer isDel = 1;
        System.out.println("成功查询==>"+JSON.toJSONString(employeeService.selectByCase(id, orderNum, isDel)));
    }
    @Test
    public void testQueryV2(){
        Integer id = 1;
        String orderNum = "001";
        JSON.toJSONString(orderPriMapper.selectById(orderNum));
    }

    @Test
    public void testQueryV4(){
        Integer id = 1;
        String orderNum = "001";
        OrderPri pri = new OrderPri(id, orderNum, null, null);
        System.out.println(JSON.toJSONString(orderPriMapper.selectListParam(pri)));
    }
    @Test
    public void testQueryV5(){
        Integer id = 1;
        String orderNum = "001";
        OrderPri pri = new OrderPri(id, orderNum, null, null);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("orderNum", orderNum);
        System.out.println(JSON.toJSONString(orderPriMapper.selectListByMap(map)));
    }
    @Test
    public void testQueryV6(){
//        Integer id = 1;
//        String orderNum = "001";
//        OrderPri pri = new OrderPri(id, orderNum, null, null);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("id", id);
//        map.put("orderNum", orderNum);

        OrderPri pri = new OrderPri();
        OrderDtl dtl = new OrderDtl();
        pri.setId(1);
        dtl.setProId(1);
        System.out.println(JSON.toJSONString(orderPriMapper.selectListByMulEntity(pri, dtl)));
    }

    @Test
    public void testInsertV1(){
        List<OrderPri> orderPris = new ArrayList<OrderPri>();
        orderPris.add(new OrderPri(null,"004", 1, null));
        orderPris.add(new OrderPri(null,"005", 2, null));
        System.out.println(JSON.toJSONString(orderPriMapper.insertBatch(orderPris)));
    }
    @Test
    public void testUpdateV1(){
        List<OrderPri> orderPris = new ArrayList<OrderPri>();
        orderPris.add(new OrderPri(1,"004", 1, null));
        orderPris.add(new OrderPri(2,"005", 2, null));
        System.out.println(JSON.toJSONString(orderPriMapper.updateByIds(orderPris)));
    }


    @Test
    public void testCgliB(){
//        System.out.println(JSON.toJSONString(CycleTypeEnums.standardCycle));
//        System.out.println(JSON.toJSONString(CycleTypeEnums.recentlyCycle));

        System.out.println(JSON.toJSONString(CycleTypeUtils.standardCycles));
        System.out.println(JSON.toJSONString(CycleTypeUtils.recentlyCycles));
    }
}
