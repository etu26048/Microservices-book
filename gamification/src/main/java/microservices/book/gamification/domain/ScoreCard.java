package microservices.book.gamification.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public final class ScoreCard {

	// The default score assigned to this card, if not specified.
	public static final int DEFAULT_SCORE = 10;
	@Id
	@GeneratedValue
	@Column(name = "CARD_ID")
	private final Long cardId;
	@Column(name = "USER_ID")
	private final Long userId;
	@Column(name = "ATTEMPT_ID")
	private final Long attemptId;
	@Column(name = "SCORE_TS")
	private final long scoreTimestamp;
	@Column(name = "SCORE")
	private final int score;

	// Empty constructor for JSON / JPA
	public ScoreCard() {
		this.cardId = null;
		this.userId = null;
		this.attemptId = null;
		this.scoreTimestamp = 0;
		this.score = 0;
	}

	public ScoreCard(final Long userId, final Long attemptId) {
		this.cardId = null;
		this.userId = userId;
		this.attemptId = attemptId;
		this.scoreTimestamp = System.currentTimeMillis();
		this.score = DEFAULT_SCORE;
	}

	public static int getDefaultScore() {
		return DEFAULT_SCORE;
	}

	public Long getCardId() {
		return cardId;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getAttemptId() {
		return attemptId;
	}

	public long getScoreTimestamp() {
		return scoreTimestamp;
	}

	public int getScore() {
		return score;
	}
	
	

}
