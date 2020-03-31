package com.dh.dao;

import java.util.List;

import com.dh.entity.User;

public interface IExcelDao {

	/**
	 * 批量添加数据
	 * 
	 * @param list
	 */
	void insertUser(List<User> list);

	/**
	 * 查询所有的用户
	 * 
	 * @return
	 */
	List<User> queryUser();
}
