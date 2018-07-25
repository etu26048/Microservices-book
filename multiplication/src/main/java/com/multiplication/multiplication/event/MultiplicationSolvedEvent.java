package com.multiplication.multiplication.event;

import java.io.Serializable;

public class MultiplicationSolvedEvent implements Serializable {

	private final Long multiplicationResultAttemptId;
	private final Long userId;
	private final boolean correct;

	public MultiplicationSolvedEvent() {
		multiplicationResultAttemptId = null;
		userId = null;
		correct = false;
	}

	public MultiplicationSolvedEvent(Long multiplicationResultAttemptId, Long userId, boolean correct) {
		this.multiplicationResultAttemptId = multiplicationResultAttemptId;
		this.userId = userId;
		this.correct = correct;
	}

	public Long getMultiplicationResultAttemptId() {
		return multiplicationResultAttemptId;
	}

	public Long getUserId() {
		return userId;
	}

	public boolean isCorrect() {
		return correct;
	}

}
