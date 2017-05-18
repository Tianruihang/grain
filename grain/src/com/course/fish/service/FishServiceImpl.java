package com.course.fish.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.Fish;
import com.course.fish.dao.FishDaoImpl;
import com.framework.Page;

@Service
@Transactional
public class FishServiceImpl {

	@Resource
	private FishDaoImpl FishDaoImpl;
	
	public void addFish(Fish f){
		this.FishDaoImpl.saveFish(f);
	}
	
	@Transactional(readOnly=true)
	public Page<Fish>listFish(int pageNum,int pageSize,Object[] param){
		return this.FishDaoImpl.findFish(pageNum, pageSize,param);
	}
	
	@Transactional(readOnly=true)
	public Fish getFish(int fishId){
		return this.FishDaoImpl.getFish(fishId);
	}
	
	public void editFish(Fish f){
		Fish fdb = this.FishDaoImpl.getFish(f.getFishId());
		fdb.setFishName(f.getFishName());
		fdb.setFishPrice(f.getFishPrice());
		this.FishDaoImpl.updateFish(fdb);
	}
	public void dropFish(int fishId){
		this.FishDaoImpl.deleteFish(fishId);
	}
}

