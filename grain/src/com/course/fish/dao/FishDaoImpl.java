package com.course.fish.dao;

import org.springframework.stereotype.Repository;

import com.course.entity.Fish;
import com.framework.BaseDao;
import com.framework.Page;

@Repository
public class FishDaoImpl extends BaseDao<Fish,Integer> {
	
	public void saveFish(Fish F){
		try{
			this.save(F);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Page<Fish> findFish(int pageNum,int pageSize,Object[] params){
		String hql;
		if(params !=null && params.length>0){
			hql="from Fish f where f.name like ?";
			params[0]="%"+params[0]+"%";
		}else{
			hql="from Fish";
		}
		try{
			Page<Fish> page = new Page<Fish>();
			page.setCurrentPageNum(pageNum);
			page.setPageSize(pageSize);
			page=this.findByPage(pageNum, pageSize, hql, params);
			return page;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public Fish getFish(int fishId){
		try {
			Fish f = this.get(fishId);
			return f;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public void updateFish(Fish f){
		try {
			this.update(f);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void deleteFish(int fishId){
		try {
			this.delete(fishId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

