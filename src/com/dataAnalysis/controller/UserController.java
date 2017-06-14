package com.dataAnalysis.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.dataAnalysis.config.ResultCodeEnum;
import com.dataAnalysis.model.User;
import com.dataAnalysis.pojo.BaseResponse;
import com.dataAnalysis.service.UserService;
import com.jfinal.core.Controller;
/**
 * 
 * @author ZhuTing
 *
 */
public class UserController extends Controller{
    private final Logger log=Logger.getLogger(UserController.class);//日志
    private UserService userService= null;
    
    public UserController(){
    	userService= new UserService();
    	
    }
    
    /**
     * 用户登录
     */
    public void login()
    {
    	System.out.println("正在调用login()");
    	//System.out.println(this.getPara("Username")+" "+this.getPara("Upassword"));
    	BaseResponse response=new BaseResponse();
    	if(this.getPara("Username")== null || this.getPara("Upassword")== null)
    	{
    		response.setResult(ResultCodeEnum.NOT_ENOUGH_PARA);
    		//System.out.println(ResultCodeEnum.NOT_ENOUGH_PARA);
    	}
    	else
    	{
    		System.out.println("准备进入Userservice的login方法");
    		ResultCodeEnum result=userService.login(this.getPara("Username"), this.getPara("Upassword"));
    		System.out.println(this.getPara("Username")+" "+this.getPara("Upassword"));
    		response.setResult(result);
    		if(result.getCode().equals(ResultCodeEnum.LOGIN_SUCCESS_ADMIN.getCode()))
    		{//管理员
    			this.setSessionAttr("LoginUsername", userService.getAdministrator(this.getPara("Username")));
    		}
    		else if(result.getCode().equals(ResultCodeEnum.LOGIN_SUCCESS_NORMAL.getCode()))
    		{//普通用户
    			//System.out.println(this.getPara("Username")+this.getPara("Upassword"));
    			this.setSessionAttr("LoginUsername", userService.getUserByUsername(this.getPara("Username")));
    		}
    	}
    	this.renderJson(response);//返回成功登陆的标志
    }
    
    //判断注册时用户名是否唯一
    public void checkUsernameUnique()
    {
    	System.out.println("正在调用checkUsernameUnique()");
    	BaseResponse response=new BaseResponse();
    	System.out.println("准备进入Userservice的checkUsernameUnique方法");
    	ResultCodeEnum result=userService.checkUsernameUnique(this.getPara("Username"));
    	response.setResult(result);
    	this.renderJson(response);
    }
    
    /*
     * 用户注册
     */
    public void register()
    {
    	System.out.println("正在调用register()");
    	BaseResponse response=new BaseResponse();
    	String Username=getRequest().getParameter("username");
    	String Uname=getRequest().getParameter("name");
    	String Usex=getRequest().getParameter("sex");
    	String Udepartment=getRequest().getParameter("department");
    	String Uphone=getRequest().getParameter("telephone");
    	String Upassword=getRequest().getParameter("password");
    	System.out.println(Username+"  "+Uname+"  "+Usex+"  "+Udepartment+"  "+Uphone+"  "+Upassword);
    	int Usexint;
    	if(Usex.equals("男"))//将性别转为0或1
    		Usexint=1;
    	else
    		Usexint=0;
    	SimpleDateFormat Uaddtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//获取系统当前时间
        System.out.println(Uaddtime.format(new Date()));
        String Did=userService.SearchDid(Udepartment);//根据用户注册时的部门名称查询相应的部门ID
        System.out.println(Did);
        boolean adduser=new User().set("Username", Username)
        		            .set("Uname", Uname)
        		            .set("Usex", Usexint)
        		            .set("Udepartment", Did)
        		            .set("Uphone", Uphone)
        		            .set("Upassword", Upassword)
        		            .set("Ustate", "0")
        		            .set("Uaddtime",Uaddtime.format(new Date()))
        		            .set("Utype","0")
        		            .save();//进行所有注册的默认为普通用户，所以Utype默认为0，Ustate默认为待验证
       
    	if(adduser)//根据返回的bool值判断是否注册成功
    	{
    		response.setResult(ResultCodeEnum.REGISTER_SUCCESS);
    	}
    	else
    	{
    		response.setResult(ResultCodeEnum.REGISTER_FAILED);
    	}
    	this.renderJson(response);
    }
    
}
