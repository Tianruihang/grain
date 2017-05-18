package com.course.collect.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.collect.service.CollectServiceImpl;
import com.course.entity.Collect;
import com.framework.Page;


@Controller
@RequestMapping("collect")
public class CollectController {
	@Resource
	private CollectServiceImpl collectServiceImpl;
	
	@RequestMapping("add")
	public String add(@RequestParam(name="UserId") Integer cuserid,@RequestParam(name="FruitId") Integer cfruitid,@RequestParam(name="MeatId") Integer cmeatid,@RequestParam(name="FishId") Integer cfishid,@RequestParam(name="VegetableId") Integer cvegetableid,HttpServletRequest request){
		
		Collect p = new Collect();
		p.setUserId(cuserid);
		p.setFruitId(cfruitid);
		p.setMeatId(cmeatid);
		p.setFishId(cfishid);
		p.setVegetableId(cvegetableid);
		this.collectServiceImpl.addCollect(p);
		return "redirect:list";
	}
	
	@RequestMapping(value="delete")
	public String delete(@RequestParam("CollectId") int CollectId,
			HttpServletRequest request){
		this.collectServiceImpl.dropCollect(CollectId);
		return "redirect:list";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.GET )
	public String toEdit(@RequestParam("CollectId") int CollectId,
			HttpServletRequest request){
//		System.out.println("get");
		
		Collect p=this.collectServiceImpl.getCollect(CollectId);
//		设置了两个session范围的属性
		request.setAttribute("pro", p);
		request.setAttribute("action", "edit");
		return "collect/edit";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	public String edit(Collect p,@RequestParam("CollectId") int CollectId,HttpServletRequest request){
//		System.out.println("post");
			
		p.setCollectId(CollectId);
		this.collectServiceImpl.editCollect(p);
		return "redirect:list";
	}
	
	@RequestMapping("list")
	public String list(@RequestParam(name="pageNum", defaultValue="1") int pageNum,
			@RequestParam(name="searchParam",defaultValue="") String searchParam,HttpServletRequest request,
			Model model){
		Page<Collect> page;
		if(searchParam==null || "".equals(searchParam)){
			page=this.collectServiceImpl.listCollect(pageNum, 5, null);	
		}else{
//			System.out.println("before"+searchParam);
			try {
			 searchParam = new String(searchParam.getBytes("ISO8859_1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
//			System.out.println("after"+searchParam);
			page=this.collectServiceImpl.listCollect(pageNum, 5, new Object[]{searchParam});
		}
		request.setAttribute("page", page);
		request.setAttribute("searchParam", searchParam);
		return "collect/list";
		
	}
}
