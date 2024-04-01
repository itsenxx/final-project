package org.juice_project.config.listener;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionListener implements HttpSessionListener {
    private int sessionTime = 10;

    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setMaxInactiveInterval(sessionTime);
    }

    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
