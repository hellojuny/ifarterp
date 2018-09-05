/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.hellojuny.common.web;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeesite.common.web.BaseController;
import com.jeesite.common.web.http.ServletUtils;
import com.jeesite.hellojuny.common.entity.DateFile;
import com.jeesite.hellojuny.common.entity.DateTable;
import com.jeesite.hellojuny.common.service.DataIOService;

/**
 * 材料清单Controller
 * @author 张雷
 * @version 2018-05-12
 */
@Controller
@RequestMapping(value = "${adminPath}/common/dataIO")
public class DataIOController extends BaseController {

	@Autowired
	private DataIOService dataIOService;
	
	/**
	 * 页面显示
	 */
	@RequiresPermissions("hellojuny:common:dataIO:view")
	@RequestMapping(value = {"show", ""})
	public String show(Model model,HttpServletRequest req) {
		List<DateFile> fileList = new ArrayList<DateFile>();
		List<DateTable> bsTableList = new ArrayList<DateTable>();
		List<DateTable> sysTableList = new ArrayList<DateTable>();
		String realPath=ServletUtils.getRequest().getServletContext().getRealPath("");
		File realFile = new File(realPath);
		String uploadPath = realFile.getParent() + "/uploadFile";
		File uploadFile = new File(uploadPath);
		File[] tempList = uploadFile.listFiles();
		Arrays.sort(tempList);
		for (int i = 0; i < tempList.length; i++) {
			String fileName = tempList[i].getName();
			DateFile tFile = new DateFile();
			tFile.setFile(fileName);
			tFile.setFileName(fileName.substring(0, fileName.lastIndexOf(".")));
			fileList.add(tFile);
		}
		//MapUtils.toMap(object)
		List<DateTable> tableArray = dataIOService.findAllTables();
		for (DateTable dt : tableArray) {
			DateTable dataTable = new DateTable(dt);
			String tableName = dt.getTableName();
			if (tableName.length() > 3 && "js_".equals(tableName.substring(0, 3))) {
				sysTableList.add(dataTable);
			} else {
				bsTableList.add(dataTable);
			}
			
		}
		model.addAttribute("bsTableList", bsTableList);
		model.addAttribute("sysTableList", sysTableList);
		model.addAttribute("fileList", fileList);
		return "hellojuny/common/dataIO";
	}
	
}