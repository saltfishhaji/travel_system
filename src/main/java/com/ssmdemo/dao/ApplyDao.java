package com.ssmdemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssmdemo.entity.Apply;
import com.ssmdemo.entity.PageModel;

@Repository(value="ApplyDao")
public interface ApplyDao {
	void add(Apply apply);
	
	void managercheck(boolean p);
	
	void bosscheck(boolean p);
	
	Apply findByApplyID(Integer userid);
	
	List<Apply> findAll(PageModel<Integer> t);
	
	public Integer findAllCount(PageModel<Integer> pageModel);
	
	public Integer findMyCount(PageModel<Integer> pageModel);
	
	public Integer findECount(PageModel<Integer> pageModel);
	
	public Integer findBCount(PageModel<Integer> pageModel);
	
	public Integer findUACount(PageModel<Integer> pageModel);
	
	List<Apply> findbyid(PageModel<Integer> t);
	
	List<Apply> findEmployerUncheck(PageModel<Integer> pageModel);
	
	List<Apply> findBossUncheck(PageModel<Integer> pageModel);
	
	List<Apply> findunAccount(PageModel<Integer> pageModel);
	
	void updateE(Apply apply);
	
	void updateB(Apply apply);
}
