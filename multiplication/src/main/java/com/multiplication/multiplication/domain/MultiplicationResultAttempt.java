package com.multiplication.multiplication.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Identifies the attempt from a {@link User} to solve a {@link Multiplication}.
 */
@Entity
public final class MultiplicationResultAttempt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MULTIPLICATION_ID")
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USER_ID")
	private final User user;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "MULTPLICATION_ID")
	private final Multiplication multiplication;

	private final int resultAttempt;

	private boolean correct;

	// Empty constructor for JSON (de)serialization
	public MultiplicationResultAttempt() {
		user = null;
		multiplication = null;
		resultAttempt = -1;
		correct = false;
	}

	public MultiplicationResultAttempt(User user, Multiplication multiplication, int resultAttempt, boolean correct) {
		this.user = user;
		this.multiplication = multiplication;
		this.resultAttempt = resultAttempt;
		this.correct = correct;
	}

	public User getUser() {
		return user;
	}

	public Multiplication getMultiplication() {
		return multiplication;
	}

	public int getResultAttempt() {
		return resultAttempt;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
