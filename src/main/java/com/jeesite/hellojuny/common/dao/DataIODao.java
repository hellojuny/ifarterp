/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.hellojuny.common.dao;

import java.util.List;

import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.hellojuny.common.entity.DateTable;

/**
 * 数据导入导出DAO接口
 * @author 张雷
 * @version 2018-07-16
 */
@MyBatisDao
public interface DataIODao {
	
	public List<DateTable> findAllTables();
}