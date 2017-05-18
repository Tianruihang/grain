package com.course.user.dao;

import org.springframework.stereotype.Repository;

import com.course.entity.User;
import com.framework.BaseDao;
import com.framework.Page;

@Repository
public class UserDaoImpl extends BaseDao<User, String> {
	public void saveUser(User u){
		try {
			this.save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Page<User> findUser(int pageNum, int pageSize,Object[] params){
		String hql;
		if(params!=null && params.length>0){
			hql="from User u where u.uname like ?";
			params[0]="%"+params[0]+"%";
			
		}else{
			hql="from User";
		}
		try {
			Page<User> page=new Page<User>();
			page.setCurrentPageNum(pageNum);
			page.setPageSize(pageSize);
			page=this.findByPage(pageNum, pageSize, hql, params);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public User getUser(int userId){
		try {
			User u=this.get(userId);
			return u;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void updateUser(User u){
		try {
			this.update(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId){
		try {
			this.delete(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
