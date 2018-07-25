package microservices.book.gamification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import microservices.book.gamification.domain.GameStats;
import microservices.book.gamification.service.IGameService;

@RestController
@RequestMapping("/stats")
public class UserStatsController {

	private final IGameService gameService;

	@Autowired
	public UserStatsController(final IGameService gameService) {
		this.gameService = gameService;
	}

	@GetMapping
	public GameStats getStatsForUser(@RequestParam("userId") final Long userId) {
		return gameService.retrieveStatsForUser(userId);
	}

}
