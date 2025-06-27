package com.example.service;

import com.example.domain.comment.Comment;
import com.example.domain.post.Post;
import com.example.dto.PostTranslationRequestDto;
import com.example.dto.PostTranslationResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

@Service
public class TranslationService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${openai.api-key}")
    private String OPENAI_API_KEY;

    private final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

    public PostTranslationResponseDto translatePostWithComments(Post post, List<Comment> comments, String targetLang) throws Exception {
        // 요청 DTO 생성
        PostTranslationRequestDto request = new PostTranslationRequestDto(
                post.getTitle(),
                post.getOriginalText(),
                comments.stream().map(Comment::getOriginalText).toList()
        );

        // JSON 문자열로 직렬화
        String json = objectMapper.writeValueAsString(request);

        // GPT 프롬프트 구성
        String prompt = String.format("""
            Translate the following JSON to %s. Keep the JSON structure exactly the same:
            %s
        """, targetLang, json);

        // GPT 요청 바디 구성
        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(
                        Map.of("role", "user", "content", prompt)
                )
        );

        // HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(OPENAI_API_KEY);

        // 요청 바디 + 헤더를 HttpEntity로 래핑
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // GPT API 호출
        ResponseEntity<Map> response = restTemplate.exchange(OPENAI_URL, HttpMethod.POST, entity, Map.class);

        // 응답 파싱 (중간 타입 안전하게 처리)
        Map responseBody = response.getBody();
        List choices = (List) responseBody.get("choices");
        Map choice = (Map) choices.get(0);
        Map message = (Map) choice.get("message");
        String content = (String) message.get("content");

        // 번역된 JSON 문자열 → DTO로 변환
        return objectMapper.readValue(content, PostTranslationResponseDto.class);
    }
}
