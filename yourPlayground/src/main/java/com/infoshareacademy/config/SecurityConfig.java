package com.infoshareacademy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String HOME_PAGE = "/";
    private static final String DASHBOARD_PAGE = "/dashboard";
    private static final String SIGN_IN_PAGE = "/sign-in";
    private static final String SIGN_IN_API = "/api/sign-in";
    private static final String SIGN_OUT_API = "/api/sign-out";
    private static final String SIGN_UP = "/registration";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // @formatter:off
        http
            .authorizeRequests()
                .mvcMatchers("/css/**", "/assets/**",
                        HOME_PAGE,
                        SIGN_IN_PAGE,
                        SIGN_IN_API,
                        SIGN_UP).permitAll()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                    .loginPage(SIGN_IN_PAGE)
                    .loginProcessingUrl(SIGN_IN_API)
                    .defaultSuccessUrl(DASHBOARD_PAGE, true)
                    .failureUrl(SIGN_IN_PAGE + "?error")
            .and()
                .logout()
                    .logoutUrl(SIGN_OUT_API)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl(HOME_PAGE);
        // @formatter:on

        return http.build();
    }
}
