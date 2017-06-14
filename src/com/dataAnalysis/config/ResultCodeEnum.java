package com.dataAnalysis.config;

/**
 * 列举返回的结果
 */
public enum ResultCodeEnum{
	
	NOT_LOGIN("-1", "您还未登录，请先登录！"),
	
	UNIQUE_USERNAME("100001","该用户名唯一，允许注册"),
	REPET_USERNAME("100002","该用户名已存在，请重新填写"),
	REGISTER_SUCCESS("100003","注册成功"),
	REGISTER_FAILED("100004","注册失败"),
	
	NOT_ENOUGH_PARA("100", "请将信息填写完整"),
	
	LOGIN_SUCCESS_ADMIN("200001","系统管理员登录成功"),
	ERROR_USERNAME_OR_UPASSWORD("20002","用户名或密码错误"),
	LOGIN_SUCCESS_NORMAL("200003","普通用户登录成功");
	
	private String code;
    private String desc;

    ResultCodeEnum(String code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    public String getCode()
    {
        return code;
    }

    public String getDesc()
    {
        return desc;
    }
}
