package microservices.book.gamification.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import microservices.book.gamification.client.IMultiplicationResultAttemptClient;
import microservices.book.gamification.client.dto.MultiplicationResultAttempt;

@Component
public class MultiplicationResultAttemptClientImpl implements IMultiplicationResultAttemptClient {

	private final RestTemplate restTemplate;
	private String multiplicationHost;

	@Autowired
	public MultiplicationResultAttemptClientImpl(RestTemplate restTemplate,
			@Value("${multiplicationHost}") String multiplicationHost) {
		this.restTemplate = restTemplate;
		this.multiplicationHost = multiplicationHost;
	}

	@Override
	public MultiplicationResultAttempt retrieveMultiplicationResultAttemptbyId(Long multiplicationId) {
		return restTemplate.getForObject(multiplicationHost + "/results/" + multiplicationId,
				MultiplicationResultAttempt.class);
	}

}
