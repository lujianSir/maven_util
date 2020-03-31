package com.dh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dh.entity.FileInfo;
import com.dh.entity.Result;
import com.dh.service.FileService;

@Controller
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileService fileService;

	/**
	 * 实现文件上传
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Result<?> fileUpload(HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		String str = fileService.fileUpload(file);
		return Result.success(str);
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	@RequestMapping("/queryFileInfos")
	@ResponseBody
	public Result<?> queryFileInfos() {
		List<FileInfo> list = fileService.queryFileInfos();
		return Result.success(list);
	}

	/**
	 * 下载
	 * 
	 * @param request
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/fileDownLoad")
	public ResponseEntity<byte[]> fileDownLoad(HttpServletRequest request, String fileName) throws Exception {

		ServletContext servletContext = request.getServletContext();
		String realPath = System.getProperty("catalina.home") + "/upload/file/" + fileName;// 得到文件所在位置
		InputStream in = new FileInputStream(new File(realPath));// 将该文件加入到输入流之中
		byte[] body = null;
		body = new byte[in.available()];// 返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取（或跳过）的估计剩余字节数
		in.read(body);// 读入到输入流里面

		fileName = new String(fileName.getBytes("gbk"), "iso8859-1");// 防止中文乱码
		HttpHeaders headers = new HttpHeaders();// 设置响应头
		headers.add("Content-Disposition", "attachment;filename=" + fileName);
		HttpStatus statusCode = HttpStatus.OK;// 设置响应吗
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;

		// public ResponseEntity（T body，
		// MultiValueMap < String，String > headers，
		// HttpStatus statusCode）
		// HttpEntity使用给定的正文，标题和状态代码创建一个新的。
		// 参数：
		// body - 实体机构
		// headers - 实体头
		// statusCode - 状态码
	}
}
