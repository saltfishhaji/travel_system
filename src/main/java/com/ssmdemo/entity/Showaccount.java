package com.ssmdemo.entity;

import java.util.Date;
/*
select apply.applyid,apply.userid,apply.username,apply.post,apply.start,apply.destiny,
apply.tovehicle,apply.backvehicle,apply.startdate,account.days,account.extrapay,account.totalbudget,
account.computebudget,account.savings,account.adminmsg

 */


public class Showaccount {
	private Integer applyid;
	private Integer userid;
	private String username;
	private Integer post;
	private String start;
	private String destiny;
	private String tovehicle;
	private String backvehicle;
	private Date startdate;
	private Integer days;
	private float extrapay;
	private float totalbudget;
	private float budget;
	private float savings;
	private String adminmsg;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getPost() {
		return post;
	}
	public void setPost(Integer post) {
		this.post = post;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDestiny() {
		return destiny;
	}
	public void setDestiny(String destiny) {
		this.destiny = destiny;
	}
	public String getTovehicle() {
		return tovehicle;
	}
	public void setTovehicle(String tovehicle) {
		this.tovehicle = tovehicle;
	}
	public String getBackvehicle() {
		return backvehicle;
	}
	public void setBackvehicle(String backvehicle) {
		this.backvehicle = backvehicle;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
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
	public float getSavings() {
		return savings;
	}
	public void setSavings(float savings) {
		this.savings = savings;
	}
	public String getAdminmsg() {
		return adminmsg;
	}
	public void setAdminmsg(String adminmsg) {
		this.adminmsg = adminmsg;
	}

	
}
