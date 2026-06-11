package com.Saas.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;

public class JwtValidator extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        
        String jwt = request.getHeader(JwtConstant.JWT_HEADER);

        if (jwt != null){
            jwt = jwt.substring(7);

            try{
                SecretKey key = Keys.hmacShaKeyFor(JwtConstant.JWT_SECRET.getBytes());
                Claims claims = Jwts.parser()
            }
        }

    }
}
