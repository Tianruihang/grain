package com.course.fish.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.entity.Fish;
import com.course.fish.service.FishServiceImpl;
import com.framework.Page;

@Controller
@RequestMapping("Fish")
public class FishController {
	
	@Resource
	private FishServiceImpl fishServiceImpl;
	
	@RequestMapping("add")
	public String add(@RequestParam(name="name") String fname,@RequestParam(name=("price"))float fprice,HttpServletRequest request){
		String name = null;
		try {
			name = new String(fname.getBytes("ISO8859_1"),"UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Fish f = new Fish();
		f.setFishName(name);
		f.setFishPrice(fprice);
		this.fishServiceImpl.addFish(f);
		return "redirect:list";
	}
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public String toEdit(@RequestParam("FishId") int fishId,
			HttpServletRequest request){
		Fish f = this.fishServiceImpl.getFish(fishId);
		request.setAttribute("fru", f);
		request.setAttribute("action", "edit");
		return "fish/edit";
	}
	@RequestMapping(value="edit",method=RequestMethod.POST)
	public String edit(Fish f,HttpServletRequest request){
		String name = null;
		try {
			name = new String(f.getFishName().getBytes("ISO8859_1"),"UTF_8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		f.setFishName(name);
		this.fishServiceImpl.editFish(f);
		return "redirect:list";
	}
	@RequestMapping("list")
	public String list(@RequestParam(name="pageNum",defaultValue="1")int pageNum,
			@RequestParam(name="searchParam",defaultValue="") String searchParam,HttpServletRequest request,
			Model model){
		Page<Fish> page;
		if (searchParam==null || "".equals(searchParam)) {
			page=this.fishServiceImpl.listFish(pageNum, 5,new Object[]{searchParam});
			
		} else {
			try {
				searchParam = new String(searchParam.getBytes("ISO8859_1"),"UTF-8");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			page = this.fishServiceImpl.listFish(pageNum, 5, new Object[]{searchParam});
		}
			request.setAttribute("page", page);
			request.setAttribute("searchParam", searchParam);
			return "fish/list";
	
	}
}
