package ads.notification_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseEvent<T> {

    private UUID eventId;
    private String eventType;
    private LocalDateTime createdAt;
    private UUID createdBy;
    private T data;
}