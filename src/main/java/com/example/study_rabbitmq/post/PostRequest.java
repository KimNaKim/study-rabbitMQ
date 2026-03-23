package com.example.study_rabbitmq.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class PostRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SaveDTO {
        private String title;
        private String content;

        public Post toEntity() {
            return Post.builder()
                    .title(title)
                    .content(content)
                    .build();
        }
    }
}
