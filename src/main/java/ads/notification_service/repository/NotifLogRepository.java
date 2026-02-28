package ads.notification_service.repository;

import ads.notification_service.entity.NotifLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotifLogRepository extends JpaRepository<NotifLog, Long> {
}