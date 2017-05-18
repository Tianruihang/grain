package com.course.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	public Integer UserId;
	public String UserName;
	public String UserNumber;
	public String UserPicture;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserNumber() {
		return UserNumber;
	}
	public void setUserNumber(String userNumber) {
		UserNumber = userNumber;
	}
	public String getUserPicture() {
		return UserPicture;
	}
	public void setUserPicture(String userPicture) {
		UserPicture = userPicture;
	}
	
}
