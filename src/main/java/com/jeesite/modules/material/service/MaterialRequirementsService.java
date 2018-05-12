/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.material.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.lang.DateUtils;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.dao.CommonSeqDao;
import com.jeesite.modules.common.utils.SeqUtils;
import com.jeesite.modules.material.dao.MaterialChildDao;
import com.jeesite.modules.material.dao.MaterialRequirementsDao;
import com.jeesite.modules.material.entity.MaterialChild;
import com.jeesite.modules.material.entity.MaterialRequirements;

/**
 * 采购需求单Service
 * @author 张雷
 * @version 2018-05-09
 */
@Service
@Transactional(readOnly=true)
public class MaterialRequirementsService extends CrudService<MaterialRequirementsDao, MaterialRequirements> {
	
	@Autowired
	private CommonSeqDao commonSeqDao;
	
	@Autowired
	private MaterialChildDao materialChildDao;
	
	/**
	 * 获取单条数据
	 * @param materialRequirements
	 * @return
	 */
	@Override
	public MaterialRequirements get(MaterialRequirements materialRequirements) {
		MaterialRequirements entity = super.get(materialRequirements);
		if (entity != null){
			MaterialChild materialChild = new MaterialChild(entity);
			materialChild.setStatus(MaterialChild.STATUS_NORMAL);
			entity.setMaterialChildList(materialChildDao.findList(materialChild));
		}
		return entity;
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param materialRequirements
	 * @return
	 */
	@Override
	public Page<MaterialRequirements> findPage(Page<MaterialRequirements> page, MaterialRequirements materialRequirements) {
		return super.findPage(page, materialRequirements);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param materialRequirements
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MaterialRequirements materialRequirements) {
		if (materialRequirements.getIsNewRecord()) {
			int seqNumber = SeqUtils.getNumber("material_requirements");
			String no = "A" + DateUtils.getDate("yyMMdd") + seqNumber;
			materialRequirements.setNo(no);
		}
		super.save(materialRequirements);
		// 保存 MaterialRequirements子表
		for (MaterialChild materialChild : materialRequirements.getMaterialChildList()){
			if (!MaterialChild.STATUS_DELETE.equals(materialChild.getStatus())){
				materialChild.setMaterialRequirements(materialRequirements);
				if (materialChild.getIsNewRecord()){
					materialChild.preInsert();
					materialChildDao.insert(materialChild);
				}else{
					materialChild.preUpdate();
					materialChildDao.update(materialChild);
				}
			}else{
				materialChildDao.delete(materialChild);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param materialRequirements
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MaterialRequirements materialRequirements) {
		super.updateStatus(materialRequirements);
	}
	
	/**
	 * 删除数据
	 * @param materialRequirements
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MaterialRequirements materialRequirements) {
		super.delete(materialRequirements);
		MaterialChild materialChild = new MaterialChild();
		materialChild.setMaterialRequirements(materialRequirements);
		materialChildDao.delete(materialChild);
	}
	
}