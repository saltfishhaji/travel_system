package com.ssmdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssmdemo.dao.CityDao;
import com.ssmdemo.entity.City;
import com.ssmdemo.entity.Vehicle;
import com.ssmdemo.service.CityService;

@Service(value = "cityService")
@Transactional
public class CityServiceImpl implements CityService{
	@Autowired
	private CityDao cityDao;
	
	public List<City> getcity()
	{
		return cityDao.getcity();
	};
	
	public List<Vehicle> getvehicle()
	{
		return cityDao.getvehicle();
	};
}
