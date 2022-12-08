package org.example.id.filter;

import org.example.id.manager.AuthManager;
import org.example.id.security.Authentication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthFilter extends HttpFilter {
    private final AuthManager authManager;

    @Override
    protected void doFilter(final HttpServletRequest req, final HttpServletResponse res, final FilterChain chain) throws IOException, ServletException, ServletException {
        final String token = req.getHeader("X-Token");
        log.debug("token: {}", token);

        if (token == null) {
            final Authentication authentication = Authentication.anonymous();
            req.setAttribute("authentication", authentication);
        } else {
            try {
                final Authentication authentication = authManager.authenticateByToken(
                        token
                );
                req.setAttribute("authentication", authentication);
            } catch (RuntimeException e) {
                res.setStatus(401);
                res.getWriter().write("Not authenticated");
                return;
            }
        }

        chain.doFilter(req, res);
    }
}