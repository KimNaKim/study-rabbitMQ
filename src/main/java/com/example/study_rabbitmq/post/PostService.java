package com.example.study_rabbitmq.post;

import com.example.study_rabbitmq._core.config.RabbitMqConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final RabbitTemplate rabbitTemplate;

    @Transactional
    public PostResponse.Detail save(PostRequest.SaveDTO requestDTO) {
        // 1. DB 저장
        Post post = postRepository.save(requestDTO.toEntity());
        PostResponse.Detail detail = new PostResponse.Detail(post);

        // 2. RabbitMQ 메시지 발행 (비동기 처리용)
        rabbitTemplate.convertAndSend(
                RabbitMqConfig.EXCHANGE_NAME,
                RabbitMqConfig.ROUTING_KEY,
                detail
        );

        return detail;
    }
}
