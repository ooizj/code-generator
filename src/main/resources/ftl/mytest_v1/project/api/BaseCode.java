package #BASE_PACKAGE#.api;

/**
 * 
 * @author liuqing
 *
 */
public enum BaseCode implements IBaseCode{

	SUCCESS("0000", "操作成功"),
	ERROR("9999", "操作失败"),

	/**
	 * 系统错误代码
	 */
	SYSTEM_INTERNAL_ERROR("0001", "系统内部错误"),
	PARAMETER_INVALID("0002", "无效的参数"),
	PARAMETER_REQUIRED("0003", "必填参数未正确设置"),
	DATA_NOT_FOUND("0004", "未找到匹配的数据"),
	DATA_CONFLICT("0005", "数据冲突"),
	

	;


	private final String code;
	private final String message;
	private static final String NS = "B";

	BaseCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return getNamespace() + "" + code;
	}

	public String getMessage() {
		return message;
	}

	public String getNamespace() {
		return NS;
	}

}
