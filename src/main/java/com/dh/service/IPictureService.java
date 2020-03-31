package com.dh.service;

import java.util.List;
import java.util.Map;

import com.dh.entity.Picture;

public interface IPictureService {

	List<Picture> queryContentResult(Picture picture);
	 
	int deletePic(Picture picture);

	int insertPicByMap(Map map);

	Picture selectPicById(Picture picture);
}
