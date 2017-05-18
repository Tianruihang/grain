package com.course.meat.dao;

import org.springframework.stereotype.Repository;

import com.course.entity.Meat;
import com.framework.BaseDao;
import com.framework.Page;

@Repository
public class MeatDaoImpl extends BaseDao<Meat,Integer>{
	public void saveMeat(Meat F){
		try{
			this.save(F);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Page<Meat> findMeat(int pageNum,int pageSize,Object[] params){
		String hql;
		if(params !=null && params.length>0){
			hql="from Meat f where f.name like ?";
			params[0]="%"+params[0]+"%";
		}else{
			hql="from Meat";
		}
		try{
			Page<Meat> page = new Page<Meat>();
			page.setCurrentPageNum(pageNum);
			page.setPageSize(pageSize);
			page=this.findByPage(pageNum, pageSize, hql, params);
			return page;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public Meat getMeat(int meatId){
		try {
			Meat f = this.get(meatId);
			return f;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public void updateMeat(Meat f){
		try {
			this.update(f);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void deleteMeat(int meatId){
		try {
			this.delete(meatId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
