package com.example.study_rabbitmq.post;

import com.example.study_rabbitmq._core.config.RabbitMqConfig;
import com.example.study_rabbitmq._core.sse.SseService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostListener {

    private final NotificationRepository notificationRepository;
    private final SseService sseService;

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void handlePostCreated(PostResponse.Detail detail) {
        // 실제 운영 환경에서는 알림 발송, 로그 저장 등의 무거운 작업을 비동기로 처리
        Notification notification = Notification.builder()
                .message("새 게시글 '" + detail.getTitle() + "'에 대한 비동기 알림이 처리되었습니다!")
                .build();

        notificationRepository.save(notification);

        // 실시간 브라우저 푸시 (SSE)
        sseService.sendNotification(notification);

        System.out.println("--------------------------------------------------");
        System.out.println("[Queue Listener] 새 게시글 수신 및 SSE 전송 완료!");
        System.out.println("ID: " + detail.getId());
        System.out.println("제목: " + detail.getTitle());
        System.out.println("--------------------------------------------------");
    }
}
