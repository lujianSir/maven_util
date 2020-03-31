package com.dh.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dh.entity.FileInfo;

public interface FileService {

	// 文件信息上传
	public String fileUpload(MultipartFile file);

	List<FileInfo> queryFileInfos();
}
