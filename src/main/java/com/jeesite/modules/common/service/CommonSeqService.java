/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.common.entity.CommonSeq;
import com.jeesite.modules.test.dao.TestDataChildDao;
import com.jeesite.modules.common.dao.CommonSeqDao;

/**
 * 序列Service
 * @author 张雷
 * @version 2018-05-09
 */
@Service
@Transactional(readOnly=true)
public class CommonSeqService extends CrudService<CommonSeqDao, CommonSeq> {
	
	@Autowired
	private CommonSeqDao commonSeqDao;
	
	/**
	 * 获取序列
	 * @param tableName
	 * @return
	 */
	public Integer getSeq(String tableName) {
		CommonSeq seq = new CommonSeq();
		seq.setTableName(tableName);
		commonSeqDao.get(seq);
		//seq = this.get(seq);
		
		if (null == seq) {
			return -1;
		} else {
			int number = seq.getNumber();
			seq.setNumber(number + 1);
			//this.update(seq);
			return number;
		}
	}
	
	/**
	 * 获取单条数据
	 * @param commonSeq
	 * @return
	 */
	@Override
	public CommonSeq get(CommonSeq commonSeq) {
		return super.get(commonSeq);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param commonSeq
	 * @return
	 */
	@Override
	public Page<CommonSeq> findPage(Page<CommonSeq> page, CommonSeq commonSeq) {
		return super.findPage(page, commonSeq);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param commonSeq
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CommonSeq commonSeq) {
		super.save(commonSeq);
	}
	
	/**
	 * 更新状态
	 * @param commonSeq
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(CommonSeq commonSeq) {
		super.updateStatus(commonSeq);
	}
	
	/**
	 * 删除数据
	 * @param commonSeq
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(CommonSeq commonSeq) {
		super.delete(commonSeq);
	}
	
}