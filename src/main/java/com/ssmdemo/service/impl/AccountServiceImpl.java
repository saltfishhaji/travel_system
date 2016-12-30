package com.ssmdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssmdemo.dao.AccountDao;
import com.ssmdemo.entity.Account;
import com.ssmdemo.entity.Findmymonth;
import com.ssmdemo.entity.Graph;
import com.ssmdemo.entity.PageModel;
import com.ssmdemo.entity.Showaccount;
import com.ssmdemo.service.AccountService;

@Service(value = "accountService")
@Transactional
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountDao accountDao;
	
	public void addAccount(Account account)
	{
		accountDao.addAccount(account);
		accountDao.updateApply(account.getApplyid());
	}
	
	public List<Showaccount> findbyid(PageModel<Integer> pageModel)
	{
		return accountDao.findbyid(pageModel);
	};
	
	public List<Showaccount> findAll(PageModel<Integer> pageModel)
	{
		return accountDao.findAll(pageModel);
	};
	
	public Integer findMyCount(PageModel<Integer> pageModel) {
		return accountDao.findMyCount(pageModel);
	}
	
	public Integer findAllCount(PageModel<Integer> pageModel) {
		return accountDao.findAllCount(pageModel);
	}
	
	
	public List<Graph> findAllmonth(String month)
	{
		System.out.println(month);
		List<Graph> graph=new  ArrayList<Graph>();
		//graph.add(accountDao.findAllmonth(month));
		Integer m=Integer.valueOf(month.substring(5));
		Integer y=Integer.valueOf(month.substring(0,4));
		//System.out.println("m:"+m);
		//System.out.println("y:"+y);
		y--;
		for(int i=0;i<12;++i)
		{
			m++;
			if(m>12)
			{
				m-=12;
				y++;
			}
			String mm=String.valueOf(m);
			if(mm.length()<2)
			{
				mm="0"+mm;
			}
			String temp=String.valueOf(y)+"-"+mm;
			//System.out.println("m-y:"+temp);
			Graph g=accountDao.findAllmonth(temp);
			//g.setMonth(temp);
			graph.add(g);
		}
		return graph;
	};
	
	private String valueof(Integer y) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Graph> findMymonth(Findmymonth f)
	{
		//System.out.println(month);
		List<Graph> graph=new  ArrayList<Graph>();
		//graph.add(accountDao.findAllmonth(month));
		String month=f.getMonth();
		Integer userid=f.getUserid();
		Integer m=Integer.valueOf(month.substring(5));
		Integer y=Integer.valueOf(month.substring(0,4));
		//System.out.println("m:"+m);
		//System.out.println("y:"+y);
		y--;
		for(int i=0;i<12;++i)
		{
			m++;
			if(m>12)
			{
				m-=12;
				y++;
			}
			String mm=String.valueOf(m);
			if(mm.length()<2)
			{
				mm="0"+mm;
			}
			String temp=String.valueOf(y)+"-"+mm;
			//System.out.println("m-y:"+temp);
			Findmymonth a=new Findmymonth();
			a.setMonth(temp);
			a.setUserid(userid);
			Graph g=accountDao.findMymonth(a);
			//g.setMonth(temp);
			graph.add(g);
		}
		return graph;
	};
}
