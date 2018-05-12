/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.material.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.material.entity.MaterialInfo;
import com.jeesite.modules.material.entity.MaterialRequirements;
import com.jeesite.modules.material.service.MaterialRequirementsService;

/**
 * 采购需求单Controller
 * @author 张雷
 * @version 2018-05-12
 */
@Controller
@RequestMapping(value = "${adminPath}/material/materialRequirements")
public class MaterialRequirementsController extends BaseController {

	@Autowired
	private MaterialRequirementsService materialRequirementsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MaterialRequirements get(String no, boolean isNewRecord) {
		return materialRequirementsService.get(no, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("material:materialRequirements:view")
	@RequestMapping(value = {"list", ""})
	public String list(MaterialRequirements materialRequirements, Model model) {
		model.addAttribute("materialRequirements", materialRequirements);
		return "modules/material/materialRequirementsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("material:materialRequirements:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MaterialRequirements> listData(MaterialRequirements materialRequirements, HttpServletRequest request, HttpServletResponse response) {
		Page<MaterialRequirements> page = materialRequirementsService.findPage(new Page<MaterialRequirements>(request, response), materialRequirements); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("material:materialRequirements:view")
	@RequestMapping(value = "form")
	public String form(MaterialRequirements materialRequirements, Model model) {
		model.addAttribute("materialRequirements", materialRequirements);
		MaterialInfo materialInfo = new MaterialInfo();
		model.addAttribute("materialInfo", materialInfo);
		return "modules/material/materialRequirementsForm";
	}

	/**
	 * 保存采购需求单
	 */
	@RequiresPermissions("material:materialRequirements:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MaterialRequirements materialRequirements) {
		materialRequirementsService.save(materialRequirements);
		return renderResult(Global.TRUE, "保存采购需求单成功！");
	}
	
	/**
	 * 删除采购需求单
	 */
	@RequiresPermissions("material:materialRequirements:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MaterialRequirements materialRequirements) {
		materialRequirementsService.delete(materialRequirements);
		return renderResult(Global.TRUE, "删除采购需求单成功！");
	}
	
}