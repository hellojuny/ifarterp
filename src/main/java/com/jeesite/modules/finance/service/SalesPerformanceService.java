/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.modules.finance.dao.SalesPerformanceDao;
import com.jeesite.modules.finance.entity.SalesPerformance;

/**
 * 材料清单Service
 * @author 张雷
 * @version 2018-05-12
 */
@Service
@Transactional(readOnly=true)
public class SalesPerformanceService {
	
	@Autowired
	protected SalesPerformanceDao salesDao;
	
	/**
	 * 查询数据
	 * @param page 分页对象
	 * @param materialInfo
	 * @return
	 */
	public List<SalesPerformance> find(SalesPerformance salesPerformance) {
		List<SalesPerformance> salesList = salesDao.findList(salesPerformance);
		return salesList;
	}
	
}