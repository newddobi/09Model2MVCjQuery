package com.model2.mvc.service.domain;

import java.sql.Date;

public class Review {
	
	private int reviewNo;
	private int prodNo;
	private String prodName;
	private String userId;
	private String title;
	private String content;
	private Date reviewDate;
	
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", prodNo=" + prodNo + ", prodName=" + prodName + ", userId=" + userId
				+ ", title=" + title + ", content=" + content + ", reviewDate=" + reviewDate + "]";
	}
	
	
}
