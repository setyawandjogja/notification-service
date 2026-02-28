package ads.notification_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notif_logs", schema = "public")
@Getter
@Setter
public class NotifLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "notif_type")
    private String notifType;

    @Column(name = "notif_body")
    private String notifBody;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}