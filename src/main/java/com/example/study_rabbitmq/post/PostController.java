package com.example.study_rabbitmq.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;
    private final NotificationRepository notificationRepository;

    @GetMapping("/")
    public String board(Model model) {
        // 게시글 목록 조회
        List<Post> posts = postRepository.findAll();
        // 알림 목록 조회 (비동기 처리 결과 확인용)
        List<Notification> notifications = notificationRepository.findAll();

        model.addAttribute("posts", posts);
        model.addAttribute("notifications", notifications);
        return "post-board";
    }

    @PostMapping("/posts/save")
    public String save(PostRequest.SaveDTO requestDTO) {
        // 1:1 Simple Queue 전송 로직이 포함된 서비스 호출
        postService.save(requestDTO);
        return "redirect:/";
    }
}
