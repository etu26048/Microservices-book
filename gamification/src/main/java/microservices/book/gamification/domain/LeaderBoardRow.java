package microservices.book.gamification.domain;

public final class LeaderBoardRow {

	private final Long userId;
	private final Long totalScore;

	public LeaderBoardRow(Long userId, Long totalScore) {
		this.userId = userId;
		this.totalScore = totalScore;
	}

	public LeaderBoardRow() {
		this.userId = 0L;
		this.totalScore = 0L;
	}

}
