package com.wuxin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * Desc  : 错误日志工具类
 * Author: zcc
 * Date  ：2018-07-24 20:20
 * </pre>
 */
public class ErrorLogUtil {
    private final static Logger logger = LoggerFactory.getLogger(ErrorLogUtil.class);

    /**
     * <pre>
     * Desc  : 输出异常信息，将堆栈转成字符串，如果长度过长，则截断
     * Author: zcc
     * Date  ：2018-07-24 20:27:03
     *
     * @param tip
     * @param t "异常"
     * @param maxLength 错误堆栈最大长度
     * @return
     * </pre>
     */
    public static void error(String tip, Throwable t, int... maxLength) {
        if (t == null) {
            return;
        }

        logger.error("{} 异常:{}", tip, getErrorString(t, maxLength));
    }

    /**
     * <pre>
     * Desc  : 获取错误信息的堆栈信息，超过指定长度，则截断
     * Author: zcc
     * Date  ：2018-07-24 20:30:07
     *
     * @param
     * @return
     * </pre>
     */
    public static String getErrorString(Throwable t, int... maxLength) {

        return "";
    }
}
