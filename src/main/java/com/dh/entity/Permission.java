package com.dh.entity;
/**
 * 权限表
 * @author Administrator
 *
 */
public class Permission {
    private String uiId;//用户编号

    private String mId;//菜单编号

    public String getUiId() {
        return uiId;
    }

    public void setUiId(String uiId) {
        this.uiId = uiId == null ? null : uiId.trim();
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId == null ? null : mId.trim();
    }
}