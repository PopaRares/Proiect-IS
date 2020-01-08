package com.IS.SINU.security.jwt;

import com.IS.SINU.entities.CurrentUser;
import com.IS.SINU.entities.enums.Role;
import com.google.common.hash.Hashing;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class JwtTokenFilter extends GenericFilterBean {

    private JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletResponse response = (HttpServletResponse) res;
            HttpServletRequest request = (HttpServletRequest) req;
            String regURL = request.getRequestURL().toString();
            if (!regURL.contains("/login") && !regURL.contains("/user/registration") && !regURL.contains("/user/activate")) {
                String token = jwtTokenProvider.resolveToken((HttpServletRequest) req);
                jwtTokenProvider.memoriseUser(token);
                if (token != null && jwtTokenProvider.getAuthentication(token) != null) {
                    Authentication auth = jwtTokenProvider.getAuthentication(token);

                    if (auth != null) {
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }
            }
            chain.doFilter(req, res);
        } catch (Exception E) {
            HttpServletResponse response = (HttpServletResponse) res;
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            System.out.println(E.getMessage());
            response.getWriter().print("Forbidden!");
        }
    }


}
