package microservices.book.gamification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.book.gamification.domain.LeaderBoardRow;
import microservices.book.gamification.service.ILeaderBoardService;

@RestController
@RequestMapping("/leaders")
public class LeaderBoardController {

	private final ILeaderBoardService leaderBoardService;

	@Autowired
	public LeaderBoardController(final ILeaderBoardService leaderBoardService) {
		this.leaderBoardService = leaderBoardService;
	}

	@GetMapping
	public List<LeaderBoardRow> getLeaderBoard() {

		return leaderBoardService.getCurrentLeaderBoard();
	}

}
