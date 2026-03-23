package com.example.study_rabbitmq._core.sse;

import com.example.study_rabbitmq.post.Notification;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class SseService {

    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    public SseEmitter subscribe() {
        // 60초 동안 연결을 유지하는 Emitter 생성
        SseEmitter emitter = new SseEmitter(60 * 1000L);
        emitters.add(emitter);

        // 연결이 종료되거나 타임아웃 발생 시 목록에서 삭제
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));

        // 연결 즉시 확인 메시지 발송 (JSON 직렬화 오류 방지를 위해 더미 데이터 포함)
        try {
            emitter.send(SseEmitter.event().name("connect").data("connected!"));
        } catch (IOException e) {
            emitters.remove(emitter);
        }

        return emitter;
    }

    // 새로운 알림이 오면 모든 구독자에게 전송 (브로드캐스트)
    public void sendNotification(Notification notification) {
        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(SseEmitter.event().name("notification").data(notification));
            } catch (IOException e) {
                // 전송 실패 시 목록에서 삭제
                emitters.remove(emitter);
            }
        }
    }
}
