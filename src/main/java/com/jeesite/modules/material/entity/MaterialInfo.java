/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.material.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 材料清单Entity
 * @author 张雷
 * @version 2018-05-12
 */
@Table(name="material_info", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="name", attrName="name", label="材料名称", queryType=QueryType.LIKE),
		@Column(name="category", attrName="category", label="采购类型"),
		@Column(name="type", attrName="type", label="材料类型"),
		@Column(name="classes", attrName="classes", label="材料类别"),
		@Column(name="brand", attrName="brand", label="品牌"),
		@Column(name="nmode", attrName="nmode", label="型号"),
		@Column(name="technique", attrName="technique", label="材质"),
		@Column(name="length", attrName="length", label="长"),
		@Column(name="width", attrName="width", label="宽"),
		@Column(name="height", attrName="height", label="高"),
		@Column(name="face_width", attrName="faceWidth", label="框面宽"),
		@Column(name="groove_deep", attrName="grooveDeep", label="槽深"),
		@Column(name="eaves_width", attrName="eavesWidth", label="檐宽"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class MaterialInfo extends DataEntity<MaterialInfo> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 材料名称
	private String category;		// 采购类型
	private String type;		// 材料类型
	private String classes;		// 材料类别
	private String brand;		// 品牌
	private String nmode;		// 型号
	private String technique;		// 材质
	private Double length;		// 长
	private Double width;		// 宽
	private Double height;		// 高
	private Double faceWidth;		// 框面宽
	private Double grooveDeep;		// 槽深
	private Double eavesWidth;		// 檐宽
	
	public MaterialInfo() {
		this(null);
	}

	public MaterialInfo(String id){
		super(id);
	}
	
	@NotBlank(message="材料名称不能为空")
	@Length(min=0, max=200, message="材料名称长度不能超过 200 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank(message="采购类型不能为空")
	@Length(min=0, max=100, message="采购类型长度不能超过 100 个字符")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@NotBlank(message="材料类型不能为空")
	@Length(min=0, max=100, message="材料类型长度不能超过 100 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@NotBlank(message="材料类别不能为空")
	@Length(min=0, max=100, message="材料类别长度不能超过 100 个字符")
	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}
	
	@Length(min=0, max=200, message="品牌长度不能超过 200 个字符")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Length(min=0, max=200, message="型号长度不能超过 200 个字符")
	public String getNmode() {
		return nmode;
	}

	public void setNmode(String nmode) {
		this.nmode = nmode;
	}
	
	@Length(min=0, max=200, message="材质长度不能超过 200 个字符")
	public String getTechnique() {
		return technique;
	}

	public void setTechnique(String technique) {
		this.technique = technique;
	}
	
	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}
	
	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}
	
	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	
	public Double getFaceWidth() {
		return faceWidth;
	}

	public void setFaceWidth(Double faceWidth) {
		this.faceWidth = faceWidth;
	}
	
	public Double getGrooveDeep() {
		return grooveDeep;
	}

	public void setGrooveDeep(Double grooveDeep) {
		this.grooveDeep = grooveDeep;
	}
	
	public Double getEavesWidth() {
		return eavesWidth;
	}

	public void setEavesWidth(Double eavesWidth) {
		this.eavesWidth = eavesWidth;
	}
	
}