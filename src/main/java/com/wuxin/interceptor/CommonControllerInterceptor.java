package com.wuxin.interceptor;

import com.alibaba.fastjson.JSON;
import com.wuxin.util.ErrorLogUtil;
import com.wuxin.util.IPAddressUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 请求公共处理拦截器，如:
 * 1. 设置处理请求的线程名称
 * 2. 打印请求访问日志
 * 等
 * <p>
 * created by zhanjunwei on 15/7/30.
 * modified by zcc on 2018-01-25 过滤url使用字典项配置
 */
public class CommonControllerInterceptor extends HandlerInterceptorAdapter {
    private final static Logger logger = LoggerFactory.getLogger(CommonControllerInterceptor.class);
    public static final ThreadLocal<Long> requestStart = new ThreadLocal<Long>();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        requestStart.set(System.currentTimeMillis());
        // 设置线程名称
        this.initThreadName("http");

        // 输出日志
        this.outputUrlLog(request.getContentType(), request.getRequestURI());

        return true;
    }

    /**
     * 在业务处理器处理请求之后 被调用
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     * (non-Javadoc)
     *
     * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, Object, Exception)
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long cast = 0;
        if (requestStart.get() != null) {
            cast = System.currentTimeMillis() - requestStart.get();
            requestStart.remove();
        }
        logger.error("==================+>");
        logger.info("{} 执行总耗时:{}ms", request.getRequestURI(), cast);
    }

    /**
     * <pre>
     * Desc  : 设置线程名
     * Author: zcc
     * Date  ：2018-01-25 16:05:33
     *
     * @param threadPrefix 线程名前缀
     * @return
     * </pre>
     */
    public void initThreadName(String threadPrefix) {
        try {
            StringBuilder tn = new StringBuilder();
            // 线程名格式:  http-[ip地址]-uuid:[毫秒值]-[随机数(0-10000)] ,  样例:http-101.101.101.101-uuid:1525943843481-1234
            tn.append(threadPrefix).append("-").append(IPAddressUtil.getLocalIPAddress()).append("-uuid:");
            tn.append(System.currentTimeMillis()).append("-").append(RandomUtils.nextInt(0, 10000));
            Thread.currentThread().setName(tn.toString());
        } catch (Exception e) {
            logger.error("initThreadName 初始化线程名异常:{}", ErrorLogUtil.getErrorString(e));
        }
    }

    /**
     * <pre>
     * Desc  : 输出请求日志
     * Author: zcc
     * Date  ：2018-01-25 15:47:02
     *
     * @param contentType
     * @param uri : 请求url
     * @return
     * </pre>
     */
    private void outputUrlLog(String contentType, String uri) {
        // 输出日志: 区分 json, or 非json 形式
        StringBuilder requestBuffer = new StringBuilder(300);
        requestBuffer.append("[请求路径]:").append(uri);
        requestBuffer.append(", [contentType]:").append(contentType);

        logger.info(requestBuffer.toString());
    }
}
