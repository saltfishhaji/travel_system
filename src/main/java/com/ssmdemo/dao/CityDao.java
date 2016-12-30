package com.ssmdemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssmdemo.entity.City;

import com.ssmdemo.entity.Vehicle;

@Repository(value="CityDao")
public interface CityDao {
	public List<City> getcity();
	
	public List<Vehicle> getvehicle();
}
