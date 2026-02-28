package ads.notification_service.consumer;

import ads.notification_service.config.RabbitMQConfig;
import ads.notification_service.dto.BaseEvent;
import ads.notification_service.dto.UserRegistrationData;
import ads.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserRegistrationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consume(BaseEvent<UserRegistrationData> event) {

        log.info("Received event: {}", event);

        // ✅ kirim full event
        notificationService.processUserRegistration(event);
    }
}