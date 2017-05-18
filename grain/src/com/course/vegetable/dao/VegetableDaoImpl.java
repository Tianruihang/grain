package com.course.vegetable.dao;

import org.springframework.stereotype.Repository;

import com.course.entity.Vegetable;
import com.framework.BaseDao;
import com.framework.Page;


	@Repository
	public class VegetableDaoImpl extends BaseDao<Vegetable, Integer> {

		public void saveVegetable(Vegetable v){
			try {
				this.save(v);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public Page<Vegetable> findVegetable(int pageNum, int pageSize,Object[] params){
			String hql;
			if(params!=null && params.length>0){
				hql="from Vegetable v where v.vname like ?";
				params[0]="%"+params[0]+"%";
				
			}else{
				hql="from Vegetable";
			}
			try {
				Page<Vegetable> page=new Page<Vegetable>();
				page.setCurrentPageNum(pageNum);
				page.setPageSize(pageSize);
				page=this.findByPage(pageNum, pageSize, hql, params);
				return page;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public Vegetable getVegetable(int vegetableId){
			try {
				Vegetable v=this.get(vegetableId);
				return v;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		
		public void updateVegetable(Vegetable v){
			try {
				this.update(v);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void deleteVegetable(int vegetableId){
			try {
				this.delete(vegetableId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
