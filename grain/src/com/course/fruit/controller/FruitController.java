package com.course.fruit.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.entity.Fruit;
import com.course.fruit.service.FruitServiceImpl;
import com.framework.Page;

@Controller
@RequestMapping("Fruit")
public class FruitController {
	
	@Resource
	private FruitServiceImpl fruitServiceImpl;
	
	@RequestMapping("add")
	public String add(@RequestParam(name="name") String fname,@RequestParam(name=("price"))float fprice,HttpServletRequest request){
		String name = null;
		try {
			name = new String(fname.getBytes("ISO8859_1"),"UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Fruit f = new Fruit();
		f.setFruitName(name);
		f.setFruitPrice(fprice);
		this.fruitServiceImpl.addFruit(f);
		return "redirect:list";
	}
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public String toEdit(@RequestParam("FruitId") int fruitId,
			HttpServletRequest request){
		Fruit f = this.fruitServiceImpl.getFruit(fruitId);
		request.setAttribute("fru", f);
		request.setAttribute("action", "edit");
		return "fruit/edit";
	}
	@RequestMapping(value="edit",method=RequestMethod.POST)
	public String edit(Fruit f,HttpServletRequest request){
		String name = null;
		try {
			name = new String(f.getFruitName().getBytes("ISO8859_1"),"UTF_8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		f.setFruitName(name);
		this.fruitServiceImpl.editFruit(f);
		return "redirect:list";
	}
	@RequestMapping("list")
	public String list(@RequestParam(name="pageNum",defaultValue="1")int pageNum,
			@RequestParam(name="searchParam",defaultValue="") String searchParam,HttpServletRequest request,
			Model model){
		Page<Fruit> page;
		if (searchParam==null || "".equals(searchParam)) {
			page=this.fruitServiceImpl.listFruit(pageNum, 5,new Object[]{searchParam});
			
		} else {
			try {
				searchParam = new String(searchParam.getBytes("ISO8859_1"),"UTF-8");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			page = this.fruitServiceImpl.listFruit(pageNum, 5, new Object[]{searchParam});
		}
			request.setAttribute("page", page);
			request.setAttribute("searchParam", searchParam);
			return "fruit/list";
	
	}
}