package com.dh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.dao.PictureDao;
import com.dh.entity.Picture;
import com.dh.service.IPictureService;

@Service
public class PictureServiceImpl implements IPictureService {

	@Autowired
	private PictureDao pictureDao;

	public List<Picture> queryContentResult(Picture picture) {
		// TODO Auto-generated method stub
		List<Picture> pictures = pictureDao.queryContents(picture);
		return pictures;
	}

	public int deletePic(Picture picture) {
		// TODO Auto-generated method stub
		return pictureDao.deletePic(picture);
	}

	public int insertPicByMap(Map map) {
		// TODO Auto-generated method stub
		int num = 0;
		if (map.get("pId") != null && !("").equals(map.get("pId"))) {
			num = pictureDao.updatePic(map);
		} else {
			String hId = UUID.randomUUID().toString().replace("-", "");
			map.put("pId", hId);
			num = pictureDao.insertPicByMap(map);
		}
		return num;
	}

	public Picture selectPicById(Picture picture) {
		// TODO Auto-generated method stub
		return pictureDao.selectPicById(picture);
	}


}
