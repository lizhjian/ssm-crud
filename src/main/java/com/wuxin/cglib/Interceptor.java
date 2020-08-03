package com.wuxin.cglib;

import com.wuxin.entity.Department;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <pre>
 * desc ：TODO
 * author ：lizj
 * date ：2020-06-18 08:30
 * </pre>
 */
public class Interceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("=== BEFORE ===");

        Object re = methodProxy.invokeSuper(o, objects);

        System.out.println("=== AFTER ===");

        return re;
    }

    public static void main(String[] args) {
        Enhancer eh = new Enhancer();

        eh.setSuperclass(Department.class);

        eh.setCallback(new Interceptor());

        Department r = (Department)eh.create();

        r.add(1, 2);
    }
}
