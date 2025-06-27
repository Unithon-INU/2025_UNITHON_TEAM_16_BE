package com.example.controller;

import com.example.domain.comment.Comment;
import com.example.domain.comment.TranslatedComment;
import com.example.domain.language.Language;
import com.example.domain.post.Post;
import com.example.domain.post.TranslatedPost;
import com.example.dto.PostRequestDto;
import com.example.dto.PostTranslationResponseDto;
import com.example.dto.PostUpdateRequestDto;
import com.example.repository.*;
import com.example.service.PostService;
import com.example.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final TranslatedPostRepository translatedPostRepository;
    private final TranslatedCommentRepository translatedCommentRepository;
    private final TranslationService translationService;
    private final LanguageRepository languageRepository;


    @GetMapping("/{postId}/translated")
    public ResponseEntity<PostTranslationResponseDto> getTranslatedPost(
            @PathVariable Long postId,
            @RequestParam String lang
    ) throws Exception {

        Post post = postRepository.findById(postId).orElseThrow();
        List<Comment> comments = commentRepository.findByPost(post);

        // 1. GPT로 번역 요청
        PostTranslationResponseDto response = translationService.translatePostWithComments(post, comments, lang);

        // 2. 응답 먼저 보내기 (프론트엔드로 번역 결과 전송)
        ResponseEntity<PostTranslationResponseDto> clientResponse = ResponseEntity.ok(response);

        // 3. 그 후 DB 저장
        Language language = languageRepository.findByCode(lang)
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 언어 코드: " + lang));

        TranslatedPost translatedPost = new TranslatedPost(post, language, response.getTitle(), response.getTranslatedText());
        translatedPostRepository.save(translatedPost);

        for (int i = 0; i < comments.size(); i++) {
            TranslatedComment translatedComment = new TranslatedComment(comments.get(i), language, response.getComments().get(i));
            translatedCommentRepository.save(translatedComment);
        }

        return clientResponse;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequestDto dto) {
        Post created = postService.createPost(dto);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto dto) {
        postService.updatePost(id, dto);
        return ResponseEntity.ok("게시글이 수정되었습니다.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok("게시글이 삭제되었습니다.");
    }
}