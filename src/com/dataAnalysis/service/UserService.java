package com.dataAnalysis.service;

import com.dataAnalysis.config.ResultCodeEnum;
import com.dataAnalysis.model.Department;
import com.dataAnalysis.model.User;

public class UserService {
	/**
	    * 登录方法
	    * @param Username,Upassword
	    */
		public ResultCodeEnum login(String Username,String Upassword){
			System.out.println("进入到userservice中的login(), Username:"+Username+"  "+"Upassword:"+Upassword);
			User user=User.dao.findFirst("select * from user where Username=? and Upassword=?",Username,Upassword);
			System.out.println("成功连接上数据库");
			//Users user=Users.dao.findFirst("select * from user");
			//Record record=Db.findFirst("select * from user");
			//System.out.println(record.getStr("Username"));
			if(user == null){
				System.out.println("该用户不存在");
				return ResultCodeEnum.ERROR_USERNAME_OR_UPASSWORD;
			}
			else{
				System.out.println("该用户存在");
				if(Username == "admin" && Upassword == "admin")
				{
					return ResultCodeEnum.LOGIN_SUCCESS_ADMIN;
				}else{
					return ResultCodeEnum.LOGIN_SUCCESS_NORMAL;
				}
			}	
		}
		
		/**
		 * 获取系统管理员
		 */
		public User getAdministrator(String Username)
		{
			return User.dao.findFirst("select * from user where Username=?",Username);
		}
		
		/**
		 * 获取普通用户信息
		 */
		public User getUserByUsername(String Username)
		{
			return User.dao.findFirst("select * from user where Username=?", Username);
		}
		
		/*
		 * 判断注册的用户名是否唯一
		 */
		public ResultCodeEnum checkUsernameUnique(String Username)
		{
			User user=User.dao.findFirst("select * from user where Username=?",Username);
			if(user == null)
			{
				return ResultCodeEnum.UNIQUE_USERNAME;
			}
			else{
				return ResultCodeEnum.REPET_USERNAME;
			}
		}
		
		/*
		 * 根据用户注册时的部门查询相应的部门id号
		 */
		public  String SearchDid(String Udepartment)
		{
			Department department=Department.dao.findFirst("select * from department where Dname=?",Udepartment);
			String Did=department.getDid();
			return Did;
		}
}
