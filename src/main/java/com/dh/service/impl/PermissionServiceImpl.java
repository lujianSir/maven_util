package com.dh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.dao.PermissionDao;
import com.dh.entity.EBook;
import com.dh.entity.Permission;
import com.dh.entity.Tree;
import com.dh.service.IPermissionService;


@Service
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	public List<Tree> queryListMenu(String uiId) {
		// TODO Auto-generated method stub
		return permissionDao.queryListMenu(uiId);
	}

	@Override
	public int insertPermission(String uiId, String arrayTrees) {
		// TODO Auto-generated method stub
		List<Permission> list = new ArrayList<Permission>();
		if (arrayTrees != null && !("").equals(arrayTrees)) {
			permissionDao.deletePermission(uiId);
			String[] strs = arrayTrees.split(",");
			for (int i = 0; i < strs.length; i++) {
				Permission permission = new Permission();
				permission.setUiId(uiId);
				permission.setmId(strs[i]);
				list.add(permission);
			}
			if (list.size() > 0) {
				return permissionDao.insertPermission(list);
			}
		}

		return 0;
	}

	@Override
	public int getTotal(EBook ebook) {
		// TODO Auto-generated method stub
		return permissionDao.getTotal(ebook);
	}

	@Override
	public List<EBook> getUserListPage(EBook ebook) {
		// TODO Auto-generated method stub
		return permissionDao.getUserListPage(ebook);
	}

}
