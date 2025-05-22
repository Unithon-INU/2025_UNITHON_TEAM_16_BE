package com.example.config;

import com.example.domain.user.User;
import com.example.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setName("테스트유저");
            user.setEmail("test@example.com");
            user.setPassword("1234");
            userRepository.save(user);
            System.out.println("🟢 테스트용 유저 생성됨 (ID: " + user.getUserId() + ")");
        }
    }
}