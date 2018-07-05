package com.vq.jwt.muthu.code.security;

import com.vq.jwt.muthu.code.domain.CustomUserDetails;
import com.vq.jwt.muthu.code.service.UserDetailServiceImpl;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.vq.jwt.muthu.code.config.SecuirityConstants.HEADER_STRING;
import static com.vq.jwt.muthu.code.config.SecuirityConstants.SECRET;
import static com.vq.jwt.muthu.code.config.SecuirityConstants.TOKEN_PREFIX;

public class JWTAuthorization extends BasicAuthenticationFilter {

    private final UserDetailServiceImpl userDetailService;

    public JWTAuthorization(AuthenticationManager authManager,UserDetailServiceImpl userDetailService) {
        super(authManager);
        this.userDetailService=userDetailService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(CustomUserDetails.class, null);
            }
            return null;
        }
        return null;
    }
}