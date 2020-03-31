package com.dh.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dh.dao.IExcelDao;
import com.dh.entity.ExcelBean;
import com.dh.entity.User;
import com.dh.service.IExcelServcie;
import com.dh.utils.ExcelUtil;

@Service
public class ExcelServiceImpl implements IExcelServcie {

	@Autowired
	private IExcelDao excelDao;

	@Override
	public void importExcelInfo(InputStream in, MultipartFile file, String salaryDate, Integer adminId)
			throws Exception {
		// TODO Auto-generated method stub
		// 去除excel表中所有的数据
		List<List<Object>> listob = ExcelUtil.getBankListByExcel(in, file.getOriginalFilename());

		List<User> listUser = new ArrayList<User>();
		// 遍历listob数据，把数据放到List中 ,再批量添加
		for (int i = 0; i < listob.size(); i++) {
			List<Object> ob = listob.get(i);
			User user = new User();
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			user.setId(uuid);
			user.setUsername(String.valueOf(ob.get(0)));// 设置对象对应属性
			user.setUserpwd(String.valueOf(ob.get(1)));
			user.setMoney(Double.parseDouble(ob.get(2).toString()));
			listUser.add(user);
		}

		excelDao.insertUser(listUser);

	}

	@Override
	public XSSFWorkbook exportExcelInfo() throws Exception {
		// 创建新的Excel工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 创建工作表1：数据统计
		// 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称
		XSSFSheet totalSheet = workbook.createSheet("人员工资");
		List<ExcelBean> totalExcel = new ArrayList<ExcelBean>();
		Map<Integer, List<ExcelBean>> totalMapExcel = new LinkedHashMap<Integer, List<ExcelBean>>();
		// 设置标题栏
		totalExcel.add(new ExcelBean("账号", "username", 0));
		totalExcel.add(new ExcelBean("密码", "userpwd", 0));
		totalExcel.add(new ExcelBean("工资", "money", 0));
		totalMapExcel.put(0, totalExcel);
		ExcelUtil.createFont(workbook); // 字体样式
		ExcelUtil.createTableHeader(totalSheet, totalMapExcel); // 创建标题（头）
		// 查询统计总数
		List<User> user = excelDao.queryUser();
		ExcelUtil.createTableRows(totalSheet, totalMapExcel, user, User.class); // 创建内容

		// 创建工作表2：已交数据统计
		XSSFSheet haveSheet = workbook.createSheet("已交数据统计");
		List<ExcelBean> haveExcel = new ArrayList<ExcelBean>();
		Map<Integer, List<ExcelBean>> haveMapExcel = new LinkedHashMap<Integer, List<ExcelBean>>();
		// 设置标题栏
		haveExcel.add(new ExcelBean("密码", "userpwd", 0));
		haveExcel.add(new ExcelBean("工资", "money", 0));

		haveMapExcel.put(0, haveExcel);
		ExcelUtil.createFont(workbook); // 字体样式
		ExcelUtil.createTableHeader(haveSheet, haveMapExcel); // 创建标题（头）
		// 查询所有已交费用数据
		List<User> user_2 = excelDao.queryUser();
		ExcelUtil.createTableRows(haveSheet, haveMapExcel, user_2, User.class); // 创建内容

		/*
		 * // 创建工作表3：未交数据统计 XSSFSheet noSheet = workbook.createSheet("未交数据统计");
		 * List<ExcelBean> noExcel = new ArrayList<ExcelBean>(); Map<Integer,
		 * List<ExcelBean>> noMapExcel = new LinkedHashMap<Integer,
		 * List<ExcelBean>>(); // 设置标题栏 noExcel.add(new ExcelBean("所属楼栋",
		 * "building", 0)); noExcel.add(new ExcelBean("公司名称", "companyname",
		 * 0)); noExcel.add(new ExcelBean("未交房租费", "statisRent", 0));
		 * noExcel.add(new ExcelBean("未交物业费", "statisProperty", 0));
		 * noExcel.add(new ExcelBean("支付方式", "paymentname", 0)); noExcel.add(new
		 * ExcelBean("应缴时间", "remindertime", 0)); noExcel.add(new
		 * ExcelBean("联系人", "companyperson", 0)); noExcel.add(new
		 * ExcelBean("联系方式", "companytel", 0)); noMapExcel.put(0, noExcel);
		 * ExcelUtil.createFont(workbook); // 字体样式
		 * ExcelUtil.createTableHeader(noSheet, noMapExcel); // 创建标题（头） //
		 * 查询所有未交费用数据 List<PropertysVO> noPropVOs =
		 * this.selectPropStatistics(null, "", "", 0, null);
		 * ExcelUtil.createTableRows(noSheet, noMapExcel, noPropVOs,
		 * PropertysVO.class); // 创建内容
		 */
		return workbook;
	}

}
