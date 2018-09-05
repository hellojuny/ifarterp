/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.finance.dao;

import java.util.List;

import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.finance.entity.SalesPerformance;

/**
 * 销售业绩DAO接口
 * @author 张雷
 * @version 2018-05-12
 */
@MyBatisDao(dataSourceName="ds2")
public interface SalesPerformanceDao {
	
	public List<SalesPerformance> findList(SalesPerformance salesPerformance);
}