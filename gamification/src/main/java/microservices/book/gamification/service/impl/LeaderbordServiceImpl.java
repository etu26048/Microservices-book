package microservices.book.gamification.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import microservices.book.gamification.domain.LeaderBoardRow;
import microservices.book.gamification.service.ILeaderBoardService;

@Service
public class LeaderbordServiceImpl implements ILeaderBoardService{

	@Override
	public List<LeaderBoardRow> getCurrentLeaderBoard() {

		return null;
	}
	
	

}
