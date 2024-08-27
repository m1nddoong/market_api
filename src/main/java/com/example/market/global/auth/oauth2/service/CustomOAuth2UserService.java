package com.example.market.global.auth.oauth2.service;

import com.example.market.global.auth.oauth2.dto.GoogleResponse;
import com.example.market.global.auth.oauth2.dto.NaverResponse;
import com.example.market.global.auth.oauth2.dto.OAuth2Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    // userRequest : 리소스 서버에서 받은 유저 정보
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info(String.valueOf(oAuth2User));

        // 서비스가 naver에서 온 요청인지 google 에서 온 요청인지를 확인하기 위한 registrationId
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;
        if (registrationId.equals("naver")) {
            // 받은 oauth2User 변수에서 getAttribute 로 꺼내서 응답으로 넣어주기
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());
        }
        else if (registrationId.equals("google")) {
            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        }
        else {
            return null;
        }

        // 로그인을 완료하였을 때
    }
}
