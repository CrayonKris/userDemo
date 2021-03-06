package cn.com.bonc.util;

/**
 *
 * @author zhijie.ma
 * @date 2017年12月8日
 * 
 */
public enum MyBusinessEnum {
	/**
	 * 业务级成功
	 */
	BUSINESS_SUCCESS(0),
	/**
	 * 业务级失败
	 */
	BUSINESS_ERROR(1),
	
	/**
	 * 用户未登录
	 */
	UNLOGIN(2),
	
	/**
	 * 无数据
	 */
	UNDATA(3),
	
	/**
	 * 无操作权限
	 */
	UNPERMISSION(4);
	
	private int businessCode;

	private MyBusinessEnum(int ordinal) {
		// TODO Auto-generated constructor stub
		this.businessCode = ordinal;
	}

	public int getA() {
		return businessCode;
	}

	public void setA(int businessCode) {
		this.businessCode = businessCode;
	}
	
	
	
}
