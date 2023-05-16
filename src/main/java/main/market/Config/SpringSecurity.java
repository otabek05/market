package main.market.Config;

import main.market.Security.JWTConfigure;
import main.market.Security.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

 private final JwtTokenProvider jwtTokenProvider;

    public SpringSecurity(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .cors()
                .and()
                .headers()
                .and()
                .authorizeRequests()
                .antMatchers("/account").hasRole("USER")
                .antMatchers("/item/data").hasRole("USER")
                .antMatchers("/api/register").permitAll()
                .antMatchers("/api/products").permitAll()
                .antMatchers("/api/product").permitAll()
                .antMatchers("/api/product/{id}").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .apply(securityConfigureAdapter());
    }
    private JWTConfigure securityConfigureAdapter(){
        return new JWTConfigure(jwtTokenProvider);
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
