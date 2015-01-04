package com.miroshnichenco.webtester.l1.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the account_temp_pwd database table.
 * 
 */
//@Entity
//@Table(name="account_temp_pwd")
public class AccountTempPwd extends AbstractEntity  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCOUNT_TEMP_PWD_IDACCOUNT_GENERATOR", sequenceName="ACCOUNT_TEMP_PWD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNT_TEMP_PWD_IDACCOUNT_GENERATOR")
	@Column(name="id_user", unique=true, nullable=false)
	private Long idAccount;

	@Column(name="temp_pwd", nullable=false, length=255)
	private String tempPwd;

	
	//bi-directional one-to-one association to Account
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user", nullable=false, insertable=false, updatable=false)
	//FIXME!!!!!!!!! Hibernate does not support OneToOne lazy mode
	private User user;

    public AccountTempPwd() {
    }

	public Long getIdAccount() {
		return this.idAccount;
	}
	
	@Override
	@Transient
	public Serializable getId() {
		return getIdAccount();
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public String getTempPwd() {
		return this.tempPwd;
	}

	public void setTempPwd(String tempPwd) {
		this.tempPwd = tempPwd;
	}

	public User getAccount() {
		return this.user;
	}

	public void setAccount(User user) {
		this.user = user;
	}
}