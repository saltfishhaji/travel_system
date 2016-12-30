package com.ssmdemo.service;

import java.util.List;

import com.ssmdemo.entity.Apply;
import com.ssmdemo.entity.PageModel;

public interface ApplyService {
	public void add(Apply a);
	
	public void managercheck(boolean p);
	
	public void bosscheck(boolean p);
	
	public Apply findByApplyID(Integer temp);
	
	public List<Apply> findAll(PageModel<Integer> t);
	
	public Integer findAllCount(PageModel<Integer> pageModel);
	
	public Integer findMyCount(PageModel<Integer> pageModel);
	
	public Integer findECount(PageModel<Integer> pageModel);
	
	public Integer findBCount(PageModel<Integer> pageModel);
	
	public Integer findUACount(PageModel<Integer> pageModel);
	
	public List<Apply> findbyid(PageModel<Integer> t);
	
	public List<Apply> findEmployerUncheck(PageModel<Integer> pageModel);
	
	public List<Apply> findBossUncheck(PageModel<Integer> pageModel);
	
	public List<Apply> findunAccount(PageModel<Integer> pageModel);
	
	public void updateE(Apply apply);
	
	public void updateB(Apply apply);
}
