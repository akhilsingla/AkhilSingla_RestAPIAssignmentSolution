package com.greatlearning.config;

import com.greatlearning.service.PasswordEncoderService;
import com.greatlearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userServiceJpaImpl")
    private UserService userService;

    @Autowired
    private PasswordEncoderService passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers(HttpMethod.POST, "/api/employees/**").hasAuthority("ADMIN").
                antMatchers(HttpMethod.PUT, "/api/employees/**").hasAnyAuthority("ADMIN", "USER").
                antMatchers(HttpMethod.DELETE, "/api/employees/**").hasAuthority("ADMIN").
                antMatchers(HttpMethod.GET, "/api/employees/**").permitAll().
                antMatchers(HttpMethod.POST,"/api/roles/**").hasAuthority("ADMIN").
                antMatchers(HttpMethod.POST,"/api/users/**").hasAuthority("ADMIN").
                and().httpBasic().
                and().csrf().disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder.getPasswordEncoder());
        return auth;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/h2/**");
    }
}
