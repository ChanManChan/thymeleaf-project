package com.u4.projectmanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired // for jdbc authentication (h2 | postgres)
    DataSource dataSource;

    @Autowired
    BCryptPasswordEncoder bcryptEncoder; // in WebConfig

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from user_accounts where username = ?")
                .authoritiesByUsernameQuery("select username, role from user_accounts where username = ?")
                .passwordEncoder(bcryptEncoder); //<- decoding, not encoding the password (retrieval)
//                .withDefaultSchema()
//                .withUser("nandu")
//                .password("pass")
//                .roles("USER")
//            .and()
//                .withUser("gopal")
//                .password("pass")
//                .roles("USER")
//            .and()
//                .withUser("manager")
//                .password("pass")
//                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/projects/new").hasRole("ADMIN")
                .antMatchers("/projects/save").hasRole("ADMIN")
                .antMatchers("/employees/new").hasRole("ADMIN")
                .antMatchers("/employees/save").hasRole("ADMIN")
//                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/", "/**").permitAll()
                .and().formLogin();

        http.csrf().disable();
//        http.headers().frameOptions().disable();
    }
}
