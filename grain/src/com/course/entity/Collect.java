package com.course.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="collect")
public class Collect {
	public Integer CollectId;
	public Integer UserId;
	public Integer FruitId;
	public Integer MeatId;
	public Integer FishId;
	public Integer VegetableId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getCollectId() {
		return CollectId;
	}
	public void setCollectId(Integer CollectId) {
		this.CollectId = CollectId;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer UserId) {
		this.UserId = UserId;
	}
	
	@ManyToOne
	@JoinColumn(name="FruitId")
	public Integer getFruitId() {
		return FruitId;
	}
	public void setFruitId(Integer FruitId) {
		this.FruitId = FruitId;
	}
	
	@ManyToOne
	@JoinColumn(name="MeatId")
	public Integer getMeatId() {
		return MeatId;
	}
	public void setMeatId(Integer MeatId) {
		this.MeatId = MeatId;
	}
	
	@ManyToOne
	@JoinColumn(name="FishId")
	public Integer getFishId() {
		return FishId;
	}
	public void setFishId(Integer FishId) {
		this.FishId = FishId;
	}
	
	@ManyToOne
	@JoinColumn(name="VegetableId")
	public Integer getVegetableId() {
		return VegetableId;
	}
	public void setVegetableId(Integer VegetableId) {
		this.VegetableId = VegetableId;
	}
	

}
