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
@Table(name="fruit")
public class Fruit {

	private Integer FruitId;
	private String FruitName;
	private float FruitPrice;
	private Date FruitDate;
	private String url;
	private String FruitGrade;
	private String FruitDescribe;
	private String FruitClass;
	private String FruitState;
	private String FruitPicture;
	private String FruitLocation;
	
	private Supply Supply;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getFruitId() {
		return FruitId;
	}
	public void setFruitId(Integer fruitId) {
		FruitId = fruitId;
	}
	public String getFruitName() {
		return FruitName;
	}
	public void setFruitName(String fruitName) {
		FruitName = fruitName;
	}
	public Float getFruitPrice() {
		return FruitPrice;
	}
	public void setFruitPrice(Float fruitPrice) {
		FruitPrice = fruitPrice;
	}
	@ManyToOne
	@JoinColumn(name="SupplyName")
	public Supply getSupply() {
		return Supply;
	}
	
	public void setSupply(Supply Supply) {
		this.Supply = Supply;
	}
	public Date getFruitDate() {
		return FruitDate;
	}
	public void setFruitDate(Date fruitDate) {
		FruitDate = fruitDate;
	}
	public String getFruitGrade() {
		return FruitGrade;
	}
	public void setFruitGrade(String fruitGrade) {
		FruitGrade = fruitGrade;
	}
	public String getFruitDescribe() {
		return FruitDescribe;
	}
	public void setFruitDescribe(String fruitDescribe) {
		FruitDescribe = fruitDescribe;
	}
	public String getFruitClass() {
		return FruitClass;
	}
	public void setFruitClass(String fruitClass) {
		FruitClass = fruitClass;
	}
	public String getFruitState() {
		return FruitState;
	}
	public void setFruitState(String fruitState) {
		FruitState = fruitState;
	}
	public String getFruitPicture() {
		return FruitPicture;
	}
	public void setFruitPicture(String fruitPicture) {
		FruitPicture = fruitPicture;
	}
	public String getFruitLocation() {
		return FruitLocation;
	}
	public void setFruitLocation(String fruitLocation) {
		FruitLocation = fruitLocation;
	}
	
}
