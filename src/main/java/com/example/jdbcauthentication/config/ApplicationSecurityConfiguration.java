package com.example.jdbcauthentication.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public final DataSource dataSource;

    public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder, DataSource dataSource) {
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
    }


    /**
     * It is used for authorization
     * @param http HttpSecurity Object
     * @throws Exception throwing exception on error
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final String ADMIN_ROLE = "ADMIN";
        final String USER_ROLE = "USER";
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasAnyRole(ADMIN_ROLE,USER_ROLE)
                .antMatchers("/admin/**").hasRole(ADMIN_ROLE)
                .and()
                .formLogin();
    }


    /**
     * It is used for Authentication
     * @param auth AuthenticationManagerBuilder object
     * @throws Exception throwing exception on error
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .jdbcAuthentication()
                .passwordEncoder(passwordEncoder)
                .dataSource(dataSource);
    }
}
