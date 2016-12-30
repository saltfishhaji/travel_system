package com.ssmdemo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssmdemo.entity.City;
import com.ssmdemo.entity.Vehicle;
import com.ssmdemo.service.CityService;


@RequestMapping(value="/city")
@Controller
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "/jumpapply",method = RequestMethod.GET)
	public ModelAndView jumpToLogin(HttpSession session){
		//return "apply";
		List<City> cityList=cityService.getcity();
		List<Vehicle> vehicleList=cityService.getvehicle();
		ModelAndView mv = new ModelAndView();
		mv.addObject("cityList", cityList);
		mv.addObject("vehicleList",vehicleList);
		mv.setViewName("apply");
		return mv;
	}
}
