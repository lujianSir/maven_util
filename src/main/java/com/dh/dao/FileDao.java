package com.dh.dao;

import java.util.List;

import com.dh.entity.FileInfo;

public interface FileDao {
	// 添加文件信息
	public void insertFileInfo(FileInfo fileInfo);

	List<FileInfo> queryFileInfos();
}
