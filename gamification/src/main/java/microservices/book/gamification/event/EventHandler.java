package microservices.book.gamification.event;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import microservices.book.gamification.service.IGameService;

@Component
public class EventHandler {

	private IGameService gameService;

	@Autowired
	public EventHandler(IGameService gameService) {
		this.gameService = gameService;
	}

	@RabbitListener(queues = "${multiplication.queue}")
	public void handleMultiplicationSolved(final MultiplicationSolvedEvent event) {
		try {
			gameService.newAttemptForUser(event.getUserId(), event.getMultiplicationResultAttemptId(),
					event.isCorrect());
		} catch (final Exception e) {

			// Avoids the event to re-queued and reprocessed
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}

}
