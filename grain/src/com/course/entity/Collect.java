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
	public User UserId;
	public Fruit FruitId;
	public Meat MeatId;
	public Fish FishId;
	public Vegetable VegetableId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getCollectId() {
		return CollectId;
	}
	public void setCollectId(Integer CollectId) {
		this.CollectId = CollectId;
	}
	
	@ManyToOne
	@JoinColumn(name="UserId")
	public User getUserId() {
		return UserId;
	}
	public void setUserId(User UserId) {
		this.UserId = UserId;
	}
	
	@ManyToOne
	@JoinColumn(name="FruitId")
	public Fruit getFruitId() {
		return FruitId;
	}
	public void setFruitId(Fruit FruitId) {
		this.FruitId = FruitId;
	}
	
	@ManyToOne
	@JoinColumn(name="MeatId")
	public Meat getMeatId() {
		return MeatId;
	}
	public void setMeatId(Meat MeatId) {
		this.MeatId = MeatId;
	}
	
	@ManyToOne
	@JoinColumn(name="FishId")
	public Fish getFishId() {
		return FishId;
	}
	public void setFishId(Fish FishId) {
		this.FishId = FishId;
	}
	
	@ManyToOne
	@JoinColumn(name="VegetableId")
	public Vegetable getVegetableId() {
		return VegetableId;
	}
	public void setVegetableId(Vegetable VegetableId) {
		this.VegetableId = VegetableId;
	}
	

}
