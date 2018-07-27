package microservices.book.gamification.client.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import microservices.book.gamification.client.MultiplicationResultAttemptDeserializer;

@JsonDeserialize(using = MultiplicationResultAttemptDeserializer.class)
public final class MultiplicationResultAttempt {

	private final String userAlias;
	private final int multiplicationFactorA;
	private final int multiplicationFactorB;
	private final int resultAttempt;
	private final boolean correct;

	// Empty constructor for JSON/JPA
	MultiplicationResultAttempt() {
		userAlias = null;
		multiplicationFactorA = -1;
		multiplicationFactorB = -1;
		resultAttempt = -1;
		correct = false;
	}

	public MultiplicationResultAttempt(String userAlias, int multiplicationFactorA, int multiplicationFactorB,
			int resultAttempt, boolean correct) {
		this.userAlias = userAlias;
		this.multiplicationFactorA = multiplicationFactorA;
		this.multiplicationFactorB = multiplicationFactorB;
		this.resultAttempt = resultAttempt;
		this.correct = correct;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public int getMultiplicationFactorA() {
		return multiplicationFactorA;
	}

	public int getMultiplicationFactorB() {
		return multiplicationFactorB;
	}

	public int getResultAttempt() {
		return resultAttempt;
	}

	public boolean isCorrect() {
		return correct;
	}

}
