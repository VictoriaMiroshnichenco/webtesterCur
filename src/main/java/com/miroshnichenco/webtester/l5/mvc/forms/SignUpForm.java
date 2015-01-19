package com.miroshnichenco.webtester.l5.mvc.forms;

import java.util.Collection;

import com.miroshnichenco.webtester.l1.entities.UserRole;


public class SignUpForm implements IForm {
	private static final long serialVersionUID = 1L;
	
	private Long idUser;
	private String login;
	private String password;
	private String name;
	private String email;
	//private Collection<UserRole> userRoles;
	private String userRoles;
	private Collection<String> existsRoles;
	
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}
	public Collection<String> getExistsRoles() {
		return existsRoles;
	}
	public void setExistsRoles(Collection<String> existsRoles) {
		this.existsRoles = existsRoles;
	}

	
}
