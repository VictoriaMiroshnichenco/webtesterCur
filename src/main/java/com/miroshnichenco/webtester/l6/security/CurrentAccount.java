package com.miroshnichenco.webtester.l6.security;


import org.springframework.security.core.userdetails.User;

public class CurrentAccount extends User{
	private static final long serialVersionUID = 1L;
	private final long idAccount;
	private int role;
	public CurrentAccount(com.miroshnichenco.webtester.l1.entities.User a) {
		super(a.getEmail(), a.getPassword(), a.getActive(), true, true, true, 
				AuthentificationService.convert(a.getAccountRoles()));
		this.idAccount = a.getIdUser();
	}
	public long getIdAccount() {
		return idAccount;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
}
