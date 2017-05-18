package com.course.vegetable.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.Vegetable;
import com.course.vegetable.dao.VegetableDaoImpl;
import com.framework.Page;

@Service
@Transactional(readOnly=false)
public class VegetableServiceImpl {
	@Resource
	private VegetableDaoImpl vegetableDaoImpl;
	
	public void addVegetable(Vegetable v){
		this.vegetableDaoImpl.saveVegetable(v);
	}

	@Transactional(readOnly=true)
	public Page<Vegetable> listVegetable(int pageNum,int pageSize,Object[] params){
		return this.vegetableDaoImpl.findVegetable(pageNum, pageSize, params);
	}
	
	@Transactional(readOnly=true)
	public Vegetable getVegetable(int vegetableId){
		return this.vegetableDaoImpl.getVegetable(vegetableId);
	}
	
	public void editVegetable(Vegetable v){
//		System.out.println(p.getProductId());
//		System.out.println(p.getName());
//		System.out.println(p.getPrice());
		Vegetable veg=this.vegetableDaoImpl.getVegetable(v.getVegetableId());
		veg.setVegetableName(v.getVegetableName());
		veg.setVegetablePrice(v.getVegetablePrice());
		this.vegetableDaoImpl.updateVegetable(veg);
	}
	
	public void dropVegetable(int vegetableId){
		this.vegetableDaoImpl.deleteVegetable(vegetableId);
	}

}
