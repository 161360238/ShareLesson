package com.pdsu.utils;




import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class TokenUtil {



	/**	从请求中获取token
	 * @param request
	 * @return
	 */
	public static String extractToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");

		return token;
	}


}
