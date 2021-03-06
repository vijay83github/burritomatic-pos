package com.burritomatic.pos.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic().disable()   
                .authorizeRequests()
                .antMatchers("/", "/pos/menu/*").permitAll()
                .anyRequest().permitAll()
                .and().httpBasic().disable().csrf().disable() 
                .authorizeRequests()
                .antMatchers("/", "/pos/order/*").permitAll()
                .anyRequest().permitAll()
                .and().httpBasic().disable().csrf().disable() 
            /*.formLogin()
                .loginPage("/login")
                .permitAll()
                .and().httpBasic().disable()
            .logout()
                .permitAll()*/;
        
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
