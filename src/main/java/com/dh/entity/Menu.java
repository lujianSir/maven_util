package com.dh.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单管理表
 * @author Administrator
 *
 */
public class Menu implements Serializable{
    private String mId;//菜单编号

    private String mName;//菜单名称

    private String mPid;//菜单父编号
    
    private String mUrl;//菜单对应的访问地址
    
    private Date mDt;//添加时间
    
    private Integer mDisable;// 0-开启 1-禁用
    
    private String mDisableName;
    
    private List<Menu> menus;
   
	public String getmDisableName() {
		return mDisableName;
	}

	public void setmDisableName(String mDisableName) {
		this.mDisableName = mDisableName;
	}

	public Integer getmDisable() {
		return mDisable;
	}

	public void setmDisable(Integer mDisable) {
		this.mDisable = mDisable;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public String getmUrl() {
		return mUrl;
	}

	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}

	public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId == null ? null : mId.trim();
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getmPid() {
        return mPid;
    }

    public void setmPid(String mPid) {
        this.mPid = mPid == null ? null : mPid.trim();
    }

	public Date getmDt() {
		return mDt;
	}

	public void setmDt(Date mDt) {
		this.mDt = mDt;
	}
}