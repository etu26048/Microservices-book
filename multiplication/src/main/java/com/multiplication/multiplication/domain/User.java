package com.multiplication.multiplication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Stores information to identify the user.
 */
@Entity
public final class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long id;

	private final String alias;

	// Empty constructor for JSON (de)serialization
	protected User() {
		alias = null;
	}

	public User(String alias) {
		this.alias = alias;
	}

	public String getAlias() {
		return alias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
