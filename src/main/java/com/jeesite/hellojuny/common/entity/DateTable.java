/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.hellojuny.common.entity;

import com.jeesite.common.lang.StringUtils;

/**
 * 表格Entity
 * @author 张雷
 * @version 2018-05-12
 */
public class DateTable {
	
	private String tableName;
	
	private String tableComment;
	
	public DateTable() {
		
	}
	
	public DateTable(DateTable dt) {
		tableName = dt.tableName;
		
		if (StringUtils.isBlank(dt.tableComment)) {
			tableComment = dt.tableName;
		} else {
			tableComment = dt.getTableComment();
		}
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	
}