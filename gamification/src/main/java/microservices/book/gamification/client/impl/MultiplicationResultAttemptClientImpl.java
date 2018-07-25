package microservices.book.gamification.client.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import microservices.book.gamification.client.IMultiplicationResultAttemptClient;
import microservices.book.gamification.client.dto.MultiplicationResultAttempt;
import microservices.book.gamification.event.EventHandler;

@Component
public class MultiplicationResultAttemptClientImpl implements IMultiplicationResultAttemptClient {

	private final Logger logger = LoggerFactory.getLogger(MultiplicationResultAttemptClientImpl.class);

	private final RestTemplate restTemplate;
	private String multiplicationHost;

	@Autowired
	public MultiplicationResultAttemptClientImpl(final RestTemplate restTemplate,
			@Value("${multiplicationHost}") String multiplicationHost) {
		this.restTemplate = restTemplate;
		this.multiplicationHost = multiplicationHost;
	}

	@Override
	public MultiplicationResultAttempt retrieveMultiplicationResultAttemptbyId(final Long multiplicationId) {
		logger.info("call to : " + multiplicationHost + "/results/" + multiplicationId);
		return restTemplate.getForObject(multiplicationHost + "/results/" + multiplicationId,
				MultiplicationResultAttempt.class);
	}

}
