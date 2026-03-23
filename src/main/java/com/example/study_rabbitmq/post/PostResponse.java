package com.example.study_rabbitmq.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

public class PostResponse {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Detail implements Serializable {
        private Integer id;
        private String title;
        private String content;

        public Detail(Post post) {
            this.id = post.getId();
            this.title = post.getTitle();
            this.content = post.getContent();
        }
    }
}
