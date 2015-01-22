package com.miroshnichenco.webtester.l5.mvc.forms;

import java.sql.Timestamp;

public abstract class AbstractForm {
	private Timestamp created;
	private Timestamp updated;
	private Boolean active;
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
}
