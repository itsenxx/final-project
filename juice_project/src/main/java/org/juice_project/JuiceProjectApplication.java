package org.juice_project;

import jakarta.servlet.http.HttpSessionListener;
import org.juice_project.config.listener.SessionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JuiceProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(JuiceProjectApplication.class, args);
	}

	@Bean
	public HttpSessionListener httpSessionListener() {
		return new SessionListener();
	}
}
