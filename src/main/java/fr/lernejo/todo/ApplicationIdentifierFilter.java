package fr.lernejo.todo;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements Filter {
    UUID uuid = UUID.randomUUID();
    String uuidAsString = uuid.toString();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletResponse instanceof HttpServletResponse httpResp) {
            httpResp.setHeader("Instance-Id", uuidAsString);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}



