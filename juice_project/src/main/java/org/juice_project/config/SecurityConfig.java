package org.juice_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests((authorizeHttpRequests) ->
                authorizeHttpRequests
                    .requestMatchers(
                            new AntPathRequestMatcher("/home/**"),
                            new AntPathRequestMatcher("/personnel/**"))
                    .authenticated()
                    .anyRequest().permitAll()
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/home/login")
                    .usernameParameter("employeeId")
                    .defaultSuccessUrl("/home/home")
                    .failureUrl("/home/login-failure")
                    .permitAll()
            )
            .logout(logout ->
                logout
                    .logoutUrl("/home/logout")
                    .logoutSuccessUrl("/home/login")
                    .deleteCookies("JSESSIONID", "remember-me")
                    .invalidateHttpSession(true)
                    .permitAll()
            )
            .rememberMe(rememberMe ->
                rememberMe
                    .key("uniqueAndSecret")
                    .tokenValiditySeconds(86400)
            )
        ;
        return http.build();
    }
}
