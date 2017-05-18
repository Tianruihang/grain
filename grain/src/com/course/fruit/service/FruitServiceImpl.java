package com.course.fruit.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.Fruit;
import com.course.fruit.dao.FruitDaoImpl;
import com.framework.Page;

@Service
@Transactional
public class FruitServiceImpl {

	@Resource
	private FruitDaoImpl fruitDaoImpl;
	
	public void addFruit(Fruit f){
		this.fruitDaoImpl.saveFurit(f);
	}
	
	@Transactional(readOnly=true)
	public Page<Fruit>listFruit(int pageNum,int pageSize,Object[] param){
		return this.fruitDaoImpl.findFruit(pageNum, pageSize,param);
	}
	
	@Transactional(readOnly=true)
	public Fruit getFruit(int fruitId){
		return this.fruitDaoImpl.getFruit(fruitId);
	}
	
	public void editFruit(Fruit f){
		Fruit fdb = this.fruitDaoImpl.getFruit(f.getFruitId());
		fdb.setFruitName(f.getFruitName());
		fdb.setFruitPrice(f.getFruitPrice());
		this.fruitDaoImpl.updateFruit(fdb);
	}
	public void dropFruit(int fruitId){
		this.fruitDaoImpl.deleteFruit(fruitId);
	}
}
