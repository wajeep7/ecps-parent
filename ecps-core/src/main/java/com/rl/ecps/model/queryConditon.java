package com.rl.ecps.model;

public class queryConditon {
	private String itemName;
	private Long brandId;
	private Short auditStatus;
	private Short showStatus;
	private Integer pageNo;
	private Integer pageSize;
	private Integer startNum;
	private Integer endNum;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Short getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String ad) {
		this.auditStatus = Short.valueOf(ad);
	}

	public Short getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(Short showStatus) {
		this.showStatus = showStatus;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getEndNum() {
		return endNum;
	}

	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}

}
