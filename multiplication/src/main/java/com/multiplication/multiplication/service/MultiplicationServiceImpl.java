package com.multiplication.multiplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.multiplication.multiplication.domain.Multiplication;
import com.multiplication.multiplication.domain.MultiplicationResultAttempt;
import com.multiplication.multiplication.domain.User;
import com.multiplication.multiplication.event.EventDispatcher;
import com.multiplication.multiplication.event.MultiplicationSolvedEvent;
import com.multiplication.multiplication.repository.MultiplicationResultAttemptRepository;
import com.multiplication.multiplication.repository.UserRepository;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

	private RandomGeneratorService randomGeneratorService;
	private MultiplicationResultAttemptRepository attemptRepository;
	private UserRepository userRepository;
	private EventDispatcher eventDispatcher;

	@Autowired
	public MultiplicationServiceImpl(RandomGeneratorService randomGeneratorService,
			MultiplicationResultAttemptRepository attemptRepository, UserRepository userRepository,
			EventDispatcher eventDispatcher) {
		this.randomGeneratorService = randomGeneratorService;
		this.attemptRepository = attemptRepository;
		this.userRepository = userRepository;
		this.eventDispatcher = eventDispatcher;
	}

	@Override
	public Multiplication createRandomMultiplication() {
		int factorA = randomGeneratorService.generateRandomFactor();
		int factorB = randomGeneratorService.generateRandomFactor();
		return new Multiplication(factorA, factorB);
	}

	@Override
	@Transactional
	public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {

		// Check if the user already exists for that alias
		Optional<User> user = userRepository.findByAlias(resultAttempt.getUser().getAlias());

		Assert.isTrue(!resultAttempt.isCorrect(), "You can't send attempt marked as correct");

		boolean isCorrect = resultAttempt.getResultAttempt() == resultAttempt.getMultiplication().getFactorA()
				* resultAttempt.getMultiplication().getFactorB();

		MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(
				user.orElse(resultAttempt.getUser()), resultAttempt.getMultiplication(),
				resultAttempt.getResultAttempt(), isCorrect);

		// Store the attempt
		attemptRepository.save(checkedAttempt);
		// Communicate the result via EventDispatcher
		eventDispatcher.send(new MultiplicationSolvedEvent(checkedAttempt.getId(), checkedAttempt.getUser().getId(),
				checkedAttempt.isCorrect()));

		return isCorrect;
	}

	@Override
	public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
		return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
	}

	@Override
	public MultiplicationResultAttempt getResultById(Long id) {
		Optional<MultiplicationResultAttempt> result = attemptRepository.findById(id);
		return result.orElse(null);
	}
	
	
}
