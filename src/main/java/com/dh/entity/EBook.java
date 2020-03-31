package com.dh.entity;

import java.util.Date;

public class EBook extends Page {

	private String ebId;// 电子书编号

	private Integer ebcId;// 分类编号

	private String eName;// 分类名称

	private String ebTitle;// 电子书名称

	private String ebImg;// 电子书图片

	private String ebAuthor;// 电子书作者

	private Date ebIndt;// 入库时间

	private Date ebOutdt;// 到期时间

	private String ebOutdtName;// 到期时间

	private Integer ebStatus;// 电子书状态 0－启用，1－禁用

	private Integer ebType;// 电子书类型 0－书、1－音频

	private String ebContent;// 电子书内容介绍

	private String ebclosure;// 附件地址

	private String ebclosureName;// 附件名称

	private Integer ebFilesize;// 文件的大小

	private String ebFiletype;// 文件类型

	private Integer ebIfencrypt;// 是否加密,0－不加密，1－加密

	private String sName;// 状态名称

	private String tName;// 类型名称

	private String pName;// 一级名称

	private Integer ebSort;// 排序
	private String ebContext;// 内容

	private String ebMp3;// 音频路径

	private String ebmp3Name;// 音频名称

	private Integer ebAutowrap;// 自动换行 0-默认居中 1-自动换行

	private boolean isFavorite = false;// 是否收藏

	public String getEbId() {
		return ebId;
	}

	public void setEbId(String ebId) {
		this.ebId = ebId;
	}

	public Integer getEbcId() {
		return ebcId;
	}

	public void setEbcId(Integer ebcId) {
		this.ebcId = ebcId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getEbTitle() {
		return ebTitle;
	}

	public void setEbTitle(String ebTitle) {
		this.ebTitle = ebTitle;
	}

	public String getEbImg() {
		return ebImg;
	}

	public void setEbImg(String ebImg) {
		this.ebImg = ebImg;
	}

	public String getEbAuthor() {
		return ebAuthor;
	}

	public void setEbAuthor(String ebAuthor) {
		this.ebAuthor = ebAuthor;
	}

	public Date getEbIndt() {
		return ebIndt;
	}

	public void setEbIndt(Date ebIndt) {
		this.ebIndt = ebIndt;
	}

	public Date getEbOutdt() {
		return ebOutdt;
	}

	public void setEbOutdt(Date ebOutdt) {
		this.ebOutdt = ebOutdt;
	}

	public String getEbOutdtName() {
		return ebOutdtName;
	}

	public void setEbOutdtName(String ebOutdtName) {
		this.ebOutdtName = ebOutdtName;
	}

	public Integer getEbStatus() {
		return ebStatus;
	}

	public void setEbStatus(Integer ebStatus) {
		this.ebStatus = ebStatus;
	}

	public Integer getEbType() {
		return ebType;
	}

	public void setEbType(Integer ebType) {
		this.ebType = ebType;
	}

	public String getEbContent() {
		return ebContent;
	}

	public void setEbContent(String ebContent) {
		this.ebContent = ebContent;
	}

	public String getEbclosure() {
		return ebclosure;
	}

	public void setEbclosure(String ebclosure) {
		this.ebclosure = ebclosure;
	}

	public String getEbclosureName() {
		return ebclosureName;
	}

	public void setEbclosureName(String ebclosureName) {
		this.ebclosureName = ebclosureName;
	}

	public Integer getEbFilesize() {
		return ebFilesize;
	}

	public void setEbFilesize(Integer ebFilesize) {
		this.ebFilesize = ebFilesize;
	}

	public String getEbFiletype() {
		return ebFiletype;
	}

	public void setEbFiletype(String ebFiletype) {
		this.ebFiletype = ebFiletype;
	}

	public Integer getEbIfencrypt() {
		return ebIfencrypt;
	}

	public void setEbIfencrypt(Integer ebIfencrypt) {
		this.ebIfencrypt = ebIfencrypt;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getEbSort() {
		return ebSort;
	}

	public void setEbSort(Integer ebSort) {
		this.ebSort = ebSort;
	}

	public String getEbContext() {
		return ebContext;
	}

	public void setEbContext(String ebContext) {
		this.ebContext = ebContext;
	}

	public String getEbMp3() {
		return ebMp3;
	}

	public void setEbMp3(String ebMp3) {
		this.ebMp3 = ebMp3;
	}

	public String getEbmp3Name() {
		return ebmp3Name;
	}

	public void setEbmp3Name(String ebmp3Name) {
		this.ebmp3Name = ebmp3Name;
	}

	public Integer getEbAutowrap() {
		return ebAutowrap;
	}

	public void setEbAutowrap(Integer ebAutowrap) {
		this.ebAutowrap = ebAutowrap;
	}

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

}
