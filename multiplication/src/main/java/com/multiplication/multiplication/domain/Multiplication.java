package com.multiplication.multiplication.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class represents a Multiplication (a * b).
 */
@Entity
public final class Multiplication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MULTIPLICATION_ID")
	private Long id;

	// Both factors
	private final int factorA;
	private final int factorB;

	// Empty constructor for JSON (de)serialization
	public Multiplication() {
		this(0, 0);
	}

	public Multiplication(int factorA, int factorB) {
		this.factorA = factorA;
		this.factorB = factorB;
	}

	public int getFactorA() {
		return factorA;
	}

	public int getFactorB() {
		return factorB;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
