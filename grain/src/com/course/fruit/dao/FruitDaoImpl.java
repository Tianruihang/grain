package com.course.fruit.dao;

import org.springframework.stereotype.Repository;

import com.course.entity.Fruit;
import com.framework.BaseDao;
import com.framework.Page;

@Repository
public class FruitDaoImpl extends BaseDao<Fruit,Integer> {
	
	public void saveFurit(Fruit F){
		try{
			this.save(F);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Page<Fruit> findFruit(int pageNum,int pageSize,Object[] params){
		String hql;
		if(params !=null && params.length>0){
			hql="from Fruit f where f.name like ?";
			params[0]="%"+params[0]+"%";
		}else{
			hql="from Fruit";
		}
		try{
			Page<Fruit> page = new Page<Fruit>();
			page.setCurrentPageNum(pageNum);
			page.setPageSize(pageSize);
			page=this.findByPage(pageNum, pageSize, hql, params);
			return page;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public Fruit getFruit(int fruitId){
		try {
			Fruit f = this.get(fruitId);
			return f;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public void updateFruit(Fruit f){
		try {
			this.update(f);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void deleteFruit(int fruitId){
		try {
			this.delete(fruitId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
