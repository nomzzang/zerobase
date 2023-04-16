package com.zerobase.fastlms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        OrRequestMatcher publicRequestMatchers = new OrRequestMatcher(
                new AntPathRequestMatcher("/"),
                new AntPathRequestMatcher("/member/register"),
                new AntPathRequestMatcher("/member/email-auth")
        );

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(publicRequestMatchers::matches).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults()) // Enable default form login
                .csrf().disable();
        return http.build();
    }
}