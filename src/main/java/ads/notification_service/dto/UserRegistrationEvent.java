package ads.notification_service.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserRegistrationEvent {

    private UUID eventId;
    private String eventType;
    private LocalDateTime createdAt;
    private UUID createdBy;
    private UserData data;

    @Data
    public static class UserData {
        private UUID id;
        private String fullName;
        private String email;
        private Integer roleId;
    }
}