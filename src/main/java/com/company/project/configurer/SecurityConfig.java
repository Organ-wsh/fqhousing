package com.company.project.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description:
 * @Author: wangsh
 * @Date: 2020/5/21 10:30
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          auth.inMemoryAuthentication().withUser("wsh").password("12345").roles("admin")
                  .and()
                  .withUser("admin").password("1234").roles("superadmin")
                  .and()
                  .withUser("book").password("1234").roles("book");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("admin/**").hasRole("admin")
                .antMatchers("book/**").hasRole("book")
                .antMatchers("user/**").hasAnyRole("admin","user")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/doLogin")
                .permitAll()
                .and()
                .csrf().disable();
    }
}
