package microservices.book.gamification.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public final class BadgeCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BADGE_ID")
	private final Long id;

	private final Long userId;
	private final long badgeTimestamp;
	private final Badge badge;

	// Empty constructor for JSON / JPA
	public BadgeCard() {
		userId = null;
		badgeTimestamp = 0;
		id = null;
		badge = null;
	}

	public BadgeCard(final Long userId, final Badge badge) {
		this.userId = userId;
		this.badgeTimestamp = System.currentTimeMillis();
		this.id = null;
		this.badge = badge;
	}

	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public long getBadgeTimestramp() {
		return badgeTimestamp;
	}

	public Badge getBadge() {
		return badge;
	}

}
