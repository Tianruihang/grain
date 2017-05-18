package com.course.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.User;
import com.course.user.dao.UserDaoImpl;
import com.framework.Page;

@Service
@Transactional(readOnly=false)
public class UserServiceImpl {
	@Resource
	private UserDaoImpl userDaoImpl;

	public void addUser(User u) {
		// TODO Auto-generated method stub
		this.userDaoImpl.saveUser(u);
		
	}

	public void dropUser(int userId) {
		// TODO Auto-generated method stub
		this.userDaoImpl.deleteUser(userId);
	}
	@Transactional(readOnly=true)
	public Page<User> listUser(int pageNum,int pageSize,Object[] params){
		return this.userDaoImpl.findUser(pageNum, pageSize, params);
	}
	
	@Transactional(readOnly=true)
	public User getUser(int userId){
		return this.userDaoImpl.getUser(userId);
	}
	
	public void editUser(User u){
//		System.out.println(p.getProductId());
//		System.out.println(p.getName());
//		System.out.println(p.getPrice());
		User user=this.userDaoImpl.getUser(u.getUserId());
		user.setUserName(u.getUserName());
		user.setUserNumber(u.getUserNumber());
		this.userDaoImpl.updateUser(user);
	}
	
	

}
