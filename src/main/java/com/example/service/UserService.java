package com.example.service;

import com.example.domain.user.User;
import com.example.dto.UserRequestDto;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User signup(UserRequestDto request) {
        // 이메일 중복 체크
        if (userRepo.findByEmail(request.email).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        User user = User.builder()
                .email(request.email)
                .password(request.password)
                .build();

        return userRepo.save(user);
    }
}