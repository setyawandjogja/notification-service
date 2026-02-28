package ads.notification_service.service;

import ads.notification_service.dto.BaseEvent;
import ads.notification_service.dto.UserRegistrationData;
import ads.notification_service.entity.NotifLog;
import ads.notification_service.repository.NotifLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final JavaMailSender mailSender;
    private final NotifLogRepository notifLogRepository;

    public void processUserRegistration(BaseEvent<UserRegistrationData> event) {

        UserRegistrationData data = event.getData();

        String email = data.getEmail();
        String fullName = data.getFullName();

        // ===============================
        // Send Email
        // ===============================
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Welcome to Our Platform");
        message.setText("Hi " + fullName + ", your account has been created.");

        mailSender.send(message);

        log.info("Email sent to {}", email);

        // ===============================
        // Save Notification Log
        // ===============================
        NotifLog logEntity = new NotifLog();
        logEntity.setNotifType(event.getEventType());
        logEntity.setNotifBody("Email sent to " + email);

        notifLogRepository.save(logEntity);

        log.info("Notification log saved for event {}", event.getEventId());
    }
}