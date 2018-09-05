/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.hellojuny.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.hellojuny.common.dao.DataIODao;
import com.jeesite.hellojuny.common.entity.DateTable;

/**
 * 材料清单Service
 * @author 张雷
 * @version 2018-05-12
 */
@Service
@Transactional(readOnly=true)
public class DataIOService {
	
	@Autowired
	protected DataIODao dataIODao;
	
	/**
	 * 查询数据
	 * @param page 分页对象
	 * @param materialInfo
	 * @return
	 */
	public List<DateTable> findAllTables() {
		List<DateTable> tableList = dataIODao.findAllTables();
		return tableList;
	}
	
}