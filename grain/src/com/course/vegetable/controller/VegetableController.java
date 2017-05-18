package com.course.vegetable.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.entity.Vegetable;
import com.course.vegetable.service.VegetableServiceImpl;
import com.framework.Page;

@Controller
@RequestMapping("vegetable")
public class VegetableController {
	@Resource
	private VegetableServiceImpl vegetableServiceImpl;
	
	@RequestMapping("addv")
	public String add(@RequestParam(name="VegetableName") String vname,@RequestParam(name="VegetablePrice") Integer vprice,
			@RequestParam(name="VegetableSupply") String vsupply,@RequestParam(name="VegetableGrade") String vgrade,
			@RequestParam(name="VegetableDescribe") String vdescribe,
			@RequestParam(name="VegetableClass") String vclass,
			@RequestParam(name="VegetableState") String vstate,
			@RequestParam(name="VegetablePicture") String vpicture,
			@RequestParam(name="VegetableLocation") String vlocation,HttpServletRequest request){
		
		String name = null;
		String supply = null;
		String grade = null;
		String describe = null;
		String classes = null;
		String picture = null;
		String state = null;
		String location = null;
		try {
			name = new String(vname.getBytes("ISO8859_1"), "UTF-8");
			supply = new String(vsupply.getBytes("ISO8859_1"), "UTF-8");
			grade = new String(vgrade.getBytes("ISO8859_1"), "UTF-8");
			describe = new String(vdescribe.getBytes("ISO8859_1"), "UTF-8");
			classes = new String(vclass.getBytes("ISO8859_1"), "UTF-8");
			picture = new String(vpicture.getBytes("ISO8859_1"), "UTF-8");
			state = new String(vstate.getBytes("ISO8859_1"), "UTF-8");
			location = new String(vlocation.getBytes("ISO8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Vegetable v = new Vegetable();
		v.setVegetableName(name);
		v.setVegetablePrice(vprice);
		v.setVegetableSupply(supply);
		v.setVegetableClass(classes);
		v.setVegetableDescribe(describe);
		v.setVegetableGrade(grade);
		v.setVegetableLocation(location);
		v.setVegetablePicture(picture);
		v.setVegetableState(state);
		this.vegetableServiceImpl.addVegetable(v);
		return "redirect:list";
	}
	
	@RequestMapping(value="delete")
	public String delete(@RequestParam("vegetableId") int vegetableId,
			HttpServletRequest request){
		this.vegetableServiceImpl.dropVegetable(vegetableId);
		return "redirect:list";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.GET )
	public String toEdit(@RequestParam("vegetableId") int vegetableId,
			HttpServletRequest request){
//		System.out.println("get");
		
		Vegetable v=this.vegetableServiceImpl.getVegetable(vegetableId);
//		设置了两个session范围的属性
		request.setAttribute("veg", v);
		request.setAttribute("action", "edit");
		return "vegetable/edit";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	public String edit(Vegetable v,HttpServletRequest request){
//		System.out.println("post");
		String name = null;
		try {
			name = new String(v.getVegetableName().getBytes("ISO8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		v.setVegetableName(name);
		this.vegetableServiceImpl.editVegetable(v);
		return "redirect:list";
	}
	
	@RequestMapping("list")
	public String list(@RequestParam(name="pageNum", defaultValue="1") int pageNum,
			@RequestParam(name="searchParam",defaultValue="") String searchParam,HttpServletRequest request,
			Model model){
		Page<Vegetable> page;
		if(searchParam==null || "".equals(searchParam)){
			page=this.vegetableServiceImpl.listVegetable(pageNum, 5, null);	
		}else{
//			System.out.println("before"+searchParam);
			try {
			 searchParam = new String(searchParam.getBytes("ISO8859_1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
//			System.out.println("after"+searchParam);
			page=this.vegetableServiceImpl.listVegetable(pageNum, 5, new Object[]{searchParam});
		}
		request.setAttribute("page", page);
		request.setAttribute("searchParam", searchParam);
		return "vegetable/list";
		
	}

}
