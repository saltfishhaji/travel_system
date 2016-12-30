package com.ssmdemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssmdemo.entity.Hotel;

import com.ssmdemo.entity.Ticket;

@Repository(value="HotelDao")
public interface HotelDao {
	public float gethotel(Integer hotel);
	
	public float getprice(Ticket ticket);
}
