package com.dataAnalysis.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDatabase<M extends BaseDatabase<M>> extends Model<M> implements IBean {

	public void setDbid(java.lang.String Dbid) {
		set("Dbid", Dbid);
	}

	public java.lang.String getDbid() {
		return get("Dbid");
	}

	public void setDbname(java.lang.String Dbname) {
		set("Dbname", Dbname);
	}

	public java.lang.String getDbname() {
		return get("Dbname");
	}

	public void setDbaddress(java.lang.String Dbaddress) {
		set("Dbaddress", Dbaddress);
	}

	public java.lang.String getDbaddress() {
		return get("Dbaddress");
	}

	public void setDbuname(java.lang.String Dbuname) {
		set("Dbuname", Dbuname);
	}

	public java.lang.String getDbuname() {
		return get("Dbuname");
	}

	public void setDbpassword(java.lang.String Dbpassword) {
		set("Dbpassword", Dbpassword);
	}

	public java.lang.String getDbpassword() {
		return get("Dbpassword");
	}

	public void setDbdriver(java.lang.String Dbdriver) {
		set("Dbdriver", Dbdriver);
	}

	public java.lang.String getDbdriver() {
		return get("Dbdriver");
	}

	public void setDbdescription(java.lang.String Dbdescription) {
		set("Dbdescription", Dbdescription);
	}

	public java.lang.String getDbdescription() {
		return get("Dbdescription");
	}

	public void setDbaddtime(java.util.Date Dbaddtime) {
		set("Dbaddtime", Dbaddtime);
	}

	public java.util.Date getDbaddtime() {
		return get("Dbaddtime");
	}

}
