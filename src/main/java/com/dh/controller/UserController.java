package com.dh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dh.entity.EBook;
import com.dh.entity.PageHelper;
import com.dh.entity.Tree;
import com.dh.entity.User;
import com.dh.service.IPermissionService;
import com.dh.utils.JsonResult;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IPermissionService permissionService;

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String jumpIndex() {
		return "index";
	}


	/**
	 * json
	 * 
	 * @return
	 */
	@RequestMapping("/jsonIndex")
	@ResponseBody
	public String jsonIndex() {
		return "nihao";
	}

	/**
	 * 权限展示
	 * 
	 * @param uiId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryListMenu")
	@ResponseBody
	public List queryListMenu(String uiId) throws Exception {
		List<Tree> trees = permissionService.queryListMenu(uiId);
		for (int i = 0; i < trees.size(); i++) {
			if (trees.get(i).getStatus() == 1) {
				trees.get(i).setCheck(true);
			} else {
				trees.get(i).setCheck(false);
			}
		}
		return trees;
	}

	/**
	 * 授权
	 * 
	 * @param uiId
	 * @param arrayTrees
	 * @param response
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertPermission")
	@ResponseBody
	public JsonResult insertPermission(String uiId, String arrayTrees, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		int num = permissionService.insertPermission(uiId, arrayTrees);
		return new JsonResult(JsonResult.SUCCESS_CODE, "授权成功", num);
	}
	
	@RequestMapping("/queryListTable")
	@ResponseBody
	public List queryListTable() throws Exception {
		User user1 = new User();
		user1.setId("1");
		user1.setUsername("张三");
		user1.setUserpwd("123456");
		User user2 = new User();
		user2.setId("2");
		user2.setUsername("李四");
		user2.setUserpwd("123456");
		List<User> list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		return list;
	}
	
	@RequestMapping("/getEbookListPage")
	@ResponseBody
	public PageHelper<EBook> getUserListPage(EBook ebook, HttpServletRequest request) {

		PageHelper<EBook> pageHelper = new PageHelper<EBook>();
		// 统计总记录数
		Integer total = permissionService.getTotal(ebook);
		pageHelper.setTotal(total);

		// 查询当前页实体对象
		List<EBook> list = permissionService.getUserListPage(ebook);
		pageHelper.setRows(list);

		return pageHelper;
	}

}
