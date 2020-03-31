package com.dh.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dh.service.IExcelServcie;
import com.dh.utils.JsonResult;

@Controller
@RequestMapping("/excel")
public class ExcelController {

	@Autowired
	private IExcelServcie excelServcie;

	// 表格的导入
	@RequestMapping("/impotr")
	@ResponseBody
	public JsonResult impotr(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request,
			ModelMap model) throws Exception {
		int adminId = 1;
		// 获取上传的文件
		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
		String month = request.getParameter("month");
		InputStream in = file.getInputStream();
		// 数据导入
		excelServcie.importExcelInfo(in, file, month, adminId);
		in.close();
		return new JsonResult(JsonResult.SUCCESS_CODE, "测试成功", "导入成功");
	}

	// 表格的导出
	@RequestMapping("/export")
	@ResponseBody
	public JsonResult export(HttpServletRequest request, HttpServletResponse response) {
		response.reset(); // 清除buffer缓存
		String primaryFileName = "所有人员统计_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String fileName;
		try {
			fileName = new String(primaryFileName.getBytes(), "ISO-8859-1");
			// // 解决乱码问题
			// 指定下载的文件名
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);

			XSSFWorkbook workbook = excelServcie.exportExcelInfo();
			OutputStream output;
			try {
				output = response.getOutputStream();
				BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
				bufferedOutPut.flush();
				workbook.write(bufferedOutPut);
				bufferedOutPut.close();
			} catch (IOException e) {
				System.err.println("ExcelController-----outputExcel:" + e.getMessage());
				return new JsonResult(JsonResult.FAILED_CODE, "导出异常", null);
			}
		} catch (Exception e) {
			System.err.println("ExcelController-----outputExcel:" + e.getMessage());
			return new JsonResult(JsonResult.FAILED_CODE, "导出异常", null);
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("fileName", fileName);
		System.out.println("ExcelController-----outputExcel:SUCCESS");
		return new JsonResult(JsonResult.SUCCESS_CODE, "导出成功", map);
	}

}
