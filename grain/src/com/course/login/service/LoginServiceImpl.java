package com.course.login.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.course.entity.Login;
import com.course.login.dao.LoginDaoImpl;

@Service
@Transactional(readOnly=true)
public class LoginServiceImpl {
	
	@Resource
	private LoginDaoImpl loginDaoImpl;
	
	@Transactional(readOnly=false)
	public void regist(){
		//insert user
		
		int a=10/0;
		
		//update score
		
	}

	public Login login(String name,String pwd){
		return this.loginDaoImpl.findByNamdAndPwd(name, pwd);
	}
	
	
}
