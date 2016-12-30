package com.ssmdemo.entity;

import java.util.Date;
import java.sql.Timestamp;

public class Apply {
	Integer applyid;
	Integer userid;
	String username;
	String start;
	String destiny;
	String tovehicle;
	String backvehicle;
	Date startdate;
	Integer days;
	float meal;
	Timestamp applytime;
	Integer hotel;
	float budget;
	float computebudget;
	Integer employercheck;
	Integer bosscheck;
	Integer post;
	
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
	public Integer getPost() {
		return post;
	}
	public void setPost(Integer post) {
		this.post = post;
	}
	public Timestamp getApplytime() {
		return applytime;
	}
	public void setApplytime(Timestamp applytime) {
		this.applytime = applytime;
	}
	public Integer getHotel() {
		return hotel;
	}
	public void setHotel(Integer hotel) {
		this.hotel = hotel;
	}
	public float getBudget() {
		return budget;
	}
	public void setBudget(float budget) {
		this.budget = budget;
	}
	public float getComputebudget() {
		return computebudget;
	}
	public void setComputebudget(float computebudget) {
		this.computebudget = computebudget;
	}
	public Integer getEmployercheck() {
		return employercheck;
	}
	public void setEmployercheck(Integer employercheck) {
		this.employercheck = employercheck;
	}
	public Integer getBosscheck() {
		return bosscheck;
	}
	public void setBosscheck(Integer bosscheck) {
		this.bosscheck = bosscheck;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public float getMeal() {
		return meal;
	}
	public void setMeal(float meal) {
		this.meal = meal;
	}
}