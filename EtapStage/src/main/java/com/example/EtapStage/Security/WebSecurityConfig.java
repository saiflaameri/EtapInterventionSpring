package com.example.EtapStage.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.httpBasic();
        http.authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST,"/user/**")
                .hasAnyRole("ADMIN","INTERVENANT")
                .requestMatchers(HttpMethod.POST,"/GroupeProjet/**")
                .hasRole("UTILISATEUR").and().csrf().disable();
        return null;
    }


}
