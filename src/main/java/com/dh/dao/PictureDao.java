package com.dh.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dh.entity.Picture;

public interface PictureDao {

	List<Picture> queryContents(Picture picture);

	int deletePic(Picture picture);
	 
	int insertPicByMap(Map map);

	int updatePic(Map map);

	Picture selectPicById(Picture picture);

	/**
	 * 求总和
	 * 
	 * @param picture
	 * @return
	 */
	int selectCountPic(@Param("id") String id);
}
