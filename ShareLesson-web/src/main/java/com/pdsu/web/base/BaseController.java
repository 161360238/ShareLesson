package com.pdsu.web.base;



import com.pdsu.pojo.User;
import com.pdsu.service.RedisService;
import com.pdsu.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基础controller
 * 
 * @author mike
 *
 */
public class BaseController {

	@Autowired
	private RedisService redisServiceImpl;

	/**
	 * 获取user用户
	 * @return
	 */
	protected User getUser(String token) {
		if (token == null) {
			return null;
		}
		String json = redisServiceImpl.get(token);
		if (json != null && !json.equals("")) {
			User user = JsonUtils.jsonToPojo(json, User.class);
			//可以把密码清空
			user.setPassword(null);
			return user;
		} else {
			return null;
		}
	}
}
