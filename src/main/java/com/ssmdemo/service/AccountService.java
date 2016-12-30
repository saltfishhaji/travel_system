package com.ssmdemo.service;

import java.util.List;

import com.ssmdemo.entity.Account;
import com.ssmdemo.entity.Findmymonth;
import com.ssmdemo.entity.Graph;
import com.ssmdemo.entity.PageModel;
import com.ssmdemo.entity.Showaccount;

public interface AccountService {
	public void addAccount(Account account);
	
	public List<Showaccount> findbyid(PageModel<Integer> pageModel);
	
	public List<Showaccount> findAll(PageModel<Integer> pageModel);
	
	public Integer findAllCount(PageModel<Integer> pageModel);
	
	public Integer findMyCount(PageModel<Integer> pageModel);
	
	public List<Graph> findAllmonth(String month);
	
	public List<Graph> findMymonth(Findmymonth f);
}
