package com.ssmdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssmdemo.dao.HotelDao;
import com.ssmdemo.entity.Hotel;
import com.ssmdemo.entity.Ticket;
import com.ssmdemo.service.HotelService;

@Service(value = "hotelService")
@Transactional
public class HotelServiceImpl implements HotelService{
	@Autowired
	private HotelDao hotelDao;
	
	public float gethotel(Integer hotel)
	{
		return hotelDao.gethotel(hotel);
	}
	
	public float getprice(Ticket ticket)
	{
		return hotelDao.getprice(ticket);
	}
}
