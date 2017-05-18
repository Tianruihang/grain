package com.course.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="fish")
public class Fish {
	private Integer FishId;
	private String FishName;
	private float FishPrice;
	private Date FishDate;
	private String url;
	private String FishGrade;
	private String FishDescribe;
	private String FishClass;
	private String FishState;
	private String FishPicture;
	private String FishLocation;
	
	private Supply Supply;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getFishId() {
		return FishId;
	}
	public void setFishId(Integer fishId) {
		FishId = fishId;
	}
	public String getFishName() {
		return FishName;
	}
	public void setFishName(String fishName) {
		FishName = fishName;
	}
	public Float getFishPrice() {
		return FishPrice;
	}
	public void setFishPrice(Float fishPrice) {
		FishPrice = fishPrice;
	}
	@ManyToOne
	@JoinColumn(name="SupplyName")
	public Supply getSupply() {
		return Supply;
	}
	
	public void setSupply(Supply Supply) {
		this.Supply = Supply;
	}
	public Date getFishDate() {
		return FishDate;
	}
	public void setFishDate(Date fishDate) {
		FishDate = fishDate;
	}
	public String getFishGrade() {
		return FishGrade;
	}
	public void setFishGrade(String fishGrade) {
		FishGrade = fishGrade;
	}
	public String getFishDescribe() {
		return FishDescribe;
	}
	public void setFishDescribe(String fishDescribe) {
		FishDescribe = fishDescribe;
	}
	public String getFishClass() {
		return FishClass;
	}
	public void setFishClass(String fishClass) {
		FishClass = fishClass;
	}
	public String getFishState() {
		return FishState;
	}
	public void setFishState(String fishState) {
		FishState = fishState;
	}
	public String getFishPicture() {
		return FishPicture;
	}
	public void setFishPicture(String fishPicture) {
		FishPicture = fishPicture;
	}
	public String getFishLocation() {
		return FishLocation;
	}
	public void setFishLocation(String fishLocation) {
		FishLocation = fishLocation;
	}

}
