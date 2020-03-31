package com.dh.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dh.dao.FileDao;
import com.dh.entity.FileInfo;
import com.dh.service.FileService;
import com.dh.utils.Utils;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDao fileDao;

	@Override
	public String fileUpload(MultipartFile file) {
		// TODO Auto-generated method stub
		if (!file.isEmpty()) {
			try {
				// 文件1存放服务端的位置
				File dir = null;
				// long now = System.currentTimeMillis();
				// String filesuffix =
				// file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
				// String filename = now + filesuffix;
				String filename = file.getOriginalFilename();
				String newrootPath = System.getProperty("catalina.home") + "/upload";
				System.out.println(newrootPath);
				dir = new File(newrootPath + File.separator + "file" + File.separator);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				String filePath = dir.getAbsolutePath() + File.separator + filename;

				// 写文件到服务器
				File serverFile = new File(filePath);
				file.transferTo(serverFile);

				// 录入文件信息
				FileInfo fileinfo = new FileInfo();
				fileinfo.setFname(filename);
				fileinfo.setFrealurl(filePath);
				String fvirtualurl = "";
				fvirtualurl = "/file/" + filename;
				fileinfo.setFvirtualurl(fvirtualurl);
				fileinfo.setFuploadtime(Utils.getCurrent());
				fileDao.insertFileInfo(fileinfo);
				return fvirtualurl;
			} catch (Exception e) {
				return "服务端错误";
			}
		} else {
			return "请上传文件";
		}
	}

	@Override
	public List<FileInfo> queryFileInfos() {
		// TODO Auto-generated method stub
		return fileDao.queryFileInfos();
	}

}
