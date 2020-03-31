package com.dh.service;

import java.util.List;

import com.dh.entity.EBook;
import com.dh.entity.Tree;

public interface IPermissionService {
	 /**
	  * 通过用户ID查询对应的权限
	  * @param uiId 用户ID
	  * @return 结果
	  */
	List<Tree> queryListMenu(String uiId);

	/**
	 * 添加权限
	 * 
	 * @param uiId
	 * @param arrayTrees
	 * @return
	 */
	int insertPermission(String uiId, String arrayTrees);

	/**
	 * 总数
	 * 
	 * @param ebook
	 * @return
	 */
	int getTotal(EBook ebook);

	/**
	 * 分页显示
	 * 
	 * @param ebook
	 * @return
	 */
	List<EBook> getUserListPage(EBook ebook);
}


