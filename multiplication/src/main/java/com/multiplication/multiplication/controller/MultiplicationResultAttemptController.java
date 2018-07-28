package com.multiplication.multiplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multiplication.multiplication.domain.MultiplicationResultAttempt;
import com.multiplication.multiplication.service.MultiplicationService;

/**
 * This class provides a REST API to POST the attempts from users.
 */
@RestController
@RequestMapping("/results")
public final class MultiplicationResultAttemptController {

	private final MultiplicationService multiplicationService;

	@Autowired
	public MultiplicationResultAttemptController(final MultiplicationService multiplicationService) {
		this.multiplicationService = multiplicationService;
	}

	@PostMapping
	public ResponseEntity<MultiplicationResultAttempt> postResult(
			@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {

		boolean isCorrect = multiplicationService.checkAttempt(multiplicationResultAttempt);
		MultiplicationResultAttempt attemptCopy = new MultiplicationResultAttempt(multiplicationResultAttempt.getUser(),
				multiplicationResultAttempt.getMultiplication(), multiplicationResultAttempt.getResultAttempt(),
				isCorrect);
		return ResponseEntity.ok(attemptCopy);
	}

	@GetMapping()
	public ResponseEntity<List<MultiplicationResultAttempt>> getStatistics(@RequestParam("alias") String alias) {
		return ResponseEntity.ok(multiplicationService.getStatsForUser(alias));
	}

	@GetMapping("/{resultId)")
	public MultiplicationResultAttempt getResultById(@PathVariable("resultId") Long id) {
			return multiplicationService.getResultById(id);
	}
}
