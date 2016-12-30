package com.ssmdemo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssmdemo.dao.ApplyDao;
import com.ssmdemo.entity.Apply;
import com.ssmdemo.entity.PageModel;
import com.ssmdemo.service.ApplyService;

@Service(value = "applyService")
@Transactional
public class ApplyServiceImpl implements ApplyService{
	
	@Autowired
	private ApplyDao applyDao;
	
	public void add(Apply apply)
	{
		applyDao.add(apply);
	};
	
	public Integer findAllCount(PageModel<Integer> pageModel) {
		return applyDao.findAllCount(pageModel);
	}
	
	public Integer findMyCount(PageModel<Integer> pageModel) {
		return applyDao.findMyCount(pageModel);
	}
	
	public Integer findECount(PageModel<Integer> pageModel) {
		return applyDao.findECount(pageModel);
	}
	
	public Integer findBCount(PageModel<Integer> pageModel) {
		return applyDao.findBCount(pageModel);
	}
	
	public Integer findUACount(PageModel<Integer> pageModel) {
		return applyDao.findUACount(pageModel);
	}
	
	public void managercheck(boolean p)
	{
		applyDao.managercheck(p);
	};
	
	public void bosscheck(boolean p)
	{
		applyDao.bosscheck(p);
	};
	
	//@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public Apply findByApplyID(Integer applyid)
	{
		return applyDao.findByApplyID(applyid);
	};
	
	public List<Apply> findAll(PageModel<Integer> t)
	{
		return applyDao.findAll(t);
	};
	
	public List<Apply> findbyid(PageModel<Integer> t)
	{
		return applyDao.findbyid(t);
	};
	
	public List<Apply> findEmployerUncheck(PageModel<Integer> pageModel)
	{
		return applyDao.findEmployerUncheck(pageModel);
	};
	
	public List<Apply> findBossUncheck(PageModel<Integer> pageModel)
	{
		return applyDao.findBossUncheck(pageModel);
	};
	
	public void updateE(Apply apply)
	{
		applyDao.updateE(apply);
	};
	
	public void updateB(Apply apply)
	{
		applyDao.updateB(apply);
	}

	public List<Apply> findunAccount(PageModel<Integer> pageModel) 
	{
		return applyDao.findunAccount(pageModel);
	}
}
