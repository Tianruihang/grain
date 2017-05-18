package com.course.meat.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.Meat;
import com.course.meat.dao.MeatDaoImpl;
import com.framework.Page;

@Service
@Transactional
public class MeatServiceImpl {
	@Resource
	private MeatDaoImpl meatDaoImpl;
	
	public void addMeat(Meat f){
		this.meatDaoImpl.saveMeat(f);
	}
	
	@Transactional(readOnly=true)
	public Page<Meat>listMeat(int pageNum,int pageSize,Object[] param){
		return this.meatDaoImpl.findMeat(pageNum, pageSize,param);
	}
	
	@Transactional(readOnly=true)
	public Meat getMeat(int meatId){
		return this.meatDaoImpl.getMeat(meatId);
	}
	
	public void editMeat(Meat f){
		Meat fdb = this.meatDaoImpl.getMeat(f.getMeatId());
		fdb.setMeatName(f.getMeatName());
		fdb.setMeatPrice(f.getMeatPrice());
		this.meatDaoImpl.updateMeat(fdb);
	}
	public void dropMeat(int meatId){
		this.meatDaoImpl.deleteMeat(meatId);
	}

}
