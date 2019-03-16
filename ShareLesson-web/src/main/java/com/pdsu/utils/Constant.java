package com.pdsu.utils;


import java.util.ArrayList;
import java.util.List;

public class Constant {

	public static final String CLIENT_ID = "client";

	public static final String CLIENT_SECRET = "secret";

	public static final String SYMMETRY_KEY = "rbpsems";

	public static final int TOKEN_EXPIRE_TIME = -1;

	public static final int REFRESH_TOKEN_EXPIRE_TIME = -1;

	public static final String DEFAULT_SCOPE = "read,write";

	public static final String TASK_LOCK = "task_lock";

	public static final String DRUID = "/druid";
	public static final String FILE = "/file";
	public static final String EXCEL = "/excell";
	public static final String MESSAGE = "/message";
	public static final String DEVICE_QRCODE = "/device/deviceQrcode*";//履历列表二维码预览

	/**
	 * 不拦截的路径
	 */
	public static final List<String> IGNORE_PATHS;

	static {
		IGNORE_PATHS = new ArrayList<>();
		IGNORE_PATHS.add(DRUID + "/**");
		IGNORE_PATHS.add(EXCEL + "/**");
		IGNORE_PATHS.add(FILE + "/**");
		IGNORE_PATHS.add(MESSAGE + "/**");
		IGNORE_PATHS.add(DEVICE_QRCODE);
	}

	public static final String NOT_EXISTS_MSG = "数据不存在";

	public static final String USER_ID = "uid";

	public static final String USER_NAME = "user_name";

	/**
	 * 未传token;client的id和secret错误;访问无权限的web接口
	 */
	public static final String UNAUTHORIZED_CODE = "401";

	/**
	 * 服务器内部错误
	 */
	public static final String INTERNAL_ERROR_CODE = "500";

	/**
	 * 未知异常
	 */
	public static final String UNKNOW_ERROR_CODE = "600";

	/**
	 * 访问登陆接口, 未写用户名密码或者用户名密码不匹配
	 */
	public static final String USERNAME_OR_PASSWORD_ERROR_CODE = "601";

	/**
	 * 缺少grant_type
	 */
	public static final String MISSING_GRANT_TYPE_CODE = "602";

	/**
	 * token过期
	 */
	public static final String TOKEN_EXPIRED_CODE = "603";

	/**
	 * token解析错误
	 */
	public static final String BAD_TOKEN_CODE = "604";

	/**
	 * refresh_token过期
	 */
	public static final String REFRESH_TOKEN_EXPIRED_CODE = "605";

	/**
	 * 缺少参数
	 */
	public static final String MISSING_PARAMETER_CODE = "606";

	/**
	 * 参数类型不匹配
	 */
	public static final String ARG_TYPE_MISMATCH_CODE = "607";

	/**
	 * 404异常
	 */
	public static final String CANNOT_FOUND_ERROR_CODE = "404";

	/**
	 * 方法不被支持(如请求方式get, post)
	 */
	public static final String METHOD_NOT_SUPPORTED_CODE = "405";

	public static final String UNAUTHORIZED_MSG = "缺少凭据";

	public static final String INTERNAL_ERROR_MSG = "服务器内部错误";

	public static final String USERNAME_OR_PASSWORD_ERROR_MSG = "用户名或密码错误";

	public static final String OLD_PASSWORD_ERROR_MSG = "旧密码错误";

	public static final String METHOD_NOT_SUPPORTED_MSG = "请求方式错误";

	public static final String MISSING_GRANT_TYPE_MSG = "缺少授权方式";

	public static final String UNKNOW_ERROR_MSG = "未知异常";

	public static final String TOKEN_EXPIRED_MSG = "token已过期";

	public static final String BAD_TOKEN_MSG = "无效的token";

	public static final String REFRESH_TOKEN_EXPIRED_MSG = "refresh_token已过期";

	public static final String CANNOT_FOUND_ERROR_MSG = "资源无法找到";

	public static final String MISSING_PARAMETER_MSG = "缺少参数";

	public static final String ARG_TYPE_MISMATCH_MSG = "参数类型错误";

	public static final String EXISTS_RELATION_NOT_DELETE_MSG = "该数据存在关联关系数据，不允许删除";

	public static final String EXISTS_RELATION_NOT_DELETE_MSG_DEVICECATEGORY = "该数据存在下级设备类型，不允许更新";
	public static final String SAVE_ERROR = "保存数据失败";
	public static final String LENGTH_ERROR = "账号和密码长度不够";
	public static final String SAVE_SUCESS = "保存数据成功";
	public static final String UPDATE_ERROE = "更新数据失败";
	public static final String UPDATE_SUCESS = "更新数据成功";
	public static final String DELETE_ERROR = "删除数据失败";
	public static final String DELETE_SUCESS = "删除数据成功";
	public static final String SELECT_SUCESS = "查询数据成功";
	public static final String SELECT_ERROR = "查询数据失败";
	public static final String PERMISSION_ERROR = "权限不足，请联系管理员！";
	public static final String SERVICE_ERROR = "学生信息已被锁定！";
	public static final String TIME_ERROR = "此操作不在规定时间中，请联系管理员！";

	public final static class UserType {

		public final static String GUANLI = "0";

		public final static String YUANXI = "1";

		public final static String QIYE = "2";

		public final static String XUESHENG = "3";
	}

	public final static class Examine {

		public final static String SUCESS = "sucess";

		public final static String FAIL = "fail";

	}

	public final static class Conference {
		//	会议类型(0宣讲会-1招聘会-2双选会)默认为宣讲会

		public final static Integer XUANJIANg = 0;

		public final static Integer ZHAOPIN = 1;

		public final static Integer SHUANGXUNA = 2;
	}


	public final static class SHENHE {
		//设置审核状态 1代表审核成功 0代表审核失败，2，正在审核
		public final static Integer SUCESS = 1;

		public final static Integer ERROR = 0;

		public final static Integer WAIT = 2;
	}

	public final static class ConferenceType {
		//会议类型(0宣讲会-1招聘会-2双选会)默认为宣讲会
		public final static Integer XUAN = 0;

		public final static Integer ZHAO = 0;

		public final static Integer SHUANG = 2;
	}


}
