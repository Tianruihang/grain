package com.course.user.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.entity.User;
import com.course.entity.Vegetable;
import com.course.user.service.UserServiceImpl;
import com.framework.Page;

@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private UserServiceImpl userServiceImpl;
	@RequestMapping("adduser")
	public String add(@RequestParam(name="UserName") String uname,@RequestParam(name="UserNumber") String unumber,HttpServletRequest request){
		String name = null;
		try {
			name = new String(uname.getBytes("ISO8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		User u = new User();
		u.setUserName(uname);
		u.setUserNumber(unumber);
		this.userServiceImpl.addUser(u);
		return "redirect:listuser";
	}
	@RequestMapping(value="deleteuser")
	public String delete(@RequestParam("UserId") int userId,
			HttpServletRequest request){
		this.userServiceImpl.dropUser(userId);
		return "redirect:listuser";
	}
	@RequestMapping(value="edituser",method=RequestMethod.GET )
	public String toEdit(@RequestParam("userId") int userId,
			HttpServletRequest request){
//		System.out.println("get");
		
		User u=this.userServiceImpl.getUser(userId);
//		设置了两个session范围的属性
		request.setAttribute("user",u);
		request.setAttribute("action", "edit");
		return "user/edituser";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	public String edit(User u,HttpServletRequest request){
//		System.out.println("post");
		String name = null;
		try {
			name = new String(u.getUserName().getBytes("ISO8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		u.setUserName(name);
		this.userServiceImpl.editUser(u);
		return "redirect:listuser";
	}
	
	@RequestMapping("listuser")
	public String list(@RequestParam(name="pageNum", defaultValue="1") int pageNum,
			@RequestParam(name="searchParam",defaultValue="") String searchParam,HttpServletRequest request,
			Model model){
		Page<User> page;
		if(searchParam==null || "".equals(searchParam)){
			page=this.userServiceImpl.listUser(pageNum, 5, null);	
		}else{
//			System.out.println("before"+searchParam);
			try {
			 searchParam = new String(searchParam.getBytes("ISO8859_1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
//			System.out.println("after"+searchParam);
			page=this.userServiceImpl.listUser(pageNum, 5, new Object[]{searchParam});
		}
		request.setAttribute("page", page);
		request.setAttribute("searchParam", searchParam);
		return "user/listuser";
		
	}
}
