/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

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
import com.jeesite.modules.common.entity.CommonSeq;
import com.jeesite.modules.common.service.CommonSeqService;

/**
 * 序列Controller
 * @author 张雷
 * @version 2018-05-09
 */
@Controller
@RequestMapping(value = "${adminPath}/common/commonSeq")
public class CommonSeqController extends BaseController {

	@Autowired
	private CommonSeqService commonSeqService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public CommonSeq get(String id, boolean isNewRecord) {
		return commonSeqService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("common:commonSeq:view")
	@RequestMapping(value = {"list", ""})
	public String list(CommonSeq commonSeq, Model model) {
		model.addAttribute("commonSeq", commonSeq);
		return "modules/common/commonSeqList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("common:commonSeq:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<CommonSeq> listData(CommonSeq commonSeq, HttpServletRequest request, HttpServletResponse response) {
		Page<CommonSeq> page = commonSeqService.findPage(new Page<CommonSeq>(request, response), commonSeq); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("common:commonSeq:view")
	@RequestMapping(value = "form")
	public String form(CommonSeq commonSeq, Model model) {
		model.addAttribute("commonSeq", commonSeq);
		return "modules/common/commonSeqForm";
	}

	/**
	 * 保存序列
	 */
	@RequiresPermissions("common:commonSeq:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated CommonSeq commonSeq) {
		commonSeqService.save(commonSeq);
		return renderResult(Global.TRUE, "保存序列成功！");
	}
	
	/**
	 * 删除序列
	 */
	@RequiresPermissions("common:commonSeq:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(CommonSeq commonSeq) {
		commonSeqService.delete(commonSeq);
		return renderResult(Global.TRUE, "删除序列成功！");
	}
	
}