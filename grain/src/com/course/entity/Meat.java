package com.course.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="meat")
public class Meat {
	private Integer MeatId;
	private String MeatName;
	private float MeatPrice;
	private Date MeatDate;
	private String url;
	private String MeatGrade;
	private String MeatDescribe;
	private String MeatClass;
	private String MeatState;
	private String MeatPicture;
	private String MeatLocation;
	
	private Supply Supply;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getMeatId() {
		return MeatId;
	}
	public void setMeatId(Integer meatId) {
		MeatId = meatId;
	}
	public String getMeatName() {
		return MeatName;
	}
	public void setMeatName(String meatName) {
		MeatName = meatName;
	}
	public Float getMeatPrice() {
		return MeatPrice;
	}
	public void setMeatPrice(Float meatPrice) {
		MeatPrice = meatPrice;
	}
	@ManyToOne
	@JoinColumn(name="SupplyName")
	public Supply getSupply() {
		return Supply;
	}
	
	public void setSupply(Supply Supply) {
		this.Supply = Supply;
	}
	public Date getMeatDate() {
		return MeatDate;
	}
	public void setMeatDate(Date meatDate) {
		MeatDate = meatDate;
	}
	public String getMeatGrade() {
		return MeatGrade;
	}
	public void setMeatGrade(String meatGrade) {
		MeatGrade = meatGrade;
	}
	public String getMeatDescribe() {
		return MeatDescribe;
	}
	public void setMeatDescribe(String meatDescribe) {
		MeatDescribe = meatDescribe;
	}
	public String getMeatClass() {
		return MeatClass;
	}
	public void setMeatClass(String meatClass) {
		MeatClass = meatClass;
	}
	public String getMeatState() {
		return MeatState;
	}
	public void setMeatState(String meatState) {
		MeatState = meatState;
	}
	public String getMeatPicture() {
		return MeatPicture;
	}
	public void setMeatPicture(String meatPicture) {
		MeatPicture = meatPicture;
	}
	public String getMeatLocation() {
		return MeatLocation;
	}
	public void setMeatLocation(String meatLocation) {
		MeatLocation = meatLocation;
	}
	
	
	

}
