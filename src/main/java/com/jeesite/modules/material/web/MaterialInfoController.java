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
import com.jeesite.common.mybatis.mapper.SqlMap;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.material.entity.MaterialInfo;
import com.jeesite.modules.material.service.MaterialInfoService;

/**
 * 材料清单Controller
 * @author 张雷
 * @version 2018-05-12
 */
@Controller
@RequestMapping(value = "${adminPath}/material/materialInfo")
public class MaterialInfoController extends BaseController {

	@Autowired
	private MaterialInfoService materialInfoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MaterialInfo get(String id, boolean isNewRecord) {
		return materialInfoService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("material:materialInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(MaterialInfo materialInfo, Model model) {
		model.addAttribute("materialInfo", materialInfo);
		return "modules/material/materialInfoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("material:materialInfo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MaterialInfo> listData(MaterialInfo materialInfo, HttpServletRequest request, HttpServletResponse response) {
		Page<MaterialInfo> page = materialInfoService.findPage(new Page<MaterialInfo>(request, response), materialInfo); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("material:materialInfo:view")
	@RequestMapping(value = "form")
	public String form(MaterialInfo materialInfo, Model model) {
		model.addAttribute("materialInfo", materialInfo);
		return "modules/material/materialInfoForm";
	}

	/**
	 * 保存材料清单
	 */
	@RequiresPermissions("material:materialInfo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MaterialInfo materialInfo) {
		materialInfoService.save(materialInfo);
		return renderResult(Global.TRUE, "保存材料清单成功！");
	}
	
	/**
	 * 删除材料清单
	 */
	@RequiresPermissions("material:materialInfo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MaterialInfo materialInfo) {
		materialInfoService.delete(materialInfo);
		return renderResult(Global.TRUE, "删除材料清单成功！");
	}
	
}