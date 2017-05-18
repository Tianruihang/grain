package com.course.supply.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.entity.Supply;
import com.course.meat.service.MeatServiceImpl;
import com.course.entity.Meat;
import com.course.supply.service.SupplyServiceImpl;
import com.framework.Page;

@Controller
@RequestMapping("Supply")

public class SupplyController {
	@Resource
	private SupplyServiceImpl supplyServiceImpl;
	
	@RequestMapping("add")
	public String add(@RequestParam(name="name") String fname,HttpServletRequest request){
		String name = null;
		try {
			name = new String(fname.getBytes("ISO8859_1"),"UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Supply f = new Supply();
		f.setSupplyName(name);
		this.supplyServiceImpl.addSupply(f);
		return "redirect:list";
	}
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public String toEdit(@RequestParam("SupplyId") int supplyId,
			HttpServletRequest request){
		Supply f = this.supplyServiceImpl.getSupply(supplyId);
		request.setAttribute("fru", f);
		request.setAttribute("action", "edit");
		return "Supply/edit";
	}
	@RequestMapping(value="edit",method=RequestMethod.POST)
	public String edit(Supply f,HttpServletRequest request){
		String name = null;
		try {
			name = new String(f.getSupplyName().getBytes("ISO8859_1"),"UTF_8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		f.setSupplyName(name);
		this.supplyServiceImpl.editSupply(f);
		return "redirect:list";
	}
	@RequestMapping("list")
	public String list(@RequestParam(name="pageNum",defaultValue="1")int pageNum,
			@RequestParam(name="searchParam",defaultValue="") String searchParam,HttpServletRequest request,
			Model model){
		Page<Supply> page;
		if (searchParam==null || "".equals(searchParam)) {
			page=this.supplyServiceImpl.listSupply(pageNum, 5,new Object[]{searchParam});
			
		} else {
			try {
				searchParam = new String(searchParam.getBytes("ISO8859_1"),"UTF-8");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			page = this.supplyServiceImpl.listSupply(pageNum, 5, new Object[]{searchParam});
		}
			request.setAttribute("page", page);
			request.setAttribute("searchParam", searchParam);
			return "supply/list";
	
	}

}
