package com.sms_service.repository;

import com.sms_service.entity.SmsLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SmsLogRepository extends JpaRepository<SmsLog, Long> {

    // Find all SMS logs by sender
    List<SmsLog> findBySender(String sender);

    // Find all SMS logs by recipient
    List<SmsLog> findByRecipient(String recipient);

    // Find SMS logs sent after a specific timestamp
    List<SmsLog> findByTimestampAfter(LocalDateTime timestamp);

    // Find SMS logs sent between two timestamps
    List<SmsLog> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}
