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
@Table(name="supply")
public class Supply {
	private Integer SupplyId;
	private String SupplyName;
	private Integer SupplyNumber;	
	private String SupplyIntroduce;	
	private String SupplyPicture;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getSupplyId() {
		return SupplyId;
	}
	public void setSupplyId(Integer supplyId) {
		SupplyId = supplyId;
	}
	public String getSupplyName() {
		return SupplyName;
	}
	public void setSupplyName(String supplyName) {
		SupplyName = supplyName;
	}
	public Integer getSupplyNumber() {
		return SupplyNumber;
	}
	public void setSupplyNumber(Integer supplyNumber) {
		SupplyNumber = supplyNumber;
	}
	public String getSupplyIntroduce() {
		return SupplyIntroduce;
	}
	public void setSupplyIntroduce(String supplyIntroduce) {
		SupplyIntroduce = supplyIntroduce;
	}	
	public String getSupplyPicture() {
		return SupplyPicture;
	}
	public void setSupplyPicture(String supplyPicture) {
		SupplyPicture = supplyPicture;
	}
}
