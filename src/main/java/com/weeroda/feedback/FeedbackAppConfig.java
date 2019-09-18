package com.weeroda.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class FeedbackAppConfig {
    @Value("${accessToken.signingKey}")
    private String securityTokenKey;

    @Bean
    public TokenStore tokenStore(@Autowired JwtAccessTokenConverter accessTokenConverter) {
        return new JwtTokenStore(accessTokenConverter);
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(securityTokenKey);
        return converter;
    }

    @Bean(name = "authorizationServerTokenServices")
    public AuthorizationServerTokenServices authorizationServerTokenServices(@Autowired TokenStore tokenStore) {
        DefaultTokenServices defaultTokenServices = getDefaultTokenServices(tokenStore);
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }

    @Bean(name = "resourceServerTokenServices")
    public ResourceServerTokenServices resourceServerTokenServices(@Autowired TokenStore tokenStore) {
        DefaultTokenServices defaultTokenServices = getDefaultTokenServices(tokenStore);
        return defaultTokenServices;
    }

    private DefaultTokenServices getDefaultTokenServices(@Autowired TokenStore tokenStore) {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore);
        return defaultTokenServices;
    }
}
