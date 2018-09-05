/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.finance.web;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.finance.entity.SalesPerformance;
import com.jeesite.modules.finance.service.SalesPerformanceService;
import com.jeesite.modules.material.entity.MaterialInfo;

/**
 * 材料清单Controller
 * @author 张雷
 * @version 2018-05-12
 */
@Controller
@RequestMapping(value = "${adminPath}/finance/salesPerformance")
public class SalesPerformanceController extends BaseController {

	@Autowired
	private SalesPerformanceService salesPerformanceService;
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("ifart:finance:salesPerformance:view")
	@RequestMapping(value = {"show", ""})
	public String show(SalesPerformance salesPerformance, Model model) {
		model.addAttribute("salesPerformance", salesPerformance);
		return "modules/finance/salesPerformance";
	}
	
	/**
	 * 查询数据
	 */
	@RequiresPermissions("ifart:finance:salesPerformance:view")
	@RequestMapping(value = {"find", ""})
	@ResponseBody
	public List<SalesPerformance> find(SalesPerformance salesPerformance) {
		return salesPerformanceService.find(salesPerformance);
	}
	
}