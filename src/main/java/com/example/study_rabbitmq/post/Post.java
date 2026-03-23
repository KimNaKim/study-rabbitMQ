package com.example.study_rabbitmq.post;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post_tb")
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String content;

    @Builder
    public Post(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
