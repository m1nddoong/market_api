package com.example.market.common.util;

import com.example.market.auth.entity.BusinessStatus;
import com.example.market.auth.entity.User;
import com.example.market.auth.repo.UserRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
@RequiredArgsConstructor
public class AdminInitializer implements ApplicationRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 관리자 계정
        userRepository.save(User.builder()
                .uuid(UUID.randomUUID())
                .email("admin123@naver.com")
                .password(passwordEncoder.encode("1111"))
                .username("김태호")
                .nickname("관리자")
                .age(26)
                .phone("010-3637-6533")
                .profileImg(null)
                .businessNum("605-46-5452")
                .businessStatus(BusinessStatus.APPROVED)
                .authorities("ROLE_ACTIVE,ROLE_OWNER,ROLE_ADMIN")
                .build());

        // 사업자 사용자
        userRepository.save(User.builder()
                .uuid(UUID.randomUUID())
                .email("owner123@naver.com")
                .password(passwordEncoder.encode("2222"))
                .username("유재석")
                .nickname("사업자 사용자")
                .age(40)
                .phone("010-7878-1313")
                .profileImg(null)
                .businessNum("603-46-2424")
                .businessStatus(BusinessStatus.APPROVED)
                .authorities("ROLE_ACTIVE,ROLE_OWNER")
                .build());

        // 일반 사용자 1
        userRepository.save(User.builder()
                .uuid(UUID.randomUUID())
                .email("user1@naver.com")
                .password(passwordEncoder.encode("3333"))
                .username("박명수")
                .nickname("일반 사용자1")
                .age(37)
                .phone("010-3535-0909")
                .profileImg(null)
                .businessNum("623-46-2424")
                .businessStatus(BusinessStatus.APPROVED)
                .authorities("ROLE_ACTIVE,ROLE_OWNER")
                .build());

        // 일반 사용자 2
        userRepository.save(User.builder()
                .uuid(UUID.randomUUID())
                .email("user2@naver.com")
                .password(passwordEncoder.encode("4444"))
                .username("정준하")
                .nickname("일반 사용자2")
                .age(37)
                .phone("010-3535-0909")
                .profileImg(null)
                .businessNum("533-24-4699")
                .businessStatus(BusinessStatus.APPLIED)
                .authorities("ROLE_ACTIVE")
                .build());

        // 일반 사용자 3
        userRepository.save(User.builder()
                .uuid(UUID.randomUUID())
                .email("user3@naver.com")
                .password(passwordEncoder.encode("5555"))
                .username("정형돈")
                .nickname("일반 사용자3")
                .age(37)
                .phone("010-9393-1616")
                .profileImg(null)
                .businessNum(null)
                .businessStatus(null)
                .authorities("ROLE_ACTIVE")
                .build());

        // 일반 사용자 4
        userRepository.save(User.builder()
                .uuid(UUID.randomUUID())
                .email("user5@naver.com")
                .password(passwordEncoder.encode("6666"))
                .username("하하")
                .nickname("비활성 사용자")
                .age(null)
                .phone(null)
                .profileImg(null)
                .businessNum(null)
                .businessStatus(null)
                .authorities("ROLE_INACTIVE")
                .build());
    }
}
