/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.material.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeesite.modules.sys.entity.User;
import javax.validation.constraints.NotNull;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 采购需求单Entity
 * @author 张雷
 * @version 2018-05-13
 */
@Table(name="material_requirements", alias="a", columns={
		@Column(name="id", attrName="id", label="需求单号", isPK=true),
		@Column(name="purchase_type", attrName="purchaseType", label="采购类型"),
		@Column(name="complete_date", attrName="completeDate", label="交货日期"),
		@Column(name="contract", attrName="contract", label="工单号"),
		@Column(name="cutomer", attrName="cutomer", label="客户名称"),
		@Column(name="applicant", attrName="applicant.userCode", label="申请人"),
		@Column(name="application_date", attrName="applicationDate", label="申请日期"),
		@Column(name="reviewer", attrName="reviewer.userCode", label="审批人"),
		@Column(name="review_date", attrName="reviewDate", label="审批日期"),
		@Column(name="review_status", attrName="reviewStatus", label="审核状态"),
		@Column(name="purchase_status", attrName="purchaseStatus", label="采购进度"),
		@Column(includeEntity=DataEntity.class),
	}, joinTable={
		@JoinTable(type=Type.LEFT_JOIN, entity=User.class, attrName="applicant", alias="u6",
			on="u6.user_code = a.applicant", columns={
				@Column(name="user_code", label="用户编码", isPK=true),
				@Column(name="user_name", label="用户名称", isQuery=false),
		}),
		@JoinTable(type=Type.LEFT_JOIN, entity=User.class, attrName="reviewer", alias="u8",
			on="u8.user_code = a.reviewer", columns={
				@Column(name="user_code", label="用户编码", isPK=true),
				@Column(name="user_name", label="用户名称", isQuery=false),
		}),
	}, orderBy="a.update_date DESC"
)
public class MaterialRequirements extends DataEntity<MaterialRequirements> {
	
	private static final long serialVersionUID = 1L;
	private String purchaseType;		// 采购类型
	private Date completeDate;		// 交货日期
	private String contract;		// 工单号
	private String cutomer;		// 客户名称
	private User applicant;		// 申请人
	private Date applicationDate;		// 申请日期
	private User reviewer;		// 审批人
	private Date reviewDate;		// 审批日期
	private String reviewStatus;		// 审核状态
	private String purchaseStatus;		// 采购进度
	private List<MaterialChild> materialChildList = ListUtils.newArrayList();		// 子表列表
	
	public MaterialRequirements() {
		this(null);
	}

	public MaterialRequirements(String id){
		super(id);
	}
	
	@Length(min=0, max=100, message="采购类型长度不能超过 100 个字符")
	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}
	
	@Length(min=0, max=100, message="工单号长度不能超过 100 个字符")
	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}
	
	@Length(min=0, max=100, message="客户名称长度不能超过 100 个字符")
	public String getCutomer() {
		return cutomer;
	}

	public void setCutomer(String cutomer) {
		this.cutomer = cutomer;
	}
	
	@NotNull(message="申请人不能为空")
	public User getApplicant() {
		return applicant;
	}

	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="申请日期不能为空")
	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	
	public User getReviewer() {
		return reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	@Length(min=0, max=1, message="审核状态长度不能超过 1 个字符")
	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	
	@Length(min=0, max=64, message="采购进度长度不能超过 64 个字符")
	public String getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	
	public Date getApplicationDate_gte() {
		return sqlMap.getWhere().getValue("application_date", QueryType.GTE);
	}

	public void setApplicationDate_gte(Date applicationDate) {
		sqlMap.getWhere().and("application_date", QueryType.GTE, applicationDate);
	}
	
	public Date getApplicationDate_lte() {
		return sqlMap.getWhere().getValue("application_date", QueryType.LTE);
	}

	public void setApplicationDate_lte(Date applicationDate) {
		sqlMap.getWhere().and("application_date", QueryType.LTE, applicationDate);
	}
	
	public Date getReviewDate_gte() {
		return sqlMap.getWhere().getValue("review_date", QueryType.GTE);
	}

	public void setReviewDate_gte(Date reviewDate) {
		sqlMap.getWhere().and("review_date", QueryType.GTE, reviewDate);
	}
	
	public Date getReviewDate_lte() {
		return sqlMap.getWhere().getValue("review_date", QueryType.LTE);
	}

	public void setReviewDate_lte(Date reviewDate) {
		sqlMap.getWhere().and("review_date", QueryType.LTE, reviewDate);
	}
	
	public List<MaterialChild> getMaterialChildList() {
		return materialChildList;
	}

	public void setMaterialChildList(List<MaterialChild> materialChildList) {
		this.materialChildList = materialChildList;
	}
	
}