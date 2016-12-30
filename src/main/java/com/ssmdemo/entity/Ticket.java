package com.ssmdemo.entity;

public class Ticket {
	private String fromcity;
	private String tocity;
	private String vehicle;
	
	private float price;

	public String getFromcity() {
		return fromcity;
	}

	public void setFromcity(String fromcity) {
		this.fromcity = fromcity;
	}

	public String getTocity() {
		return tocity;
	}

	public void setTocity(String tocity) {
		this.tocity = tocity;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
