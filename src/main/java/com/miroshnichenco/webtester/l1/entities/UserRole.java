package com.miroshnichenco.webtester.l1.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the account_role database table.
 * 
 */
@Entity
@Table(name="user_role")
public class UserRole extends AbstractEntity  {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCOUNT_ROLE_IDACCOUNTROLE_GENERATOR", sequenceName="USER_ROLE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNT_ROLE_IDACCOUNTROLE_GENERATOR")
	@Column(name="id_user_role", unique=true, nullable=false)
	private Long idUserRole;

	//bi-directional many-to-one association to Account
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user", nullable=false)
	private User user;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_role", nullable=false)
	private Role role;

    public UserRole() {
    }

	public Long getIdUserRole() {
		return this.idUserRole;
	}
	
	@Transient
	@Override
	public Serializable getId() {
		return getIdUserRole();
	}

	public void setIdUserRole(Long idAccountRole) {
		this.idUserRole = idAccountRole;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}