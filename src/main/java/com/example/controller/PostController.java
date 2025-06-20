package com.example.controller;

import com.example.domain.post.Post;
import com.example.dto.PostRequestDto;
import com.example.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public Post createPost(@RequestBody PostRequestDto dto) {
        return postService.createPost(dto);
    }
}