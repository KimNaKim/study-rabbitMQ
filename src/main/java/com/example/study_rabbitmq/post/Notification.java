package com.example.study_rabbitmq.post;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification_tb")
@Getter
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String message;
    private LocalDateTime createdAt;

    @Builder
    public Notification(String message) {
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }
}
