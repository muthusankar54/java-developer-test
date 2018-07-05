package com.vq.jwt.muthu.code.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vq.jwt.muthu.code.domain.CustomUserDetails;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

import static com.vq.jwt.muthu.code.config.SecuirityConstants.EXPIRATION_TIME;
import static com.vq.jwt.muthu.code.config.SecuirityConstants.HEADER_STRING;
import static com.vq.jwt.muthu.code.config.SecuirityConstants.TOKEN_PREFIX;
import static com.vq.jwt.muthu.code.config.SecuirityConstants.SECRET;


public class JWTAuthentication  extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthentication(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        System.out.println("Security filter attemptAuthentication==>");
        try {
            CustomUserDetails creds = new ObjectMapper()
                    .readValue(req.getInputStream(), CustomUserDetails.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        System.out.println("Security filter successfulAuthentication==>");
        ZonedDateTime expirationTimeUTC = ZonedDateTime.now(ZoneOffset.UTC).plus(EXPIRATION_TIME, ChronoUnit.MILLIS);
        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        System.out.println("token==>"+token);
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }

}