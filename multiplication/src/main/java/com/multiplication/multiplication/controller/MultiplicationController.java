package com.multiplication.multiplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplication.multiplication.domain.Multiplication;
import com.multiplication.multiplication.service.MultiplicationService;

/**
 * This class implements a REST API for our Multiplication application.
 */
@RestController
@RequestMapping("/multiplications")
public final class MultiplicationController {

	private final MultiplicationService multiplicationService;

	@Autowired
	public MultiplicationController(final MultiplicationService multiplicationService) {
		this.multiplicationService = multiplicationService;
	}

	@GetMapping("/random")
	public Multiplication getRandomMultiplication() {
		return multiplicationService.createRandomMultiplication();
	}

}
