package com.course.collect.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.course.collect.dao.CollectDaoImpl;
import com.course.entity.Collect;
import com.framework.Page;

@Service
@Transactional(readOnly=false)
public class CollectServiceImpl {
	
	@Resource
    private CollectDaoImpl CollectDaoImpl;
	
	public void addCollect(Collect p){
		this.CollectDaoImpl.saveCollect(p);
	}

	@Transactional(readOnly=true)
	public Page<Collect> listCollect(int pageNum,int pageSize,Object[] params){
		return this.CollectDaoImpl.findCollect(pageNum, pageSize, params);
	}
	
	@Transactional(readOnly=true)
	public Collect getCollect(int CollectId){
		return this.CollectDaoImpl.getCollect(CollectId);
	}
	
	public void editCollect(Collect p){
		Collect pdb=this.CollectDaoImpl.getCollect(p.getCollectId());
		pdb.setUserId(p.getUserId());
		pdb.setFruitId(p.getFruitId());
		pdb.setMeatId(p.getMeatId());
		pdb.setFishId(p.getFishId());
		pdb.setVegetableId(p.getVegetableId());
		this.CollectDaoImpl.updateCollect(pdb);
	}
	
	public void dropCollect(int CollectId){
		this.CollectDaoImpl.deleteCollect(CollectId);
	}

}
