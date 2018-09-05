/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.finance.entity;

/**
 * 序列Entity
 * @author 张雷
 * @version 2018-05-12
 */
public class SalesPerformance {
	
	private String yearMonth;		// 年月
	private String yearMonthStart;	// 年月(start)
	private String yearMonthEnd;	// 年月(end)
	private Double copyTotals;		// 复制金额
	private Double mountTotals;		// 复制金额
	private Double frameTotals;		// 复制金额
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public Double getCopyTotals() {
		return copyTotals;
	}
	public void setCopyTotals(Double copyTotals) {
		this.copyTotals = copyTotals;
	}
	public Double getMountTotals() {
		return mountTotals;
	}
	public void setMountTotals(Double mountTotals) {
		this.mountTotals = mountTotals;
	}
	public Double getFrameTotals() {
		return frameTotals;
	}
	public void setFrameTotals(Double frameTotals) {
		this.frameTotals = frameTotals;
	}
	public String getYearMonthStart() {
		return yearMonthStart;
	}
	public void setYearMonthStart(String yearMonthStart) {
		this.yearMonthStart = yearMonthStart;
	}
	public String getYearMonthEnd() {
		return yearMonthEnd;
	}
	public void setYearMonthEnd(String yearMonthEnd) {
		this.yearMonthEnd = yearMonthEnd;
	}
	
}