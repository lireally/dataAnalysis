package com.dataAnalysis.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUsertable<M extends BaseUsertable<M>> extends Model<M> implements IBean {

	public void setUtid(java.lang.String Utid) {
		set("Utid", Utid);
	}

	public java.lang.String getUtid() {
		return get("Utid");
	}

	public void setUtuid(java.lang.String Utuid) {
		set("Utuid", Utuid);
	}

	public java.lang.String getUtuid() {
		return get("Utuid");
	}

	public void setUttid(java.lang.String Uttid) {
		set("Uttid", Uttid);
	}

	public java.lang.String getUttid() {
		return get("Uttid");
	}

}
