package com.prasad;

import com.prasad.security.models.Authorization;
import com.prasad.security.repositories.AuthorizationRepository;
import com.prasad.security.services.JpaRegisteredClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private JpaRegisteredClientRepository jpaRegisteredClientRepository;

    @Autowired
    private AuthorizationRepository authorizationRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    void registerClient() {
//        RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
//                .clientId("oidc-client")
//                .clientSecret("$2a$12$KRj2H0Hh3zD6aUoSFeV0IOSbGq.bARGFZDg8lP3ygTOWEinWy4d6K")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//                .redirectUri("https://oauth.pstmn.io/v1/callback")
//                .postLogoutRedirectUri("https://oauth.pstmn.io/v1/callback")
//                .scope(OidcScopes.OPENID)
//                .scope(OidcScopes.PROFILE)
//                .scope("ADMIN")
//                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//                .build();
//
//        jpaRegisteredClientRepository.save(oidcClient);
//    }

//    @Test
//    void insertTempAuthorization() {
//        Authorization authorization = new Authorization();
//        authorization.setId("pqr");
//        Date date = new Date();
//        authorization.setAccessTokenIssuedAt(date.toInstant());
//        authorization.setAccessTokenExpiresAt(date.toInstant());
//        authorization.setAuthorizationCodeValue("CP_bGHb3Nf2qAJ3NtKC17iGkZru3Wb4-DQpdk8kwywvBSPm98D3yEHEirQaxxguu0paXMg5VoiHgLEsrUBMByLAmm_hbaZ8V-GVJ8xR_kWVvYYGNMbYmwXKU5OF_UdH7");
//        authorizationRepository.save(authorization);
//
//    }

}
