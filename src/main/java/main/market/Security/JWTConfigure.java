package main.market.Security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTConfigure extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenProvider jwtTokenProvider;

    public JWTConfigure(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void configure(HttpSecurity http){
        JWTFilter jwtFilter = new JWTFilter(jwtTokenProvider);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
