package com.course.login.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.entity.Login;
import com.course.entity.Supply;
import com.course.login.service.LoginServiceImpl;
import com.course.supply.service.SupplyServiceImpl;;
@Controller
@RequestMapping("login")
public class LoginController {
	
	@Resource
	private LoginServiceImpl loginServiceImpl;
	
	@RequestMapping("hello")
	public String login(@RequestParam("username") String name,
			@RequestParam("password") String password, HttpSession session){
		Login lu=this.loginServiceImpl.login(name, password);
		
			if(lu != null){
				String Root = lu.getRoot();
				session.setAttribute("Root",lu.getRoot() );
				if("supply".equals(Root)){
					session.setAttribute("SupplyId", lu.getRoot());
					session.setAttribute("supply", lu);
					session.setAttribute("logined", "on");
					//设置失效时间
					session.setMaxInactiveInterval(8*60*60);
					return "redirect:/";
				} else if("user".equals(Root)){
					session.setAttribute("user", lu);
					session.setMaxInactiveInterval(8*60*60);
					return "网站首页";
				} else {
					System.out.println("lu is not exist");
					return "login";
				}
			} else {
				System.out.println("lu is null");
				return "redirect:/login.jsp";
			}		
	}
}
	

