package com.ssmdemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssmdemo.entity.Account;
import com.ssmdemo.entity.Graph;
import com.ssmdemo.entity.PageModel;
import com.ssmdemo.entity.Showaccount;
import com.ssmdemo.entity.Findmymonth;

@Repository(value="AccountDao")
public interface AccountDao {
	public void addAccount(Account account);
	
	public void updateApply(Integer applyid);
	
	public List<Showaccount> findbyid(PageModel<Integer>pageModel);
	
	public List<Showaccount> findAll(PageModel<Integer>pageModel);
	
	public Integer findAllCount(PageModel<Integer> pageModel);
	
	public Integer findMyCount(PageModel<Integer> pageModel);
	
	public Graph findAllmonth(String month);
	
	public Graph findMymonth(Findmymonth f);
}
