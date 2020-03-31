package com.dh.dao;

import java.util.List;

import com.dh.entity.EBook;
import com.dh.entity.Permission;
import com.dh.entity.Tree;

public interface PermissionDao {

	 
	 /**
	  * 通过用户ID查询对应的权限
	  * @param uiId
	  * @return
	  */
	 List<Tree>  queryListMenu(String uiId);

	/**
	 * 通过用户ID删除对应的权限Id
	 * 
	 * @param uiId
	 * @return
	 */
	int deletePermission(String uiId);

	/**
	 * 批量添加
	 * 
	 * @param list
	 * @return
	 */
	int insertPermission(List<Permission> list);

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