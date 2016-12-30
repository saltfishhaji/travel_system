package com.ssmdemo.entity;

import java.util.Date;

public class Account {
	/*  applyid              int not null,
	   userid               int not null,
	   post                 int not null, 
	   days                 int not null,
	   extrapay             float(8,2),
	   totalbudget          float(8,2) not null,
	   computebudget        float(8,2) not null,
	   hotelpay             float(8,2) not null,
	   ticketpay            float(8,2) not null,
	   mealpay              float(8,2) not null,
	   adminmsg             char(140) not null,
	   savings		float not null,
	*/
	private Integer applyid;
	private Integer userid;
	private String username;
	private Integer post;
	private Date startdate;
	private Integer days;
	private float extrapay;
	private float totalbudget;
	private float budget;
	private float hotelpay;
	private float ticketpay;
	private float mealpay;
	private String adminmsg;
	private float savings;
	
	
	
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getApplyid() {
		return applyid;
	}
	public void setApplyid(Integer applyid) {
		this.applyid = applyid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getPost() {
		return post;
	}
	public void setPost(Integer post) {
		this.post = post;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public float getExtrapay() {
		return extrapay;
	}
	public void setExtrapay(float extrapay) {
		this.extrapay = extrapay;
	}
	public float getTotalbudget() {
		return totalbudget;
	}
	public void setTotalbudget(float totalbudget) {
		this.totalbudget = totalbudget;
	}
	public float getBudget() {
		return budget;
	}
	public void setBudget(float budget) {
		this.budget = budget;
	}
	public float getHotelpay() {
		return hotelpay;
	}
	public void setHotelpay(float hotelpay) {
		this.hotelpay = hotelpay;
	}
	public float getTicketpay() {
		return ticketpay;
	}
	public void setTicketpay(float ticketpay) {
		this.ticketpay = ticketpay;
	}
	public float getMealpay() {
		return mealpay;
	}
	public void setMealpay(float mealpay) {
		this.mealpay = mealpay;
	}
	public String getAdminmsg() {
		return adminmsg;
	}
	public void setAdminmsg(String adminmsg) {
		this.adminmsg = adminmsg;
	}
	public float getSavings() {
		return savings;
	}
	public void setSavings(float savings) {
		this.savings = savings;
	}
}
