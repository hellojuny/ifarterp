/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.material.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 采购需求单Entity
 * @author 张雷
 * @version 2018-05-13
 */
@Table(name="material_child", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="mid", attrName="mid", label="编号"),
		@Column(name="fid", attrName="materialRequirements.id", label="父表主键"),
		@Column(name="name", attrName="name", label="材料名称", queryType=QueryType.LIKE),
		@Column(name="category", attrName="category", label="采购类型"),
		@Column(name="type", attrName="type", label="材料类型"),
		@Column(name="classes", attrName="classes", label="材料类别"),
		@Column(name="size", attrName="size", label="规格"),
		@Column(name="number", attrName="number", label="数量"),
		@Column(name="unit", attrName="unit", label="单位"),
		@Column(name="remark", attrName="remark", label="备注"),
	}, orderBy="a.id ASC"
)
public class MaterialChild extends DataEntity<MaterialChild> {
	
	private static final long serialVersionUID = 1L;
	private String mid;		// 编号
	private MaterialRequirements materialRequirements;		// 父表主键 父类
	private String name;		// 材料名称
	private String category;		// 采购类型
	private String type;		// 材料类型
	private String classes;		// 材料类别
	private String size;		// 规格
	private Double number;		// 数量
	private String unit;		// 单位
	private String remark;		// 备注
	
	public MaterialChild() {
		this(null);
	}


	public MaterialChild(MaterialRequirements materialRequirements){
		this.materialRequirements = materialRequirements;
	}
	
	@Length(min=0, max=100, message="编号长度不能超过 100 个字符")
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	
	@Length(min=0, max=64, message="父表主键长度不能超过 64 个字符")
	public MaterialRequirements getMaterialRequirements() {
		return materialRequirements;
	}

	public void setMaterialRequirements(MaterialRequirements materialRequirements) {
		this.materialRequirements = materialRequirements;
	}
	
	@Length(min=0, max=200, message="材料名称长度不能超过 200 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=100, message="采购类型长度不能超过 100 个字符")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Length(min=0, max=100, message="材料类型长度不能超过 100 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=100, message="材料类别长度不能超过 100 个字符")
	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}
	
	@Length(min=0, max=100, message="规格长度不能超过 100 个字符")
	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}
	
	@Length(min=0, max=100, message="单位长度不能超过 100 个字符")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Length(min=0, max=255, message="备注长度不能超过 255个字符")
	public String getRemark() {
		return remark;
	}

	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}