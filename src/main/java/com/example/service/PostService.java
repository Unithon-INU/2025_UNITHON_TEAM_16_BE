package com.example.service;

import com.example.domain.post.Post;
import com.example.domain.user.User;
import com.example.dto.PostRequestDto;
import com.example.repository.PostRepository;
import com.example.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public Post createPost(PostRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));

        Post post = Post.builder()
                .title(dto.getTitle())
                .originalText(dto.getOriginalText())
                .category(dto.getCategory())
                .user(user)
                .build();

        return postRepository.save(post);
    }
}