package com.dh.entity;

import java.io.Serializable;

public class Picture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String pId;// 图片对应的Id

	private String pUrlOne;// 底部产品图片1;

	private String pUrlTwo;// 底部产品图片2;

	private String pUrlThree;// 底部产品图片3;

	private String pathpUrl;// 公司对应的logo图(底部);

	private String pPath;// 公司对应的地址;

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpUrlOne() {
		return pUrlOne;
	}

	public void setpUrlOne(String pUrlOne) {
		this.pUrlOne = pUrlOne;
	}

	public String getpUrlTwo() {
		return pUrlTwo;
	}

	public void setpUrlTwo(String pUrlTwo) {
		this.pUrlTwo = pUrlTwo;
	}

	public String getpUrlThree() {
		return pUrlThree;
	}

	public void setpUrlThree(String pUrlThree) {
		this.pUrlThree = pUrlThree;
	}

	public String getPathpUrl() {
		return pathpUrl;
	}

	public void setPathpUrl(String pathpUrl) {
		this.pathpUrl = pathpUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getpPath() {
		return pPath;
	}

	public void setpPath(String pPath) {
		this.pPath = pPath;
	}


}
