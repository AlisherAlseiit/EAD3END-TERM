package com.Alish.midka.security;

import com.Alish.midka.Service.UserService;
import com.Alish.midka.jwt.JwtConfig;
import com.Alish.midka.jwt.JwtTokenVerifier;
import com.Alish.midka.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;
    private final JwtConfig jwtConfig;
    private UserService applicationUserService;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, JwtConfig jwtConfig, UserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.jwtConfig = jwtConfig;
        this.applicationUserService = applicationUserService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig))
                .addFilterAfter(new JwtTokenVerifier(jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                //                      change / to /** to show swagger

                .antMatchers(HttpMethod.DELETE,"/users/**","/products/**", "/orders/**", "/addresses/**", "/categories/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/products/**", "/addresses/**", "/categories/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/orders/**").hasAnyAuthority("USER", "ADMIN", "ADMINTRAINEE")
                .antMatchers(HttpMethod.PUT,"/users/**", "/products/**",  "/orders/**", "/addresses/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/users/**", "/products/**", "/orders/**").hasAnyAuthority("ADMIN","USER", "ADMINTRAINEE")
                .antMatchers("/users/signUp").permitAll()
                .antMatchers("/api/**").permitAll()
                .anyRequest()
                .authenticated();

    }


        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/v2/api-docs",
                    "/configuration/ui",
                    "/swagger-resources/**",
                    "/configuration/security",
                    "/swagger-ui.html",
                    "/webjars/**", "/");
        }





    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }
}

