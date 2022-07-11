package com.student.registrations.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/students/addStudent","/students/saveStudent").hasAnyAuthority("USER","ADMIN")
                .antMatchers("/students/deleteStudent", "/students/updateStudent").hasAuthority("ADMIN")
                .antMatchers("/students/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().successForwardUrl("/students/home").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login").permitAll();
    }

    /*@Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().successForwardUrl("/students/home").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login").permitAll();
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN")
                .and()
                .withUser("user").password("12345").roles("USER");
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
