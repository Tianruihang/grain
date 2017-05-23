package com.course.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vegetable")
public class Vegetable {
	private Integer VegetableId;
	private String VegetableName;
	private float VegetablePrice;
	private Date VegetableDate;
	private String VegetableGrade;
	private String VegetableDescribe;
	private String VegetableClass;
	private String VegetableState;
	private String VegetablePicture;
	private String VegetableLocation;
	
	private Supply Supply;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getVegetableId() {
		return VegetableId;
	}
	public void setVegetableId(Integer vegetableId) {
		VegetableId = vegetableId;
	}
	public String getVegetableName() {
		return VegetableName;
	}
	public void setVegetableName(String vegetableName) {
		VegetableName = vegetableName;
	}
	public float getVegetablePrice() {
		return VegetablePrice;
	}
	public void setVegetablePrice(float vegetablePrice) {
		VegetablePrice = vegetablePrice;
	}
	@ManyToOne
	@JoinColumn(name="SupplyName")
	public Supply getSupply() {
		return Supply;
	}
	public void setSupply(Supply Supply) {
		this.Supply = Supply;
	}
	public Date getVegetableDate() {
		return VegetableDate;
	}
	public void setVegetableDate(Date vegetableDate) {
		VegetableDate = vegetableDate;
	}
	public String getVegetableGrade() {
		return VegetableGrade;
	}
	public void setVegetableGrade(String vegetableGrade) {
		VegetableGrade = vegetableGrade;
	}
	public String getVegetableDescribe() {
		return VegetableDescribe;
	}
	public void setVegetableDescribe(String vegetableDescribe) {
		VegetableDescribe = vegetableDescribe;
	}
	public String getVegetableClass() {
		return VegetableClass;
	}
	public void setVegetableClass(String vegetableClass) {
		VegetableClass = vegetableClass;
	}
	public String getVegetableState() {
		return VegetableState;
	}
	public void setVegetableState(String vegetableState) {
		VegetableState = vegetableState;
	}
	public String getVegetablePicture() {
		return VegetablePicture;
	}
	public void setVegetablePicture(String vegetablePicture) {
		VegetablePicture = vegetablePicture;
	}
	public String getVegetableLocation() {
		return VegetableLocation;
	}
	public void setVegetableLocation(String vegetableLocation) {
		VegetableLocation = vegetableLocation;
	}
	
	
	
	
	
}
