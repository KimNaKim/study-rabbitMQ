package com.example.study_rabbitmq.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class PostRabbitMqTest {

    @Autowired
    private PostService postService;

    @Test
    public void postSave_RabbitMq_Test() throws InterruptedException {
        // Given
        PostRequest.SaveDTO saveDTO = new PostRequest.SaveDTO();
        saveDTO.setTitle("테스트 제목");
        saveDTO.setContent("테스트 내용");

        // When
        System.out.println(">>> 게시글 저장 시작");
        postService.save(saveDTO);
        System.out.println(">>> 게시글 저장 완료 (메시지 발행됨)");

        // Then
        // 비동기 처리를 확인하기 위해 잠시 대기 (Listener 로그 확인용)
        TimeUnit.SECONDS.sleep(3);
        System.out.println(">>> 테스트 종료");
    }
}
