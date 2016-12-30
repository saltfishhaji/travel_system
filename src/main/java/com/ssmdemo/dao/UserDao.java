package com.ssmdemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssmdemo.entity.PageModel;
import com.ssmdemo.entity.User;

@Repository(value="userDao")
public interface UserDao {
	 /**
     * �˷�����Ӧ�����ݿ��еı� ,user
     * ��д�����ݿ��¼
     *
     * @param record
     */
	Integer add(User user);
	 /**
     * �˷�����Ӧ�����ݿ��еı� ,user
     * �������������·������������ݿ��¼
     *
     * @param record
     */
	void update(User user);
	 /**
     * �˷�����Ӧ�����ݿ��еı� ,user
     * ��������ɾ�����ݿ�ļ�¼
     *
     * @param id
     */
	//void check(User user);
	 /**
     * �˷�����Ӧ�����ݿ��еı� ,user
     * ��������ɾ�����ݿ�ļ�¼
     *
     * @param id
     */
	void delete(Integer userid);
	
	 /**
     * �˷�����Ӧ�����ݿ��еı� ,user
     * ����ָ��������ȡһ�����ݿ��¼
     *
     * @param id
     */
	User findByUserID(Integer userid);
	/**
     * �˷�����Ӧ�����ݿ��еı� ,user
     * ��ѯ�������ݿ��¼
     */
	List<User> findAll();
	
	public Integer findCount(PageModel<Integer> pageModel);
	
    void check(Integer userid);
	
	void checkdeny(Integer userid);
	
	List<User> findUnchecked(PageModel<Integer> t);
}
