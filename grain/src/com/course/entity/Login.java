package com.course.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login {
	private String LoginName;
	private String Password;
	private String Root;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		this.LoginName = loginName;
	}
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getRoot() {
		return Root;
	}
	public void setRoot(String Root) {
		this.Root = Root;
	}
	
}
