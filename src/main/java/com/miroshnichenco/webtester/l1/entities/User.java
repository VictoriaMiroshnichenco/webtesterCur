package com.miroshnichenco.webtester.l1.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name="\"user\"")
public class User extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	
	@Id
	@SequenceGenerator(name="ACCOUNT_IDACCOUNT_GENERATOR", sequenceName="USER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNT_IDACCOUNT_GENERATOR")
	@Column(name="id_user", unique=true, nullable=false)
	private Long idUser;

	@Column(nullable=false)
	private Boolean active;

	@Column(nullable=false)
	private Timestamp created;

	@Column(nullable=false, length=100)
	private String email;

	@Column(nullable=false, length=60)
	private String login;

	@Column(length=80)
	private String name;

	@Column(nullable=false, length=255)
	private String password;


	@Column(nullable=true)
	private Timestamp updated;

	//bi-directional many-to-one association to AccountRole
	@OneToMany(mappedBy="user")
	private List<UserRole> userRoles;

	//bi-directional one-to-one association to AccountTempPwd
//	@OneToOne(mappedBy="account", fetch=FetchType.LAZY)
	//FIXME!!!!!!!!! Hibernate does not support OneToOne lazy mode
	//private AccountTempPwd accountTempPwd;

	/*
	//bi-directional many-to-one association to PassedTest
	@OneToMany(mappedBy="account")
	private List<PassedTest> passedTests;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="account")
	private List<Test> tests;
	 */
    public User() {
    }

	public Long getIdUser() {
		return this.idUser;
	}
	
	@Override
	@Transient
	public Serializable getId() {
		return getIdUser();
	}

	public void setIdUser(Long idAccount) {
		this.idUser = idAccount;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public List<UserRole> getAccountRoles() {
		return this.userRoles;
	}

	public void setAccountRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	/*public AccountTempPwd getAccountTempPwd() {
		return this.accountTempPwd;
	}

	public void setAccountTempPwd(AccountTempPwd accountTempPwd) {
		this.accountTempPwd = accountTempPwd;
	}*/
	
	/*public List<PassedTest> getPassedTests() {
		return this.passedTests;
	}

	public void setPassedTests(List<PassedTest> passedTests) {
		this.passedTests = passedTests;
	}
	
	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}*/
	
}