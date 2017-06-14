package com.dataAnalysis.config;

import com.dataAnalysis.controller.IndexController;
import com.dataAnalysis.controller.UserController;
import com.dataAnalysis.model._MappingKit;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;




/*
 * 通用信息配置类
 * @author ZhuTing
 * @date 2017.6.10
 */

public class Config extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		//首先要读取资源配置文件
		PropKit.use("dbconfig.properties");
		me.setDevMode(PropKit.getBoolean("devMode"));
		//me.setBaseUploadPath(PropKit.get("baseUploadPath"));
	}
    /*
     * 配置路由
     * 对所有的controller进行路由设置
     */
	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/",IndexController.class);
		me.add("/user", UserController.class);
		
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		//读取数据库配置文件
		Prop prop=PropKit.use("dbconfig.properties");
		//使用driud数据库连接池进行操作
		DruidPlugin druidPlugin=new DruidPlugin(prop.get("jdbcUrl"),prop.get("user"),prop.get("password").trim());
		System.out.println(prop.get("jdbcUrl")+"   "+prop.get("user")+"   "+prop.get("password"));
		me.add(druidPlugin);
	    //设置数据库活动记录插件
	    ActiveRecordPlugin arp=new ActiveRecordPlugin(druidPlugin);
	    arp.setContainerFactory(new CaseInsensitiveContainerFactory(true));//设置大小写不敏感
	    me.add(arp);
	    arp.setShowSql(true);
	    //设置关系映射
	    _MappingKit.mapping(arp);
	    
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
		
	}
	
    
}
