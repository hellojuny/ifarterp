/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 序列Entity
 * @author 张雷
 * @version 2018-05-09
 */
@Table(name="common_seq", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="number", attrName="number", label="序列"),
		@Column(name="table_name", attrName="tableName", label="表名", queryType=QueryType.LIKE),
	}, orderBy="a.id DESC"
)
public class CommonSeq extends DataEntity<CommonSeq> {
	
	private static final long serialVersionUID = 1L;
	private Integer number;		// 序列
	private String tableName;		// 表名
	
	public CommonSeq() {
		this(null);
	}

	public CommonSeq(String id){
		super(id);
	}
	
	@NotNull(message="序列不能为空")
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	@NotBlank(message="表名不能为空")
	@Length(min=0, max=64, message="表名长度不能超过 64 个字符")
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}