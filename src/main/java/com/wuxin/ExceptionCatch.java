package com.wuxin;

import com.wuxin.entity.Msg;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * 类说明   : 捕获controller异常
 * 作者        :liuys
 * 日期        :2015年12月23日下午4:04:06
 * 版本号    : V1.0
 */
public class ExceptionCatch {


	/**
	 * 
	 * 描述     :捕获异常
	 * @param pjd
	 * @return
	 * @throws Throwable    
	 * 作者     :liuys
	 * 日期     :2015年12月23日 下午4:05:37 
	 * 版本号:V1.0
	 */
	public Object catContrException(ProceedingJoinPoint pjd) throws Throwable{
		{
			Object o = null;
			//接入cat监控远程调用用到的时间
			String className=pjd.getSignature().getDeclaringTypeName();
			String methodName=pjd.getSignature().getName();


			try {
				o = pjd.proceed();
				//设置成功状态
			} catch (Exception e) {
				if(e instanceof RuntimeException){
					return Msg.success("RuntimeException");
				}else if(e instanceof Exception) {
					return Msg.success("Exception");
				} else{
					return Msg.success("未知");
				}
			}finally {

			}
			return o;
		}
	}
	}
