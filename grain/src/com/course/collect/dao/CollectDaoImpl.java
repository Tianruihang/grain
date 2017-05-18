package com.course.collect.dao;

import org.springframework.stereotype.Repository;

import com.course.entity.Collect;
import com.framework.BaseDao;
import com.framework.Page;


@Repository
public class CollectDaoImpl extends BaseDao<Collect , Integer>{

	public void saveCollect(Collect p){
		try {
			this.save(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Page<Collect> findCollect(int pageNum, int pageSize,Object[] params){
		String hql;
		if(params!=null && params.length>0){
			hql="from Collect p where p.name like ?";
			params[0]="%"+params[0]+"%";
			
		}else{
			hql="from Collect";
		}
		try {
			Page<Collect> page=new Page<Collect>();
			page.setCurrentPageNum(pageNum);
			page.setPageSize(pageSize);
			page=this.findByPage(pageNum, pageSize, hql, params);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Collect getCollect(int CollectId){
		try {
			Collect p=this.get(CollectId);
			return p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void updateCollect(Collect p){
		try {
			this.update(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteCollect(int CollectId){
		try {
			this.delete(CollectId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
