/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.entity;

import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 序列Entity
 * @author 张雷
 * @version 2018-05-12
 */
@Table(name="common_seq", alias="a", columns={
		@Column(name="table_name", attrName="tableName", label="表名", isPK=true),
		@Column(name="number", attrName="number", label="序列"),
	}, orderBy="a.table_name DESC"
)
public class CommonSeq extends DataEntity<CommonSeq> {
	
	private static final long serialVersionUID = 1L;
	private String tableName;		// 表名
	private Integer number;		// 序列
	
	public CommonSeq() {
		this(null);
	}

	public CommonSeq(String id){
		super(id);
	}
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	@NotNull(message="序列不能为空")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
}