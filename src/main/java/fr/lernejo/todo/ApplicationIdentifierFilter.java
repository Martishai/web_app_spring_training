package fr.lernejo.todo;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements Filter {

    private final String instanceId = UUID.randomUUID().toString();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (response instanceof HttpServletResponse res) {
            res.setHeader("Instance-Id", instanceId);
        }
        chain.doFilter(request, response);
    }
}

