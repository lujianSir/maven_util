package com.dh.service;

import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public interface IExcelServcie {

	/**
	 * 上传excel
	 */
	void importExcelInfo(InputStream in, MultipartFile file, String salaryDate, Integer adminId) throws Exception;

	/**
	 * 生成Excel表格对象
	 * 
	 * @return
	 */
	public XSSFWorkbook exportExcelInfo() throws Exception;

}
