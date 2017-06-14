package com.dataAnalysis.controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller {

	 public void index(){
		//默认用户或系统管理员进入系统时首先进入的是首页，如果要进行其他操作则需要验证当前用户是否登陆处于已登陆状态，如未登陆则要求用户登录
		 this.renderHtml("<script>window.location.href='/dataAnalysis/view/index.html';</script>");
		 
	 }
}
