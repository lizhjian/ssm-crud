
package com.wuxin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

/**
 * IP工具类
 * @author liuys
 *
 */
public class IPAddressUtil {
	private final static Logger logger = LoggerFactory.getLogger(IPAddressUtil.class);
	private final static String HEADER_X_FORWARDED_FOR = "X-FORWARDED-FOR";
	private static String LOCAL_IP_STR;

	static {
		// 本地ip运行期间一般不会改变，使用内存，不必每次获取
		try {
			LOCAL_IP_STR = InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			logger.error("", e);
		}
		/*try {
			Enumeration<?> e1 = (Enumeration<?>) NetworkInterface.getNetworkInterfaces();
			while (e1.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) e1.nextElement();
				if (!ni.getName().equals("eth0")) {
					continue;
				} else {
					Enumeration<?> e2 = ni.getInetAddresses();
					while (e2.hasMoreElements()) {
						InetAddress ia = (InetAddress) e2.nextElement();
						if (ia instanceof Inet6Address) {
							continue;
						}
						ip = ia.getHostAddress();
					}
					break;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * 获取本机IP地址
	 * @return
	 */
	public static String getLocalIPAddress() {
		return LOCAL_IP_STR;
	}
	/**
	 * 获取客户端源地址
	 * @param request
	 * @return
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr();
		String x;
		if ((x = request.getHeader(HEADER_X_FORWARDED_FOR)) != null) {
			remoteAddr = x;
			int idx = remoteAddr.indexOf(',');
			if (idx > -1) {
				remoteAddr = remoteAddr.substring(0, idx);
			} 
		}
		return remoteAddr; 
	}
	/**
	 * 获取客服端路由全路径
	 * @param request
	 * @return
	 */
	public static String getX_Forwarded_For(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr();
		String x;
		if ((x = request.getHeader(HEADER_X_FORWARDED_FOR)) != null) {
			remoteAddr = x;
		} else if((x = request.getHeader("x-forwarded-for")) != null) {
			remoteAddr = x;
		} else if((x = request.getHeader("Proxy-Client-IP")) != null) {
			remoteAddr = x;
		} else if((x = request.getHeader("WL-Proxy-Client-IP")) != null) {
			remoteAddr = x;
		}
		return remoteAddr; 
	}
	
	public static String getIpAddr(HttpServletRequest request) {
       String ip = request.getHeader("x-forwarded-for");
       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getHeader("HEADER_X_FORWARDED_FOR");
       }
       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getHeader("Proxy-Client-IP");
       }
       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getHeader("WL-Proxy-Client-IP");
       }
       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
           ip = request.getRemoteAddr();
       }
       return ip;
   }
	
	public  static void main(String[] args){
		long start = System.currentTimeMillis();
		String ip ="";
		for (int i = 0; i < 1000000; i++) {
			ip = LOCAL_IP_STR;
		}
		long end = System.currentTimeMillis();

        System.out.println("耗时:" + (end-start));
		System.out.println("ip___----"+ip);
	}
}