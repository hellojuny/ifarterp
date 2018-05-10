/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.material.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.material.entity.MaterialInfo;
import com.jeesite.modules.material.dao.MaterialInfoDao;

/**
 * 材料清单Service
 * @author 张雷
 * @version 2018-05-09
 */
@Service
@Transactional(readOnly=true)
public class MaterialInfoService extends CrudService<MaterialInfoDao, MaterialInfo> {
	
	/**
	 * 获取单条数据
	 * @param materialInfo
	 * @return
	 */
	@Override
	public MaterialInfo get(MaterialInfo materialInfo) {
		return super.get(materialInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param materialInfo
	 * @return
	 */
	@Override
	public Page<MaterialInfo> findPage(Page<MaterialInfo> page, MaterialInfo materialInfo) {
		return super.findPage(page, materialInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param materialInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MaterialInfo materialInfo) {
		super.save(materialInfo);
	}
	
	/**
	 * 更新状态
	 * @param materialInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MaterialInfo materialInfo) {
		super.updateStatus(materialInfo);
	}
	
	/**
	 * 删除数据
	 * @param materialInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MaterialInfo materialInfo) {
		super.delete(materialInfo);
	}
	
}