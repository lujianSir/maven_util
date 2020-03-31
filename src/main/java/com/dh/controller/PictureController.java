package com.dh.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dh.entity.Picture;
import com.dh.service.IPictureService;
import com.dh.utils.JsonResult;


/**
 * 栏目controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/pic")
public class PictureController {

	@Autowired
	private IPictureService pictureService;
	
	@RequestMapping("/listPicture")
	@ResponseBody
	public JsonResult queryContentResult(Picture picture) {
		List<Picture> list = pictureService.queryContentResult(picture);
		return new JsonResult(JsonResult.SUCCESS_CODE, "查询成功", list);
	}

	@RequestMapping("/insertPic")
	@ResponseBody
	public JsonResult insertHead(@RequestParam(value = "file", required = false) MultipartFile[] files,
			HttpServletRequest request) {
		String fileName = "";
		Map<String, Object> map = new HashMap<String, Object>();
		// int num=contentService.insertContent(content);
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String filePath = request.getServletContext().getRealPath("/") + "/imgPath/headImg/";// 图片保存的地址
			String contentType = file.getContentType();
			String houzhui = contentType.substring(contentType.indexOf("/") + 1);// 获取后缀
			fileName = new Date().getTime() + file.getOriginalFilename() + "." + houzhui;
			System.out.println("图片地址：" + filePath);
			File targetFile = new File(filePath, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 保存
			try {
				files[i].transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 添加图片路径到map集合
			map.put(files[i].getOriginalFilename(), "../imgPath/headImg/" + fileName);
			}
		map.put("pPath", request.getParameter("pPath"));
		map.put("pId", request.getParameter("pId"));
		int num = pictureService.insertPicByMap(map);
		return new JsonResult(JsonResult.SUCCESS_CODE, "查询成功", num);
	}

	@RequestMapping("/deletePicById")
	@ResponseBody
	public JsonResult deletePicById(Picture picture) {
		int num = pictureService.deletePic(picture);
		return new JsonResult(JsonResult.SUCCESS_CODE, "查询成功", num);
	}

	@RequestMapping("/queryPic")
	@ResponseBody
	public JsonResult queryPic(Picture picture) {
		Picture h = pictureService.selectPicById(picture);
		return new JsonResult(JsonResult.SUCCESS_CODE, "查询成功", h);
	}
}
