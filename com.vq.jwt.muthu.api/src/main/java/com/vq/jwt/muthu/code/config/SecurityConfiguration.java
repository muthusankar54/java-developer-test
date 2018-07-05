//package com.vq.jwt.muthu.code.config;
//
//import com.vq.jwt.muthu.code.security.JWTAuthentication;
//import com.vq.jwt.muthu.code.security.JWTAuthorization;
//import com.vq.jwt.muthu.code.service.UserDetailServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import static com.vq.jwt.muthu.code.config.SecuirityConstants.API_V1_AUTH;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private final UserDetailServiceImpl userDetailServiceImpl;
//
//
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public SecurityConfiguration(UserDetailServiceImpl userDetailServiceImpl, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userDetailServiceImpl = userDetailServiceImpl;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    @Override
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable().authorizeRequests()
//                .antMatchers(HttpMethod.POST, API_V1_AUTH).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JWTAuthentication(authenticationManager()))
//                .addFilter(new JWTAuthorization(authenticationManager(),userDetailServiceImpl));
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailServiceImpl).passwordEncoder(bCryptPasswordEncoder);
//    }
//
//}